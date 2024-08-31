package com.asm.ws.rest4j.dto;

/**
 * @author ashut
 * @since 31-08-2024
 */

public class BookDTO {
    private Long id;
    private String title;
    private AuthorDTO author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
