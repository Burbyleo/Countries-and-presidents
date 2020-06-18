package cz.fit.cvut.tjv.repository;

import cz.fit.cvut.tjv.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Override
    Iterable<Person> findAll();

    @Override
    Optional<Person> findById(Integer integer);

    Optional<Person> findByNameAndAndSurname(String name, String surname);

    @Override
    <S extends Person> S save(S s);

    @Override
    void deleteById(Integer integer);

}
