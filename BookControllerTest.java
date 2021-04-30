package com.parameterizedtest.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parameterizedtest.demo.model.Book;
import com.parameterizedtest.demo.service.BookService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetAllBooks() throws Exception{
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setName("testBook");
        book.setPublication("testPublication");
        books.add(book);
        Mockito.when(bookService.getBooksByPaging(any(), any(), any())).thenReturn(books);
        mockMvc.perform(get("/books/list-book-by-page"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.equalTo("testBook")));
    }
}
