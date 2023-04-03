package com.Person.springboot.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Person.springboot.Entity.Person;
import com.Person.springboot.Repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

	public Person addPerson(Person person) {
		
		return personRepository.save(person);
	}
}