package com.bolivar.pacifico.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolivar.pacifico.models.dto.DashDto;
import com.bolivar.pacifico.models.dto.TicketDetailsDto;
import com.bolivar.pacifico.models.entitys.Ticket;

@Service
public interface ITicketService {
	
	public List<Ticket> findAll();
	
	public Ticket findById(Long id);
	
	public Ticket save(Ticket ticket);
	
	//public Ticket saveDetails(Ticket ticket);
	
	//public List<Ticket> findDash(String priority);
	
	public List<DashDto> findNoVip(int vip);
	
	public boolean existsById (long id);
	
	public Optional<TicketDetailsDto> findByDetail(long id);
	
	
	
}
