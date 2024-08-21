package com.example.jwt.service;
import com.example.jwt.dtos.BookRequestDto;
import com.example.jwt.entity.Book;
import com.example.jwt.entity.Library;
import com.example.jwt.repository.BookRepository;
import com.example.jwt.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryRepository libraryRepository;

    public Book addBook( BookRequestDto bookRequestDto){
        Book newBook = new Book();
        newBook.setTitle(bookRequestDto.getTitle());
        newBook.setNoOfPages(bookRequestDto.getNoOfPages());
        newBook.setAuthor(bookRequestDto.getAuthor());
        newBook.setCategory(bookRequestDto.getCategory());

//        newBook.setLibrary_id(bookRequestDto.getLibrary_id());
//        newBook.setLibrary(bookRequestDto.getLibrary());
        Optional<Library> optionalLibrary = libraryRepository.findById(bookRequestDto.getLibrary_id());
        Library newLibrary = new Library();
        if(optionalLibrary.isPresent()){
            newLibrary = optionalLibrary.get();
        }
        newLibrary.getBooks().add(newBook);
        newBook.setLibrary(newLibrary);
//        libraryRepository.save(newLibrary);
        return bookRepository.save(newBook);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id){
        Optional<Book> bookOptional = bookRepository.findById(id);
        Book newBook = new Book();
        if(bookOptional.isPresent()) {
            newBook = bookOptional.get();
        }
        return newBook;
    }

}
