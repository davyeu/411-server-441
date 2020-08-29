package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository("fakeDao")
public class
FakePersonDataAccessService implements PersonDao{

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(String PhoneNum, Person person){
        DB.add(new Person(PhoneNum, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonByPhoneNum(String phoneNum) {
        return DB.stream()
                .filter(person -> person.getPhoneNum()
                .equals(phoneNum)).findFirst();
    }

    @Override
    public int deletePersonByPhoneNum(String phoneNum) {
        Optional<Person> personMaybe= selectPersonByPhoneNum(phoneNum);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    //find the person by the given phone number and update the person name and phone
    public int updatePersonByPhoneNum(String oldPhoneNum, Person newPerson) {
        return selectPersonByPhoneNum(oldPhoneNum)
                .map(oldPerson -> {
                    int indexOfPersonToUpdate= DB.indexOf(oldPerson);
                    if(indexOfPersonToUpdate>=0){
                        DB.set(indexOfPersonToUpdate, newPerson);
                        return 1;
                    }
                    // if index of person to delete not found
                    return 0;

                })
                //if person not found by given id
                .orElse( 0);
    }


}
