package cz.fit.cvut.tjv.service;

import cz.fit.cvut.tjv.model.Country;
import cz.fit.cvut.tjv.model.President;
import cz.fit.cvut.tjv.repository.PresidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PresidentService {

    @Autowired
    private PresidentRepository presidentRepository;

    public List<President> findAll() {
        List<President> all = new ArrayList<>();
        presidentRepository.findAll().forEach(all::add);
        return all;
    }

    public President findByCountry(String name) {
        Country country = new Country(name);
        return presidentRepository.findByCountry(country).orElse(null);
    }

}
