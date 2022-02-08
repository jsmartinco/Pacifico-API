package com.bolivar.pacifico.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.dao.IInvoiceDao;
import com.bolivar.pacifico.models.entitys.Invoice;
@Service
public class InvoiceServiceImpl implements IInvoiceService{
	
	@Autowired
	IInvoiceDao iInvoiceDao;

	@Override
	public Optional<Invoice> findById(Long id) {
		return iInvoiceDao.findById(id);
	}

}
