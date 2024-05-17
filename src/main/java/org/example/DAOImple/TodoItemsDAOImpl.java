package org.example.DAOImple;

import connection.MySqlConnection;
import org.example.DAO.TodoItemsDAO;
import org.example.Person;
import org.example.Todo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TodoItemsDAOImpl implements TodoItemsDAO {
    @Override
    public Todo create(Todo todo) {
        String query = "insert into todo_item(title,description,deadline,done,assignee_id)values(?, ?, ?,?, ?)";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setDate(3, Date.valueOf(todo.getDeadline()));
            preparedStatement.setBoolean(4,todo.isDone());
            preparedStatement.setInt(5, todo.getAssigneeId());
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("successfully added the todo item");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Todo item in not added" + e.getMessage());
        }
        return todo;
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> todoList = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("select * from todo_item")) {
                while (resultSet.next()) {
                    int todoId = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    LocalDate deadline = resultSet.getDate(4).toLocalDate();
                    boolean done = resultSet.getBoolean(5);
                    int asigneeId = resultSet.getInt(5);
                    Todo todo = new Todo(todoId, title, description, deadline, done, asigneeId);
                    todoList.add(todo);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Todo items list is not found" + e.getMessage());
        }
        return todoList;
    }

    @Override
    public Todo findById(int id) {
        Todo todo = null;
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from todo_item where todo_id= ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int todoId = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    LocalDate deadline = resultSet.getDate(4).toLocalDate();
                    boolean done = resultSet.getBoolean(5);
                    int assigneeId = resultSet.getInt(6);
                    todo = new Todo(todoId, title, description, deadline, done, assigneeId);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("todo item with this id is not found" + e.getMessage());
        }
        return todo;
    }

    @Override
    public List<Todo> findByDoneStatus(boolean done) {
        List<Todo> todoList = new ArrayList<>();
        String query = "select * from todo_item where done = ?";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, done);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int todoId = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    LocalDate deadline = resultSet.getDate(4).toLocalDate();
                    boolean isDone = resultSet.getBoolean(5);
                    int assigneeId = resultSet.getInt(6);
                    Todo todo = new Todo(todoId, title, description, deadline, isDone, assigneeId);
                    todoList.add(todo);
                }
            }

        } catch (SQLException e) {
            System.out.println("List of todo_items with this done status is not found" + e.getMessage());

        }

        return todoList;
    }

    @Override
    public List<Todo> findByAssignee(int assigneeid) {
        List<Todo> todoList = new ArrayList<>();
        String query = "select * from todo_item where assignee_id = ?";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, assigneeid);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int todoId = resultSet.getInt(1);
                    String title = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    LocalDate deadline = resultSet.getDate(4).toLocalDate();
                    boolean done = resultSet.getBoolean(5);
                    int assigneeId = resultSet.getInt(6);
                    Todo todo = new Todo(todoId, title, description, deadline, done, assigneeId);
                    todoList.add(todo);


                }
            }

        } catch (SQLException e) {
            System.out.println("List of todo is not found with this assigneeid"+e.getMessage());
        }
        return todoList;
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
        String query = "update todo_item set title = ?,description = ?,deadline = ?,done = ?";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setDate(3, Date.valueOf(todo.getDeadline()));
            preparedStatement.setBoolean(4, todo.isDone());
            int rowUpdated = preparedStatement.executeUpdate();
            if (rowUpdated > 0) {
                System.out.println("Todo item updated successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Todo item is not updated" + e.getMessage());
        }

        return todo;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "delete from todo_item where todo_id = ?";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1,id);
            int rowDeleted = preparedStatement.executeUpdate();
            if (rowDeleted > 0) {
                System.out.println("Successfully row deleted");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Todo item with this id is not deleted" + e.getMessage());
        }
        return false;
    }
}
