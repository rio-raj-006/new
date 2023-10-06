package com.newproject.springboot.controller;

import com.newproject.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    @GetMapping("student")
    public Student details(){
        Student st=new Student(1,"Rajkumar","Selvaraj");
        return st;
    }
    @GetMapping("e")
    public List<Student> details1(){
        List<Student> st1=new ArrayList<>();
        st1.add(new Student(1,"Rajkumar", "Selvaraj"));
        st1.add(new Student(1,"Balaji", "Balaraman"));
        st1.add(new Student(1,"Jaya", "Anand"));
        st1.add(new Student(1,"Mariyappan", " "));
        return st1;
    }
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student newm(@PathVariable int id,@PathVariable("first-name") String firstName,@PathVariable("last-name") String lastName){
        return new Student(id,firstName,lastName);
    }
    @GetMapping("query")
    public Student query(@RequestParam int id,@RequestParam String firstname,@RequestParam String lastname){
        return new Student(id,firstname,lastname);
    }
    @PostMapping("post")
    @ResponseStatus(HttpStatus.CREATED)
    public Student post(@RequestBody Student st){
        System.out.println(st.getFirstname());
        System.out.println(st.getId());
        System.out.println(st.getLastname());
        return st;
    }
    @PutMapping("{id}/update")
    public Student put(@RequestBody Student st,@PathVariable int id){
        System.out.println(st.getFirstname());
        System.out.println(st.getLastname());
        st.setId(id);
        return st;
    }
    @DeleteMapping("{id}/delete")
    public String delete(@PathVariable int id){
        System.out.println(id);
        return "Deleted succesfully";
    }
}
