package pl.nobleprog.katowice.part6thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nobleprog.katowice.part6thymeleaf.entity.Book;

@Repository
public interface CustomBookRepository extends JpaRepository<Book, Long> {

}
