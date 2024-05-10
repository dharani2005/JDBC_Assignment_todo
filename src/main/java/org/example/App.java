package org.example;

import org.example.DAOImple.PersonDAOImpl;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        PersonDAOImpl personDAOImpl = new PersonDAOImpl();
        Person person = new Person("radhe","syam");
        System.out.println(personDAOImpl.create(person));
        List<Person> personList = personDAOImpl.findAll();
        System.out.println(personList);
        System.out.println(personDAOImpl.findById(1));
        System.out.println(personDAOImpl.findByName("radhe"));
    }
}
