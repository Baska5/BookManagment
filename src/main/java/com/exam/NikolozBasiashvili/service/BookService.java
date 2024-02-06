package com.exam.NikolozBasiashvili.service;

import com.exam.NikolozBasiashvili.dtos.BookDto;
import com.exam.NikolozBasiashvili.entities.Book;
import com.exam.NikolozBasiashvili.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book createBook(BookDto bookDto) {
        return bookRepository.save(Book.toEntity(bookDto));
    }

    public List<Book> findBooksByAuthor(BigDecimal priceFrom, BigDecimal priceTo){
        return bookRepository.findAllByPriceGreaterThanAndPriceIsLessThan(priceFrom,priceTo);
    }

    public List<Book> findBooksByAuthor(String firstName, String lastName){
        return bookRepository.findAllByAuthor_FirstNameAndAuthor_LastName(firstName,lastName);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
