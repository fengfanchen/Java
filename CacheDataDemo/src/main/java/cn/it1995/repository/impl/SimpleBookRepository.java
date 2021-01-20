package cn.it1995.repository.impl;

import cn.it1995.object.Book;
import cn.it1995.repository.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {


    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {

        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    private void simulateSlowService(){

        try{

            long time = 3000L;
            Thread.sleep(time);
        }
        catch(InterruptedException e){

            e.printStackTrace();
        }
    }
}
