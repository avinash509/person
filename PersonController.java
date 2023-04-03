package com.Person.springboot.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.Person.springboot.Entity.Person;
import com.Person.springboot.Repository.PersonRepository;
import com.Person.springboot.Service.PersonService;


@RestController
@RequestMapping("/persons")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    @Autowired
   private PersonRepository personRepository;
    
 
    
    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }
    
    @GetMapping("/getall")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }
       @GetMapping("/{id}/fullname")
        public String getFullName(@PathVariable Long id) {
        	Optional<Person> persons= personRepository.findById(id);
        	if(persons!=null) {
        		Person person=persons.get();
        		
        		return person.getFirstName()+ " " + person.getLastName();
       }else {
        		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        	}
        }
}
        