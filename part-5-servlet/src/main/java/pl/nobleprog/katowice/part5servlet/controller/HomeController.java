package pl.nobleprog.katowice.part5servlet.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Log4j2
@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView index(){
        log.info("Request with uri to index");
        final ModelAndView view = new ModelAndView("index");
        log.info("view "+ view.getView());
        return view;
    }
}
