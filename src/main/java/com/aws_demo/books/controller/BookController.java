package com.aws_demo.books.controller;

import com.aws_demo.books.entity.Books; // Ensure this imports your Book entity
import com.aws_demo.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BooksRepository bookRepo;

    @GetMapping("/book/{id}")
    public ResponseEntity<Books> getBook(@PathVariable("id") Long id) {
        Optional<Books> book = bookRepo.findById(id);
        return book.map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Book not found with id " + id));
    }

    @GetMapping("/books")
    public List<Books> getAllBooks() {
        return bookRepo.findAll();
    }

    @PostMapping("/book")
    public ResponseEntity<Books> createBook(@RequestBody Books book) {
        Books savedBook = bookRepo.save(book);
        return ResponseEntity.ok().body(savedBook); // 201 Created status
    }

}
