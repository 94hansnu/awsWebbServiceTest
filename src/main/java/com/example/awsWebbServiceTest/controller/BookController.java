package com.example.awsWebbServiceTest.controller;

import com.example.awsWebbServiceTest.models.Book;
import com.example.awsWebbServiceTest.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/books")
//@RequiredArgsConstructor

public class BookController {

    private final MongoRepository mongoRepository;

    public BookController(MongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }


    @PostMapping("")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        //Spara book till DB, få den sparade boken tillbaka
        Book respBook = mongoRepository.save(book);
        //returnera book till ansändare
        return ResponseEntity.status(201).body(respBook);
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks() {
        //hämta alla böcker från DB
       List <Book> books = mongoRepository.findAll();

       //returnera alla böcker till avsändare
        return ResponseEntity.status(200).body(books);
    }
}
