package pl.nobleprog.katowice.part6thymeleaf.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private int id;
    private String name;
    private int ects;
}
