package com.library;

import com.library.dto.BookDTO;
import com.library.entity.Book;
import com.library.repository.BookRepository;
import com.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public @ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void createBook_success() {
        BookDTO dto = new BookDTO();
        dto.setTitle("Clean Code");
        dto.setAuthor("Robert Martin");
        dto.setIsbn("123456");

        Book saved = new Book();
        saved.setId(1L);
        saved.setTitle("Clean Code");

        when(bookRepository.save(any())).thenReturn(saved);

        Book result = bookService.createBook(dto);
        assertEquals("Clean Code", result.getTitle());
    }

    @Test
    void getBookById_notFound_throwsException() {
        when(bookRepository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class,
            () -> bookService.getBookById(99L));
    }

    @Test
    void getAllBooks_returnsAll() {
        when(bookRepository.findAll()).thenReturn(List.of(new Book(), new Book()));
        assertEquals(2, bookService.getAllBooks().size());
    }

    @Test
    void searchBooks_byTitle() {
        when(bookRepository.findByTitleContainingIgnoreCase("clean"))
            .thenReturn(List.of(new Book()));
        assertEquals(1, bookService.searchBooks("clean").size());
    }
} 
