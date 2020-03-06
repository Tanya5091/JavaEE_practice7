package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping({ "/", "" })
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/book_list", method = RequestMethod.POST)
    public String formControllerPost(@ModelAttribute BookModel formModel, Model model) {
        BookStorage.addBook(formModel);
        model.addAttribute("bookStorage", BookStorage.bookList());
        return "book-list";
    }

}
