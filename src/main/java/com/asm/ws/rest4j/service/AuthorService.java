package com.asm.ws.rest4j.service;

import com.asm.ws.rest4j.dto.AuthorDTO;
import com.asm.ws.rest4j.exception.ResourceAlreadyExistsException;
import com.asm.ws.rest4j.exception.ResourceNotFoundException;
import com.asm.ws.rest4j.model.Author;
import com.asm.ws.rest4j.repository.AuthorRepository;
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
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDTO createAuthor(Author author) {
        Optional<Author> existingAuthor = authorRepository.findByEmail(author.getEmail());
        if(existingAuthor.isPresent()) {
            throw new ResourceAlreadyExistsException("Author with email " + existingAuthor.get().getEmail() + " already exists");
        }
        return (AuthorDTO) DTOUtils.convertToDTO(authorRepository.save(author));
    }

    public AuthorDTO getAuthor(Long id) {
        return authorRepository.findById(id)
                .map(DTOUtils::convertToDTO)
                .map(AuthorDTO.class::cast)
                .orElse(null);
    }

    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(DTOUtils::convertToDTO)
                .map(AuthorDTO.class::cast)
                .toList();
    }

    public AuthorDTO updateAuthor(Long id, Author author) {
        if (authorRepository.existsById(id)) {
            Author existingAuthor = authorRepository.findById(id).orElseThrow(
                    () -> new ResourceNotFoundException("Author with id " + id + " doesn't exist"));
            existingAuthor.setName(author.getName());
            existingAuthor.setEmail(author.getEmail());

            return (AuthorDTO) DTOUtils.convertToDTO(authorRepository.save(existingAuthor));
        }
        throw new ResourceNotFoundException("Author with id " + id + " doesn't exist");
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

}
