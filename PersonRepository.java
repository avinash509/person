package com.Person.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Person.springboot.Entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
