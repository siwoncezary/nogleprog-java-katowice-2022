package pl.nobleprog.katowice.part6thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.nobleprog.katowice.part6thymeleaf.entity.Book;
import pl.nobleprog.katowice.part6thymeleaf.repository.BookRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
    final BookRepository books;

    public BookController(BookRepository books) {
        this.books = books;
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("books", books.findAll());
        return "book/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("book", Book.builder().build());

        return "book/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute Book book, Errors errors){
        if (errors.hasErrors()) {
            return "book/create";
        } else {
            books.save(book);
            return "redirect:/book/index";
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id){
        final ModelAndView modelAndView = new ModelAndView("book/update");
        return books.findById(id).map(book -> {
            modelAndView.addObject("book", book);
            return modelAndView;
        }).orElseGet(() -> {
            modelAndView.addObject("error", "Brak takiej książki");
            return modelAndView;
        });
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") long id, Model model){
        model.addAttribute("book", books.findById(id));
        return "book/delete";
    }

}
