package com.simplize.redis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.simplize.redis.model.Book;
import com.simplize.redis.repository.BookRepository;

@Service
public class BookService {

    private static final String BOOK_CACHE = "BOOK_CACHE";

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable(value = BOOK_CACHE)
    public List<Book> getBooks() {
        System.out.println("Fetching books from database");
        return bookRepository.findAll();
    }

    @Cacheable(value = BOOK_CACHE, key = "#id")
    public Book getBookById(Long id) {
        System.out.println("Fetching book for id: " + id + " from database");
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Không có dữ liệu"));
    }

    @CacheEvict(value = BOOK_CACHE, allEntries = true)
    public Book createBook(Book book) {
        System.out.println("Creating a new book in the database");
        return bookRepository.save(book);
    }

    @CacheEvict(value = BOOK_CACHE, key = "#book.id")
    public Book updateBook(Book book) {
        System.out.println("Updating book for id: " + book.getId() + " in the database");
        return bookRepository.save(book);
    }

    @CacheEvict(value = BOOK_CACHE, key = "#id")
    public void deleteBook(Long id) {
        System.out.println("Deleting book for id: " + id + " from database");
        bookRepository.deleteById(id);
    }

    @Cacheable(value = BOOK_CACHE, key = "{#id, #genre}")
    public Optional<Book> getBookByIdAndGenre(Long id, String genre) {
        System.out.println("Fetching book for id: " + id + " and genre: " + genre + " from database");
        // Implement fetching logic based on both id and genre
        // Example: bookRepository.findByIdAndGenre(id, genre);
        return Optional.empty(); // Replace with actual repository logic
    }

}
