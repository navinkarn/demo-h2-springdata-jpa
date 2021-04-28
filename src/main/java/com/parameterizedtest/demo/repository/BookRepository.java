package com.parameterizedtest.demo.repository;

import com.parameterizedtest.demo.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByPublication(String publication);
}
