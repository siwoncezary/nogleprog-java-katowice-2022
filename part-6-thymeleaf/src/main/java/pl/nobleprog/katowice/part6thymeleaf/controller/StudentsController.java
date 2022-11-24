package pl.nobleprog.katowice.part6thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.nobleprog.katowice.part6thymeleaf.model.Student;

import java.util.List;

@Controller
public class StudentsController {

    @GetMapping("/student")
    public String studentsIndex(Model model){
        model.addAttribute("students", List.of(
                Student.builder()
                        .name("Adam")
                        .id(1)
                        .ects(23)
                        .build(),
                Student.builder()
                        .name("Karol")
                        .id(2)
                        .ects(53)
                        .build(),
                Student.builder()
                        .name("Monika")
                        .id(3)
                        .ects(12)
                        .build()
        ));
        return "students";
    }
}
