package cz.fit.cvut.tjv.service;

import cz.fit.cvut.tjv.model.Country;
import cz.fit.cvut.tjv.model.Person;
import cz.fit.cvut.tjv.model.President;
import cz.fit.cvut.tjv.repository.CountryRepository;
import cz.fit.cvut.tjv.repository.PresidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PresidentRepository presidentRepository;


    public Country createCountry(String name) {
        Country country = new Country(name);

        return countryRepository.save(country);
    }

    public void addCitizen(String countryName, Person person) {
        Country country = countryRepository.findByName(countryName)
                .orElseThrow(() -> new RuntimeException("Country doesn't exist"));

        country.getCitizens().add(person);
        countryRepository.save(country);
    }

    public President setPresident(String countryName, President president) {
        Country country = countryRepository.findByName(countryName)
                .orElseThrow(() -> new RuntimeException("Country doesn't exist"));

        president.setYearsOnPosition(0);
        president.setCountry(country);

        return presidentRepository.save(president);
    }

    public void deleteById(int id) {
        countryRepository.deleteById(id);
    }

    public List<Country> findAll() {
        List<Country> all = new ArrayList<>();
        countryRepository.findAll().forEach(all::add);

        return all;
    }
}
