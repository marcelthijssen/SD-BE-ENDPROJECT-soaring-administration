package com.example.sdbesoaringadministration.repositories;

import com.example.sdbesoaringadministration.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findInvoicesByBilledPerson( Long id );
    List<Invoice> findInvoiceByFlight_Id(Long id);
}
