package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.Random;


public interface PersonDao {

    int insertPerson(String phoneNum, Person person);
    default int insertPerson(Person person){
        String phoneNum= new Random().toString();
        return insertPerson(phoneNum,person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonByPhoneNum(String phoneNum);

    int deletePersonByPhoneNum(String phoneNum);

    int updatePersonByPhoneNum(String phoneNum, Person person);

}
