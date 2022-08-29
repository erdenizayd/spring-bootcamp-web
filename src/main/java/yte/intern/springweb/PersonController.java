package yte.intern.springweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @PostMapping("/person")
    public Person[] getPerson(@RequestBody Person[] people) {
        for(int i = 0; i < people.length; i++) {
            people[i] = new Person(people[i].getName(), people[i].getSurname(), people[i].getAge()+1);
        }
        return people;
    }
}
