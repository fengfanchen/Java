package cn.it1995.object;

import lombok.Data;

@Data
public class Book {

    private String isbn;
    private String title;

    public Book(String isbn, String title) {

        this.isbn = isbn;
        this.title = title;
    }
}
