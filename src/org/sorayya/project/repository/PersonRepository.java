package org.sorayya.project.repository;

import org.sorayya.project.common.JDBC;
import org.sorayya.project.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;
 public PersonRepository() throws SQLException {
     this.connection = JDBC.getConnection();
 }

 public void insert(Person person) throws SQLException {
     preparedStatement = connection.prepareStatement("select person_seq.nextval idOfSequence from dual");
     ResultSet resultSet = preparedStatement.executeQuery();
     resultSet.next();
     person.setId(resultSet.getLong("idOfSequence"));
     preparedStatement = connection.prepareStatement("insert into person(id,name,family,salary) values(?,?,?,?)");
     preparedStatement.setLong(1,person.getId());
     preparedStatement.setString(2, person.getName());
     preparedStatement.setString(3, person.getFamily());
     preparedStatement.setLong(4,person.getSalary());
     preparedStatement.executeUpdate();

 }
public void update(Person person) throws SQLException {
     preparedStatement=connection.prepareStatement("update person set name=?, family=?,salary=? where id=?");
     preparedStatement.setString(1, person.getName());
     preparedStatement.setString(2,person.getFamily());
     preparedStatement.setLong(3,person.getSalary());
     preparedStatement.setLong(4,person.getId());
     preparedStatement.executeUpdate();
}

public void delete(Person person) throws Exception{
     preparedStatement = connection.prepareStatement("delete from person where id=?");
     preparedStatement.setLong(1,person.getId());
     preparedStatement.executeUpdate();
}

public List<Person> selectAll() throws Exception{
     preparedStatement = connection.prepareStatement("select *from person");
     ResultSet resultSet = preparedStatement.executeQuery();
     List<Person> persons = new ArrayList<>();
     while(resultSet.next()){
         Person person = new Person()
                 .setId(resultSet.getLong("id"))
                 .setName(resultSet.getString("name"))
                 .setFamily(resultSet.getString("family"))
                 .setSalary(resultSet.getLong("salary"));
         persons.add(person);
     }
     return persons;
    }
    public void commit() throws Exception {
        connection.commit();
    }
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
