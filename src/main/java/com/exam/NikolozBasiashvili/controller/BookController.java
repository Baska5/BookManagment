package com.exam.NikolozBasiashvili.controller;

import com.exam.NikolozBasiashvili.dtos.BookDto;
import com.exam.NikolozBasiashvili.entities.Book;
import com.exam.NikolozBasiashvili.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @PostMapping("/createBook")
    public Book createBook(@RequestBody BookDto bookDto){
        return bookService.createBook(bookDto);
    }

    @GetMapping("/findByPrice/{priceFrom}/{priceTo}")
    public List<Book> findBooksByPrice(@PathVariable BigDecimal priceFrom, @PathVariable BigDecimal priceTo){
        return bookService.findBooksByAuthor(priceFrom, priceTo);
    }

    @GetMapping("/findByAuthor/{firstName}/{lastName}")
    public List<Book> findBooksByPrice(@PathVariable String firstName, @PathVariable String lastName){
        return bookService.findBooksByAuthor(firstName, lastName);
    }

    @GetMapping("findAll")
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }
}
