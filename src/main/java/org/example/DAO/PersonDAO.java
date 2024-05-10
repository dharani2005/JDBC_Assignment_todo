package org.example.DAO;

import org.example.Person;

import java.util.List;

public interface PersonDAO {
    Person create(Person person);

    List<Person> findAll();

    Person findById(int id);

    List<Person> findByName(String name);

    Person update(Person person);

    boolean deleteById(int id);


}
