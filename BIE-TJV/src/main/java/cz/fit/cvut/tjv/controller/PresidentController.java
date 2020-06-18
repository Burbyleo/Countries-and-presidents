package cz.fit.cvut.tjv.controller;

import cz.fit.cvut.tjv.model.President;
import cz.fit.cvut.tjv.service.PresidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("president")
public class PresidentController {

    @Autowired
    private PresidentService presidentService;

    /*
     * GET: http://localhost:8080/president/all
     *
     */
    @GetMapping(path = "all", produces = "application/json")
    public List<President> findAll() {
        return presidentService.findAll();
    }

    /*
     * GET: http://localhost:8080/president/findByCountry
     * BODY example: Czech Republic
     */
    @GetMapping(path = "findByCountry", produces = "application/json")
    private President findByCountry(@RequestBody String name) {
        return presidentService.findByCountry(name);
    }

}
