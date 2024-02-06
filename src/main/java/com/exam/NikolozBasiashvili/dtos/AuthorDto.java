package com.exam.NikolozBasiashvili.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
}
