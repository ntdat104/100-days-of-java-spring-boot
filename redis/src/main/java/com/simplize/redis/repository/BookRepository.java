package com.simplize.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplize.redis.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
