package com.exam.NikolozBasiashvili.service;

import com.exam.NikolozBasiashvili.dtos.AuthorDto;
import com.exam.NikolozBasiashvili.entities.Author;
import com.exam.NikolozBasiashvili.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author createAuthor(AuthorDto authorDto) {
        return authorRepository.save(Author.toEntity(authorDto));
    }

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }
}
