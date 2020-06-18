package cz.fit.cvut.tjv.service;

import cz.fit.cvut.tjv.model.Country;
import cz.fit.cvut.tjv.model.Person;
import cz.fit.cvut.tjv.repository.CountryRepository;
import cz.fit.cvut.tjv.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CountryRepository countryRepository;

    public Person createPerson(String name, String surname, String ...countryNames) {
        if (countryNames.length == 0) throw new RuntimeException("Person must live in a country");

        Set<Country> countrySet = new HashSet<>();

        for (int i = 0; i < countryNames.length; i++) {
            Country country = countryRepository.findByName(countryNames[i])
                    .orElseThrow(() -> new RuntimeException("Country doesn't exist"));
            countrySet.add(country);
        }

        Person person = new Person(name, surname, countrySet);
        return personRepository.save(person);
    }

    public Person findByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndAndSurname(name, surname).orElse(null);
    }

}
