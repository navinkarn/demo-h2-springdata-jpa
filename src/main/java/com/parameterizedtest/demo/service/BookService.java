package com.parameterizedtest.demo.service;

import com.parameterizedtest.demo.model.Book;
import com.parameterizedtest.demo.repository.BookPagedRepository;
import com.parameterizedtest.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookPagedRepository bookPagedRepository;

    public List<Book> listBooksByPublication(String publicationName){
       
        return bookRepository.findByPublication(publicationName);
    }

    public List<Book> getBooksByPaging(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Book> pagedResult = bookPagedRepository.findAll(paging);


        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Book>();
        }
    }
}
