package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
class BookModel {

    private String book_name;
    private String isbn;
    private String author;
}
