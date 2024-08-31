package com.asm.ws.rest4j.service;

import com.asm.ws.rest4j.dto.BookDTO;
import com.asm.ws.rest4j.exception.ResourceAlreadyExistsException;
import com.asm.ws.rest4j.exception.ResourceNotFoundException;
import com.asm.ws.rest4j.model.Book;
import com.asm.ws.rest4j.repository.AuthorRepository;
import com.asm.ws.rest4j.repository.BookRepository;
import com.asm.ws.rest4j.utils.DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ashut
 * @since 31-08-2024
 */

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public BookDTO createBook(Book book) {
        Optional<Book> existingBook = bookRepository.findByTitle(book.getTitle());
        if(existingBook.isPresent()) {
            throw new ResourceAlreadyExistsException("Book with title " + existingBook.get().getTitle() + " already exists");
        }
        return (BookDTO) DTOUtils.convertToDTO(bookRepository.save(book));
    }

    public BookDTO getBook(Long id) {
        return bookRepository.findById(id)
                .map(DTOUtils::convertToDTO)
                .map(BookDTO.class::cast)
                .orElse(null);
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(DTOUtils::convertToDTO)
                .map(BookDTO.class::cast)
                .toList();
    }

    public BookDTO updateBook(Long id, Book book) {
        if (bookRepository.existsById(id)) {
            book.setId(id);
            return (BookDTO) DTOUtils.convertToDTO(bookRepository.save(book));
        }
        throw new ResourceNotFoundException("Book with id " + id + " doesn't exist");
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
