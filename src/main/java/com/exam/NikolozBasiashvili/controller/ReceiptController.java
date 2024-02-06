package com.exam.NikolozBasiashvili.controller;

import com.exam.NikolozBasiashvili.dtos.PurchaseBooks;
import com.exam.NikolozBasiashvili.dtos.ReceiptResponseDto;
import com.exam.NikolozBasiashvili.entities.Book;
import com.exam.NikolozBasiashvili.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    @PostMapping("/purchaseBooks")
    public ReceiptResponseDto purchaseBooks(@RequestBody PurchaseBooks purchaseBooks) {
        return receiptService.purchaseBooks(purchaseBooks);
    }

    @GetMapping("/findByDates/{dateFrom}/{dateTo}")
    public List<ReceiptResponseDto> findAllReceiptsByDates(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFrom,
                                                @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTo){
        return receiptService.findReceiptsByDates(dateFrom, dateTo);
    }

    @GetMapping("/findAllSoldBooks")
    public List<Book> findByAuthorName(){
        return receiptService.findAllSoldBooks();
    }

    @GetMapping("/findAll")
    public List<ReceiptResponseDto> findAllReceipts () {
        return receiptService.findAllReceipts();
    }
}
