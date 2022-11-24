package pl.nobleprog.katowice.part6thymeleaf.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.nobleprog.katowice.part6thymeleaf.entity.Book;

import java.util.List;

@Repository
public interface PagingBookRepository extends PagingAndSortingRepository<Book, Long > {
    List<Book> findByEditionYear(int year, Pageable page);
}
