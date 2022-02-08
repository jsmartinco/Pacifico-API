package com.bolivar.pacifico.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolivar.pacifico.models.entitys.Invoice;

public interface IInvoiceDao extends CrudRepository<Invoice, Long>{

}
