package com.example.jwt.controller;

import com.example.jwt.dtos.BookRequestDto;
import com.example.jwt.entity.Book;
import com.example.jwt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    // create a book
    @PostMapping("/create")
    public Book addBook(@RequestBody BookRequestDto book){
        return bookService.addBook(book);
    }

    // get all books from db
    @GetMapping("/")
    public List<Book> getALlBooks(){
        return bookService.getAllBooks();
    }

    // get book by id

    @GetMapping("/{id}")
    public Book getBookById(Integer id){
        return bookService.getBookById(id);
    }

}
