package com.asm.ws.rest4j;

import com.asm.ws.rest4j.dto.AuthorDTO;
import com.asm.ws.rest4j.dto.BookDTO;
import com.asm.ws.rest4j.model.Author;
import com.asm.ws.rest4j.model.Book;
import com.asm.ws.rest4j.service.AuthorService;
import com.asm.ws.rest4j.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author ashut
 * @since 01-09-2024
 */


@WebMvcTest
public class Rest4jControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private BookService bookService;

    @Test
    public void testCreateAuthor() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setName("John Doe");
        authorDTO.setEmail("johndoe@example.com");

        when(authorService.createAuthor(any(Author.class))).thenReturn(authorDTO);

        mockMvc.perform(post("/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe\",\"email\":\"johndoe@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is("John Doe")))
                .andExpect(jsonPath("$.email", is("johndoe@example.com")));
    }

    @Test
    public void testGetAuthor() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setName("John Doe");
        authorDTO.setEmail("johndoe@example.com");

        when(authorService.getAuthor(anyLong())).thenReturn(authorDTO);

        mockMvc.perform(get("/authors/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("John Doe")))
                .andExpect(jsonPath("$.email", is("johndoe@example.com")));
    }

    @Test
    public void testGetAllAuthors() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setName("John Doe");
        authorDTO.setEmail("johndoe@example.com");

        when(authorService.getAllAuthors()).thenReturn(Collections.singletonList(authorDTO));

        mockMvc.perform(get("/authors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("John Doe")))
                .andExpect(jsonPath("$[0].email", is("johndoe@example.com")));
    }

    @Test
    public void testUpdateAuthor() throws Exception {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setName("John Doe Updated");
        authorDTO.setEmail("johndoe@example.com");

        when(authorService.updateAuthor(anyLong(), any(Author.class))).thenReturn(authorDTO);

        mockMvc.perform(put("/authors/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"John Doe Updated\",\"email\":\"johndoe@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("John Doe Updated")))
                .andExpect(jsonPath("$.email", is("johndoe@example.com")));
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        mockMvc.perform(delete("/authors/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testCreateBook() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(1L);
        bookDTO.setTitle("Sample Book");

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setName("John Doe");
        authorDTO.setEmail("johndoe@example.com");
        bookDTO.setAuthor(authorDTO); // Assuming `BookDTO` has an `AuthorDTO` field

        when(bookService.createBook(any(Book.class))).thenReturn(bookDTO);

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Sample Book\",\"author\":{\"id\":1,\"name\":\"John Doe\",\"email\":\"johndoe@example.com\"}}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title", is("Sample Book")));
    }

    @Test
    public void testGetBook() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(1L);
        bookDTO.setTitle("Sample Book");

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setName("John Doe");
        authorDTO.setEmail("johndoe@example.com");
        bookDTO.setAuthor(authorDTO); // Assuming `BookDTO` has an `AuthorDTO` field

        when(bookService.getBook(anyLong())).thenReturn(bookDTO);

        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Sample Book")))
                .andExpect(jsonPath("$.author.name", is("John Doe")));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(1L);
        bookDTO.setTitle("Sample Book");

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setName("John Doe");
        authorDTO.setEmail("johndoe@example.com");
        bookDTO.setAuthor(authorDTO); // Assuming `BookDTO` has an `AuthorDTO` field

        when(bookService.getAllBooks()).thenReturn(Collections.singletonList(bookDTO));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Sample Book")))
                .andExpect(jsonPath("$[0].author.name", is("John Doe")));
    }

    @Test
    public void testUpdateBook() throws Exception {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(1L);
        bookDTO.setTitle("Sample Book Updated");

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setName("John Doe");
        authorDTO.setEmail("johndoe@example.com");
        bookDTO.setAuthor(authorDTO); // Assuming `BookDTO` has an `AuthorDTO` field

        when(bookService.updateBook(anyLong(), any(Book.class))).thenReturn(bookDTO);

        mockMvc.perform(put("/books/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Sample Book Updated\",\"author\":{\"id\":1,\"name\":\"John Doe\",\"email\":\"johndoe@example.com\"}}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Sample Book Updated")))
                .andExpect(jsonPath("$.author.name", is("John Doe")));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/books/1"))
                .andExpect(status().isNoContent());
    }
}
