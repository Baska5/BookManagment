package com.exam.NikolozBasiashvili.service;

import com.exam.NikolozBasiashvili.dtos.PurchaseBooks;
import com.exam.NikolozBasiashvili.dtos.ReceiptResponseDto;
import com.exam.NikolozBasiashvili.entities.Book;
import com.exam.NikolozBasiashvili.entities.Receipt;
import com.exam.NikolozBasiashvili.repository.BookRepository;
import com.exam.NikolozBasiashvili.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final BookRepository bookRepository;

    public ReceiptResponseDto purchaseBooks(PurchaseBooks purchaseBooks){
        List<Book> allBooksById = bookRepository.findAllById(purchaseBooks.getBookIds());

        Receipt receipt = new Receipt();
        receipt.setTotalPrice(calculateTotalAmount(allBooksById));
        receipt.setBooks(allBooksById);
        return map(receiptRepository.save(receipt));
    }

    public List<ReceiptResponseDto> findAllReceipts() {
        return receiptRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    public List<ReceiptResponseDto> findReceiptsByDates(Date dateFrom, Date dateTo){
        return receiptRepository.findAllByCreatedAtIsAfterAndCreatedAtIsBefore(dateFrom,dateTo).stream().map(this::map).collect(Collectors.toList());
    }

    public List<Book> findAllSoldBooks(){
        List<Receipt> allReceipts = receiptRepository.findAll();
        List<Book> soldBooks = new ArrayList<>();
        allReceipts.forEach(receipt -> soldBooks.addAll(receipt.getBooks()));

        return soldBooks;
    }

    private BigDecimal calculateTotalAmount(List<Book> allBooksById) {
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (Book book : allBooksById) {
            totalAmount = totalAmount.add(book.getPrice());

        }

        return totalAmount;
    }

    private ReceiptResponseDto map(Receipt receipt) {
        return new ReceiptResponseDto(receipt.getId(), receipt.getTotalPrice(), receipt.getBooks().stream().map(Book::getTitle).collect(Collectors.toList()));
    }
}
