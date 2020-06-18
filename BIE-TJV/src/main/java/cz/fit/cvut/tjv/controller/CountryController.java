package cz.fit.cvut.tjv.controller;

import cz.fit.cvut.tjv.model.Country;
import cz.fit.cvut.tjv.model.Person;
import cz.fit.cvut.tjv.model.President;
import cz.fit.cvut.tjv.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    /*
     * POST: http://localhost:8080/country/add
     * BODY example: SomeCountry
     */

    // Adding country
    @PostMapping(path = "add", consumes = "application/json", produces = "application/json")
    public @ResponseBody Country addCountry(@RequestBody String name) {
        return countryService.createCountry(name);
    }

    /*
     * POST: http://localhost:8080/country/addCitizen
     * BODY example: {
     *      "countryName": "AWDAWD",
     *      "person": {
     *          "name": "AWDAWD",
     *          "surname": "AWDAWD"
     *      }
     * }
     */


    @PostMapping(path = "addCitizen", consumes = "application/json", produces = "application/json")
    public void addCitizen(@RequestBody AddCitizenForm form) {
        countryService.addCitizen(form.getCountryName(), form.getPerson());
    }

    /*
     * POST: http://localhost:8080/country/setPresident
     * BODY example: {
     *      "countryName": "AWDAWD",
     *      "president": {
     *          "name": "AWDAWD",
     *          "surname": "AWDAWD"
     *      }
     * }
     */

    // Selecting President
    @PostMapping(path = "setPresident", consumes = "application/json", produces = "application/json")
    public @ResponseBody President setPresident(@RequestBody SetPresidentForm form) {
        return countryService.setPresident(form.getCountryName(), form.getPresident());
    }

    /*
     * DELETE: http://localhost:8080/country/delete/123
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        countryService.deleteById(id);
    }

    /*
     * GET: http://localhost:8080/country/all
     */
    @GetMapping(path = "all", produces = "application/json")
    public @ResponseBody List<Country> all() {
        return countryService.findAll();
    }


    private static class SetPresidentForm {

        private String countryName;
        private President president;

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public President getPresident() {
            return president;
        }

        public void setPresident(President president) {
            this.president = president;
        }
    }

    private static class AddCitizenForm {

        private String countryName;
        private Person person;

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public Person getPerson() {
            return person;
        }

        public void setPerson(Person person) {
            this.person = person;
        }
    }

}
