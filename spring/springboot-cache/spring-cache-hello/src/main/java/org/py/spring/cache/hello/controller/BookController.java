package org.py.spring.cache.hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.py.spring.cache.hello.entity.Book;
import org.py.spring.cache.hello.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class BookController {

    @Resource
    private BookRepository bookRepository;

    @GetMapping("/{isbn}")
    public String hello(@PathVariable String isbn) {
        Book byIsbn = bookRepository.getByIsbn(isbn);
        return byIsbn.toString();
    }

}
