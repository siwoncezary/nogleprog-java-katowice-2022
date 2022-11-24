package pl.nobleprog.katowice.part6thymeleaf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import pl.nobleprog.katowice.part6thymeleaf.dto.TitleAndId;
import pl.nobleprog.katowice.part6thymeleaf.entity.Book;
import pl.nobleprog.katowice.part6thymeleaf.repository.BookRepository;
import pl.nobleprog.katowice.part6thymeleaf.repository.PagingBookRepository;
import pl.nobleprog.katowice.part6thymeleaf.service.BookService;

import java.util.List;

@SpringBootApplication
public class Part6ThymeleafApplication implements CommandLineRunner {

    public final BookService bookService;
    public final PagingBookRepository pagingBookRepository;
    public final BookRepository books;

    public Part6ThymeleafApplication(BookService bookService, PagingBookRepository pagingBookRepository, BookRepository books) {
        this.bookService = bookService;
        this.pagingBookRepository = pagingBookRepository;
        this.books = books;
    }

    public static void main(String[] args) {
        SpringApplication.run(Part6ThymeleafApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookService.seedBooks();
        final List<TitleAndId> titleAndIds = bookService.titleAndIdList();
        if (titleAndIds != null) {
            titleAndIds.forEach(o -> System.out.println(o.getTitle() + " " + o.getId()));
        }
        final PageRequest pageRequest = PageRequest.of(1, 2);
        final Page<Book> page = pagingBookRepository.findAll(pageRequest);
        System.out.println("Page");
        System.out.println(page.getContent());
        final Page<Book> editionYear = books.findByEditionYear(2021, PageRequest.of(0, 2));
        System.out.println(editionYear.getTotalElements());
        System.out.println(editionYear.getTotalPages());
        System.out.println(editionYear.getContent());
        System.out.println(books.findLongestTitle());
    }
}
