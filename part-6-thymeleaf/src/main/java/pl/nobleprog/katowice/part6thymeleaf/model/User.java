package pl.nobleprog.katowice.part6thymeleaf.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class User {
    @PESEL(message = "Podaj poprawny pesel!")
    private String pesel;


    @Length(max = 50, message = "Zbyt długie imię")
    @NotNull()
    @NotBlank
    private String firstName;
}
