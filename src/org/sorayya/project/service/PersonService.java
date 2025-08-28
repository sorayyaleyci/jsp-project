package org.sorayya.project.service;

import lombok.experimental.UtilityClass;
import org.sorayya.project.entity.Person;
import org.sorayya.project.repository.PersonRepository;

import java.util.List;

@UtilityClass
public class PersonService {

    public void save(Person person) throws Exception {
        try (PersonRepository repository = new PersonRepository()) {
            person.setSalary(person.getSalary() - ((person.getSalary() * 10) / 100));
            repository.insert(person);
            repository.commit();
        }
    }

    public void update(Person person) throws Exception {
        try (PersonRepository repository = new PersonRepository()) {
            repository.update(person);
            repository.commit();
        }
    }

    public void remove(Person person) throws Exception {
        try (PersonRepository repository = new PersonRepository()) {
            repository.delete(person);
            repository.commit();
        }
    }

    public List<Person> findAll() throws Exception {
        try (PersonRepository repository = new PersonRepository()) {
            return repository.selectAll();
        }
    }
}
