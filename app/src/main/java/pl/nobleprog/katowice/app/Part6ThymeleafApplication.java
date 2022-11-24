package pl.nobleprog.katowice.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.nobleprog.katowice.part6thymeleaf.dto.TitleAndId;
import pl.nobleprog.katowice.part6thymeleaf.service.BookService;

import java.util.List;

@SpringBootApplication
public class Part6ThymeleafApplication implements CommandLineRunner {

    public final BookService bookService;

    public Part6ThymeleafApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Part6ThymeleafApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookService.seedBooks();
        final List<TitleAndId> titleAndIds = bookService.titleAndIdsList();
        titleAndIds.forEach(o -> System.out.println(o.getTitle() +" "+ o.getId()));
    }
}
