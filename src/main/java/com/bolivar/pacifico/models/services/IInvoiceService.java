package com.bolivar.pacifico.models.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.entitys.Invoice;

@Service
public interface IInvoiceService {
	
	public Optional<Invoice> findById(Long id);

}
