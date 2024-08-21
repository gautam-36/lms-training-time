package com.example.jwt.service;
import com.example.jwt.dtos.LibraryRequestDto;
import com.example.jwt.entity.Book;
import com.example.jwt.entity.Library;
import com.example.jwt.repository.BookRepository;
import com.example.jwt.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    BookRepository bookRepository;

    public Library addLibrary(LibraryRequestDto library){

        Library newLibrary = new Library();
        newLibrary.setName(library.getName());
        newLibrary.setLocation(library.getLocation());

        return libraryRepository.save(newLibrary);
    }

    public List<Library> getAllLibrary(){
        return libraryRepository.findAll();
    }

    public Library findById(Integer id){
        Optional<Library> optionalLibrary =   libraryRepository.findById(id);
        Library newLibrary = new Library();
        if(optionalLibrary.isPresent()){
            newLibrary = optionalLibrary.get();
        }
        return newLibrary;
    }


    public List<Book> presentBooks(Integer id){
        List<Book>books = new ArrayList<>();
        books = bookRepository.findAll();
        List<Book> booksAvaiableInLibrary =  new ArrayList<>();
        for(Book book: books){
            if(book.getLibrary().getId().equals(id)){
                booksAvaiableInLibrary.add(book);
            }
        }

       return booksAvaiableInLibrary;
    }



}
