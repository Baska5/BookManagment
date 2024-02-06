package com.exam.NikolozBasiashvili.dtos;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ReceiptDto {
    private Long id;
    private BigDecimal totalPrice;
}
