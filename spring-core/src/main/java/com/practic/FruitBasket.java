package com.practic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
@Component
public class FruitBasket {
    @Autowired
    @Qualifier("gradeA")
    private List<Student> students1;

    @Autowired
    @Qualifier("gradeA")
    private List<Student> students2;

    public void showStudents() {

    }


}