package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping({ "/", "" })
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/book-list", method = RequestMethod.GET)
    public String booksList(@ModelAttribute BookEntity formModel, Model model) {
        model.addAttribute("bookStorage",  DemoApplication.bookService.findAllBooksWithoutFetch());
        // code to get books and enrich model with those books
        return "book-list";

    }

    @RequestMapping(value = "/filtered-book-list", method = RequestMethod.GET)
    public String bookList(@RequestParam String value, String type, @ModelAttribute BookEntity formModel, Model model) {
        int x= Integer.parseInt(type);
        if(x==0)
        model.addAttribute("bookStorage", DemoApplication.bookService.findByName(value));
        else if (x==1)
            model.addAttribute("bookStorage", DemoApplication.bookService.findByIsbn(value));
        else
            model.addAttribute("bookStorage", DemoApplication.bookService.findByAuthor(value));
        // code to get books and enrich model with those books
        return "book-list";
    }

    @RequestMapping(value = "/exact-book", method = RequestMethod.POST)
    public String booksList(@RequestParam int bookId) {
        // code to get books and enrich model with those books
        return "redirect:/book/"+bookId;
    }


    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String formControllerPost(@ModelAttribute BookEntity formModel, Model model) {
        DemoApplication.bookService.createBook(formModel);
        return "redirect:/book-list";
    }

    @RequestMapping({"/book/{id}", ""})
    public String bookById(@PathVariable String id, @ModelAttribute BookEntity b, Model model) {
        int bookId = Integer.parseInt(id);
        model.addAttribute("book",DemoApplication.bookService.getBookById(bookId));
        return "book_page";
    }

}
