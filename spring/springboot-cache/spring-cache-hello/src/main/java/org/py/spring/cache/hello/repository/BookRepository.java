package org.py.spring.cache.hello.repository;

import org.py.spring.cache.hello.entity.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

}
