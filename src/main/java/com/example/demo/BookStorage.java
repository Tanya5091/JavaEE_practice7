package com.example.demo;

import java.util.ArrayList;

public class BookStorage {

    public static ArrayList<BookModel> books=new ArrayList<>();

    public static void addBook(BookModel book)
    {
        books.add(book);
    }
    public static ArrayList<BookModel> bookList()
    {
        return  books;
    }

}
