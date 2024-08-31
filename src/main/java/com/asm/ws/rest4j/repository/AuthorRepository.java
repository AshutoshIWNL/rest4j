package com.asm.ws.rest4j.repository;

import com.asm.ws.rest4j.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author ashut
 * @since 31-08-2024
 */

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByEmail(String email);
}
