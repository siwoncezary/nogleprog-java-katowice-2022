package pl.nobleprog.katowice.part6thymeleaf.entity;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@NamedQuery(name ="Book.findLongestTitle", query = "select b.title from Book b")
@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    public static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "Tytuł nie może być pusty!")
    @Length(min = 3, max = 100, message = "Tytuł musi składać się z co najmniej 3 znaków!")
    private String title;

    @ISBN
    @NaturalId
    @Column(nullable = false, updatable = false, unique = true, length = 13)
    private String isbn;

    @Range(min = 1500, max = 2050, message = "Rok musi być w zakresie od 1500 do 2050")
    private int editionYear;
}
