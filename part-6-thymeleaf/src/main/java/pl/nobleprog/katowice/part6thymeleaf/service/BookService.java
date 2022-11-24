package pl.nobleprog.katowice.part6thymeleaf.service;

import org.springframework.stereotype.Service;
import pl.nobleprog.katowice.part6thymeleaf.dto.TitleAndId;
import pl.nobleprog.katowice.part6thymeleaf.entity.Book;
import pl.nobleprog.katowice.part6thymeleaf.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository books;

    public BookService(BookRepository books) {
        this.books = books;
    }


    public List<TitleAndId> titleAndIdList() {
        return books.fetchTitleAndId();
    }

    public void seedBooks() {
        try {
            books.save(Book.builder()
                    .id(1)
                    .isbn("9788328391192")
                    .editionYear(2021)
                    .title("Java. Przewodnik dla początkujących. Wydanie VIII")
                    .build());
            books.save(Book.builder()
                    .id(2)
                    .editionYear(2021)
                    .isbn("9788328398979")
                    .title("Java. Efektywne programowanie. Wydanie III")
                    .build());
            books.save(Book.builder()
                    .id(3)
                    .editionYear(2020)
                    .isbn("9788324627738")
                    .title("Java. Rusz głową! Wydanie II")
                    .build());
            System.out.println("Books saved");
            books.save(Book.builder()
                    .id(4)
                    .editionYear(2021)
                    .isbn("9788324627738")
                    .title("Java. Rusz głową! Wydanie III")
                    .build());
            System.out.println("Books saved");
        } catch (Exception e) {
            System.out.println("Books already saved!");
        }
    }
}
