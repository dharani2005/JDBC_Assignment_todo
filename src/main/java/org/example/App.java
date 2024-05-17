package org.example;

import org.example.DAOImple.PersonDAOImpl;
import org.example.DAOImple.TodoItemsDAOImpl;

import java.time.LocalDate;
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
       /* PersonDAOImpl personDAOImpl = new PersonDAOImpl();
        Person person = new Person("radhe","syam");
        System.out.println(personDAOImpl.create(person));
        List<Person> personList = personDAOImpl.findAll();
        System.out.println(personList);
        System.out.println(personDAOImpl.findById(1));
        System.out.println(personDAOImpl.findByName("radhe"));
        Person person1 = new Person("sree","syam");
        System.out.println(personDAOImpl.update(person1));
        System.out.println(personDAOImpl.deleteById(5));*/
        TodoItemsDAOImpl todoItem = new TodoItemsDAOImpl();
        Todo todo = new Todo("title","working", LocalDate.of(2024,05,17),true,1);
        /*System.out.println(todoItem.create(todo));
        System.out.println(todoItem.findAll());
        System.out.println(todoItem.findById(2));
        List<Todo> todoList = todoItem.findByAssignee(1);
        System.out.println(todoList);
        Todo todo1 = new Todo("java","connecting to data", LocalDate.of(2024,05,17),true,2);
        System.out.println(todoItem.update(todo1));
        System.out.println(todoItem.deleteById(3));*/
        List<Todo> todos = todoItem.findByDoneStatus(true);
        System.out.println(todos);

    }
}
