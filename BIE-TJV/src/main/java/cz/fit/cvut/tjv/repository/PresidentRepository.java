package cz.fit.cvut.tjv.repository;

import cz.fit.cvut.tjv.model.Country;
import cz.fit.cvut.tjv.model.President;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PresidentRepository extends CrudRepository<President, Integer> {

    @Override
    Iterable<President> findAll();

    @Override
    Optional<President> findById(Integer integer);

    Optional<President> findByCountry(Country country);

    @Override
    <S extends President> S save(S s);

    @Override
    void deleteById(Integer integer);

}
