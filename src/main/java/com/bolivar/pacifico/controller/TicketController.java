package com.bolivar.pacifico.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bolivar.pacifico.models.dto.DashDto;
import com.bolivar.pacifico.models.dto.TicketDetailsDto;
import com.bolivar.pacifico.models.entitys.Customer;
import com.bolivar.pacifico.models.entitys.Invoice;
import com.bolivar.pacifico.models.entitys.Ticket;
import com.bolivar.pacifico.models.services.ICustomerService;
import com.bolivar.pacifico.models.services.ITicketService;
import com.bolivar.pacifico.models.dto.Mensaje;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
	
	//private final static Logger logger = LoggerFactory.getLogger(TicketController.class);

	@Autowired 
	private ITicketService ticketS;
		
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/tickets")
	public List<Ticket> listado(){
		return ticketS.findAll();
	}
	
	/*
	 * @GetMapping("/tickets/{priority}") public List<Ticket> findDash(@PathVariable
	 * String priority){ return ticketS.findDash(priority); }
	 */
	
	@GetMapping("/tickets/{vip}")
	public List<DashDto> findDash(@PathVariable int vip){
		return ticketS.findNoVip(vip);
	}
	
	@GetMapping("/tickets/detail/{id}")
	public ResponseEntity<TicketDetailsDto> listById(@PathVariable long id ){
		if (!ticketS.existsById(id))
			return new ResponseEntity<TicketDetailsDto>(HttpStatus.NOT_FOUND);
		TicketDetailsDto ticket = ticketS.findByDetail(id).get();
		return new ResponseEntity<TicketDetailsDto>(ticket,HttpStatus.OK);
		
	}

	//@Preauthorize("hasRole"('GESTOR')")
	@PutMapping("/tickets/detail/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody TicketDetailsDto ticketDetailsDto){
		if (!ticketS.existsById(id)) 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		if (StringUtils.isBlank(ticketDetailsDto.getName()))
			return new ResponseEntity<>(new Mensaje("El nombre del cliente es obligatorio"),HttpStatus.BAD_REQUEST);
		if (StringUtils.isBlank(ticketDetailsDto.getAddress()))
			return new ResponseEntity<>(new Mensaje("La direccion es obligatorio"),HttpStatus.BAD_REQUEST);
		
		TicketDetailsDto ticketDao = ticketS.findByDetail(id).get();
		Ticket ticket = ticketS.findById(ticketDao.getTicketid());
		Invoice invoice = ticket.getINVOICE();
		Customer customer = invoice.getCustomer();
		new Mensaje("hola" + customer);
		customer.setCname(ticketDetailsDto.getCname());
		customer.setAddress(ticketDetailsDto.getAddress());
		customer.setAdditionalinfo(ticketDetailsDto.getAdditionalinfo());
		customer.setTypedocument(ticketDetailsDto.getTypedocument());
		customer.setDocument(ticketDetailsDto.getDocument());
		ticket.setOBSERVATIONS(ticketDetailsDto.getObservations());
		ticket.setFRAUD(ticketDetailsDto.getFraud());
		ticket.setSTATE(ticketDetailsDto.getState());
		ticket.setCONDITIONS(ticketDetailsDto.getConditions());
		customerService.save(customer);
		ticketS.save(ticket);		
		return new ResponseEntity<>(new Mensaje("Producto actualizado"),HttpStatus.OK);
		
		
	}
}
		

