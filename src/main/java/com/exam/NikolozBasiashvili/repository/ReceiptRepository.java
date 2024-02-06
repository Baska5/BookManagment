package com.exam.NikolozBasiashvili.repository;

import com.exam.NikolozBasiashvili.entities.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    List<Receipt> findAllByCreatedAtIsAfterAndCreatedAtIsBefore(Date dateFrom, Date dateTo);
}
