package com.example.security.Controller;


import com.example.security.Models.Ocena;
import com.example.security.Models.Student;
import com.example.security.Service.Interface.IOceniService;
import com.example.security.Service.Interface.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/profesor")
public class ProfesorController {
    @Autowired
    private IProfesorService profesorService;
    @Autowired
    private IOceniService oceniService;


    @GetMapping("/studenti")
    public String findStudent(Model model) {
        List<Student> studenti = profesorService.getAllStudents();
        System.out.println(studenti);
        model.addAttribute("studenti", studenti);
        return "showAllStudents";
    }

    @GetMapping("/studenti/{indeks}")
    public String showStudent(@PathVariable("indeks") int indeks, Model model) {
        List<Ocena> oceni = profesorService.findOceni(indeks);
        //System.out.println(oceni);
        model.addAttribute("oceni", oceni);
        return "showStudentOceni";
    }


    @GetMapping("/studenti/{indeks}/changeocena")
    public String chanegOcena(@PathVariable("indeks") int indeks, Model model) {

        return "changeStudentOcena";
    }


}