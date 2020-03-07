package com.example.demo;

import java.util.ArrayList;

class BookStorage {

    private static ArrayList<BookModel> books=new ArrayList<>();

    static void addBook(BookModel book)
    {
        books.add(book);
    }
    static ArrayList<BookModel> bookList()
    {
        return  books;
    }

}
