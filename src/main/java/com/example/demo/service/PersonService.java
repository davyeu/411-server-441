package com.example.demo.service;

import com.example.demo.dao.FakePersonDataAccessService;
import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonService {


    private final PersonDao personDao;

    @Autowired // initiate the  argument personDao
    public PersonService
            (@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao=personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    public int addPerson(String phoneNum,Person person){
        return personDao.insertPerson(phoneNum,person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> selectPersonByPhoneNum
            (String phoneNum){
        return personDao.
                selectPersonByPhoneNum(phoneNum);
    }

    public int deletePerson(String phoneNum) {
        return personDao.
                deletePersonByPhoneNum(phoneNum);
    }

    public int updatePerson
            (String phoneNum, Person newPerson){
        return personDao.
                updatePersonByPhoneNum
                        (phoneNum,newPerson);
    }
}
