package com.exam.NikolozBasiashvili.controller;

import com.exam.NikolozBasiashvili.dtos.AuthorDto;
import com.exam.NikolozBasiashvili.entities.Author;
import com.exam.NikolozBasiashvili.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/createAuthor")
    public Author createAuthor(@RequestBody AuthorDto authorDto){
        return authorService.createAuthor(authorDto);
    }

    @GetMapping("/findAll")
    public List<Author> findAllAuthors(){
        return authorService.findAllAuthors();
    }
}
