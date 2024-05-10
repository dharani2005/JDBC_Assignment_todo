package org.example.DAOImple;
import org.example.DAO.TodoItemsDAO;
import org.example.Person;
import org.example.Todo;

import java.util.List;

public class TodoItemsDAOImpl implements TodoItemsDAO {
    @Override
    public Todo create(Todo todo) {
        return null;
    }

    @Override
    public List<Todo> findAll() {
        return null;
    }

    @Override
    public Todo findById(int id) {
        return null;
    }

    @Override
    public List<Todo> findByDoneStatus(boolean done) {
        return null;
    }

    @Override
    public List<Todo> findByAssignee(int assigneeid) {
        return null;
    }

    @Override
    public List<Todo> findByAssignee(Person person) {
        return null;
    }

    @Override
    public List<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
