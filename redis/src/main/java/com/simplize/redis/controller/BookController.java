package com.simplize.redis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplize.redis.model.Book;
import com.simplize.redis.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok().body(bookService.getBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.getBookById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok().body(bookService.createBook(book));
    }

    @PutMapping("/update")
    public String updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        return "Book Updated: " + updatedBook.getTitle();
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book Deleted for ID: " + id;
    }

    @GetMapping("/{id}/{genre}")
    public String getBookByIdAndGenre(@PathVariable Long id, @PathVariable String genre) {
        Optional<Book> book = bookService.getBookByIdAndGenre(id, genre);
        return book.map(value -> "Book Found: " + value.getTitle()).orElse("Book Not Found");
    }

}
