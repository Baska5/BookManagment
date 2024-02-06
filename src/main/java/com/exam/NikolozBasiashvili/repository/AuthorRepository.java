package com.exam.NikolozBasiashvili.repository;

import com.exam.NikolozBasiashvili.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
