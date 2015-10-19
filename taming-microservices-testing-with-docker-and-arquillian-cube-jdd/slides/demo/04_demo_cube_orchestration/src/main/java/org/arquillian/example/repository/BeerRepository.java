package org.arquillian.example.repository;

import org.arquillian.example.domain.Beer;
import org.arquillian.example.domain.Brewery;
import org.arquillian.example.domain.Country;

import java.util.Set;

public interface BeerRepository {

    void save(Beer beer);

    void save(Brewery brewery);

    void delete(Long id);

    void delete(Beer beer);

    Beer getById(Long id);

    Beer getByCode(String code);

    Set<Beer> cheapest();

    Set<Beer> strongest();

    Set<Beer> from(Country country);

    Set<Beer> fetchAll();

}