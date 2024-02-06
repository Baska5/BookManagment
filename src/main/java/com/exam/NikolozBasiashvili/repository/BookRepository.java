package com.exam.NikolozBasiashvili.repository;

import com.exam.NikolozBasiashvili.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByPriceGreaterThanAndPriceIsLessThan(BigDecimal priceFrom, BigDecimal priceTo);
    List<Book> findAllByAuthor_FirstNameAndAuthor_LastName(String firstName, String lastName);
}
