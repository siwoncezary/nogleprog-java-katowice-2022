package pl.nobleprog.katowice.part6thymeleaf.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.nobleprog.katowice.part6thymeleaf.dto.TitleAndId;
import pl.nobleprog.katowice.part6thymeleaf.entity.Book;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value= "select b.title, b.id from Book b", nativeQuery = true)
    List<TitleAndId> fetchTitleAndId();

    List<Book> findBookByTitleOrderByIsbn(String title);

    Page<Book> findByEditionYear(int year, Pageable page);

    List<String> findLongestTitle();
}
