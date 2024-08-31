package com.asm.ws.rest4j.utils;

import com.asm.ws.rest4j.dto.AuthorDTO;
import com.asm.ws.rest4j.dto.BookDTO;
import com.asm.ws.rest4j.model.Author;
import com.asm.ws.rest4j.model.Book;
import org.modelmapper.ModelMapper;

/**
 * @author ashut
 * @since 31-08-2024
 */

public class DTOUtils {
    private static final ModelMapper modelMapper = new ModelMapper();

    private DTOUtils() {}

    public static Object convertToDTO(Object object) {
        if (object instanceof Author) {
            return modelMapper.map((Author) object, AuthorDTO.class);
        } else if (object instanceof Book) {
            return modelMapper.map((Book) object, BookDTO.class);
        } else {
            throw new IllegalArgumentException("Unsupported object type for conversion");
        }
    }
}
