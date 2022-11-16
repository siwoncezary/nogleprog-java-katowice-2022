package pl.nobleprog.katowice.part8test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HomeController {
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> index(@PathVariable int id) {
        return ResponseEntity.of(Optional.of(Book.builder()
                .id(1)
                .author("Kowalski")
                .title("Spring")
                .build()));
    }
}
