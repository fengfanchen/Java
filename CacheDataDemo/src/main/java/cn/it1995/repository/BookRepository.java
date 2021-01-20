package cn.it1995.repository;

import cn.it1995.object.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);
}
