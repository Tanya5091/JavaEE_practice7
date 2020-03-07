package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.awt.print.Book;

@Controller
public class IndexController {

    @RequestMapping({ "/", "" })
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/book-list", method = RequestMethod.GET)
    public String booksList(@ModelAttribute BookModel formModel, Model model) {
        model.addAttribute("bookStorage", BookStorage.bookList());
        // code to get books and enrich model with those books
        return "book-list";
    }


    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String formControllerPost(@ModelAttribute BookModel formModel, Model model) {
        BookStorage.addBook(formModel);
        model.addAttribute("bookStorage", BookStorage.bookList());
        return "redirect:/book-list";
    }

}
