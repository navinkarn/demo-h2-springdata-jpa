package com.parameterizedtest.demo.repository;

import com.parameterizedtest.demo.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPagedRepository extends PagingAndSortingRepository<Book, Long> {


}
