package com.exam.NikolozBasiashvili.dtos;

import java.math.BigDecimal;
import java.util.List;


public record ReceiptResponseDto(Long id, BigDecimal totalPrice, List<String > bookNames) {

}
