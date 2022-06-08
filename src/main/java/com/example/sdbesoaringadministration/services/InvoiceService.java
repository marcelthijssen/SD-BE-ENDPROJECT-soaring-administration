/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.InvoiceDto;

import java.util.List;

public interface InvoiceService {

    List<InvoiceDto> getAllInvoices();

    List<InvoiceDto> findInvoicesByBilledPerson( Long plane_id );


}
