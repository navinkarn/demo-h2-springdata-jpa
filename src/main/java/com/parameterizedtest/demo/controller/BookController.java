package com.parameterizedtest.demo.controller;

import com.parameterizedtest.demo.model.Book;
import com.parameterizedtest.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/list-book-by-pub")
    public ResponseEntity listBookByPublication(@RequestBody Book bookRequest){
       List<Book> bookList =  bookService.listBooksByPublication(bookRequest.getPublication());
       return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("/list-book-by-page")
    //http://localhost:8080/books/list-book-by-page?pageSize=4&pageNo=5&sortBy=name
    public ResponseEntity<List<Book>> getAllEmployees(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "4") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
    {
        List<Book> bookList = bookService.getBooksByPaging(pageNo, pageSize, sortBy);

        return new ResponseEntity<List<Book>>(bookList,  HttpStatus.OK);
    }

}
