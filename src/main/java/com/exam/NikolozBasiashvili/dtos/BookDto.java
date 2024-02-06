package com.exam.NikolozBasiashvili.dtos;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class BookDto {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private AuthorDto authorDto;
}
