package org.example.DAO;

import org.example.Person;
import org.example.Todo;

import java.util.List;

public interface TodoItemsDAO {
    Todo create(Todo todo);

    List<Todo> findAll();

    Todo findById(int id);

    List<Todo> findByDoneStatus(boolean done);

    List<Todo> findByAssignee(int assigneeid);

    List<Todo> findByAssignee(Person person);

    List<Todo> findByUnassignedTodoItems();

    Todo update(Todo todo);

    boolean deleteById(int id);
}
