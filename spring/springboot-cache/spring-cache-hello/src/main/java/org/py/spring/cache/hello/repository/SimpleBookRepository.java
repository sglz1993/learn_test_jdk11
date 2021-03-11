package org.py.spring.cache.hello.repository;

import org.py.spring.cache.hello.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

//    参考：https://blog.csdn.net/f641385712/article/details/94570960
    @Override
    @Cacheable("org.py.spring.cache.hello.repository.SimpleBookRepository.getByIsbn")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}