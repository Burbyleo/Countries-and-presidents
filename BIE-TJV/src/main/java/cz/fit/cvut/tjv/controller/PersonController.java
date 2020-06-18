package cz.fit.cvut.tjv.controller;

import cz.fit.cvut.tjv.model.Person;
import cz.fit.cvut.tjv.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    /*
     * POST: http://localhost:8080/person/create
     * BODY example: {
     *      "name": "AWDAWD",
     *      "surname": "AWDAWD",
     *      "countryNames": [
     *          "awdawd1", "awdawd2", "awdwd3"
     *      ]
     * }
     */

    // Creating a person
    @PostMapping(path = "create", consumes = "application/json", produces = "application/json")
    public @ResponseBody Person createPerson(@RequestBody CreatePersonForm form) {
        return personService.createPerson(form.getName(), form.getSurname(), form.getCountryNames());
    }

    /*
     * GET: http://localhost/person?name=AWDAWD&surname=AWDAWD
     */
    @GetMapping(produces = "application/json")
    public @ResponseBody Person findByNameAndSurname(@PathParam("name") String name,
                                                     @PathParam("surname") String surname) {
        return personService.findByNameAndSurname(name, surname);
    }




    private static class CreatePersonForm {

        private String name;
        private String surname;
        private String[] countryNames;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String[] getCountryNames() {
            return countryNames;
        }

        public void setCountryNames(String[] countryNames) {
            this.countryNames = countryNames;
        }
    }

}
