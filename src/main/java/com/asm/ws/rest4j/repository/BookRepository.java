package com.asm.ws.rest4j.repository;

import com.asm.ws.rest4j.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author ashut
 * @since 31-08-2024
 */

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByTitle(String name);
}
