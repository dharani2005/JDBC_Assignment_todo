package org.example.DAOImple;

import connection.MySqlConnection;
import org.example.DAO.PersonDAO;
import org.example.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {
    @Override
    public Person create(Person person) {
        String query = "insert into person(first_name,last_name)values(?, ?)";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Successfully added the person");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("person detailes are not created" + e.getMessage());
        }
        return person;
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();
        try (Connection connection = MySqlConnection.getConnection();
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("select * from person")) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Person person = new Person(id, firstName, lastName);
                    personList.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can not find list of all persons" + e.getMessage());
        }
        return personList;
    }

    @Override
    public Person findById(int id) {
        Person person = null;
        String query = "select * from person where person_id= ?";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int personId = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    person = new Person(personId, firstName, lastName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("person found by id" + e.getMessage());
        }
        return person;
    }

    @Override
    public List<Person> findByName(String name) {
        List<Person> personList = new ArrayList<>();
        String query = "select * from person where first_name like ?";
        try (Connection connection = MySqlConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String firstName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    Person person = new Person(id, firstName, lastName);
                    personList.add(person);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Person can not be found with this name" + e.getMessage());
        }
        return personList;
    }

    @Override
    public Person update(Person person) {
        String query = "update person set first_name = ?,last_name = ?";
        try(Connection connection = MySqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
        preparedStatement.setString(1, person.getFirstName());
        preparedStatement.setString(2, person.getLastName());
        int rowUpdated = preparedStatement.executeUpdate();
        if(rowUpdated>0){
            System.out.println("person updated successfully");
        }
        }catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("person detailes are not updated"+e.getMessage());
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "delete from person where person_id = ?";
        try(Connection connection = MySqlConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
        preparedStatement.setInt(1,id);
      int rowDeleted = preparedStatement.executeUpdate();
      if(rowDeleted > 0){
          System.out.println("successfully deleted");
          return true;
      }
        }catch (SQLException e){
         e.printStackTrace();
            System.out.println("person is not deleted"+e.getMessage());
        }
        return false;
    }
}
