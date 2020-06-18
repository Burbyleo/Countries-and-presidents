package cz.fit.cvut.tjv.repository;

import cz.fit.cvut.tjv.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

    @Override
    Iterable<Country> findAll();

    @Override
    Optional<Country> findById(Integer integer);

    Optional<Country> findByName(String name);

    @Override
    <S extends Country> S save(S s);

    @Override
    void deleteById(Integer integer);



}
