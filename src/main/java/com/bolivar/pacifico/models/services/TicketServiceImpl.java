package com.bolivar.pacifico.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolivar.pacifico.models.dao.ITicketDao;
import com.bolivar.pacifico.models.dto.DashDto;
import com.bolivar.pacifico.models.dto.TicketDetailsDto;
import com.bolivar.pacifico.models.entitys.Ticket;

@Service
public class TicketServiceImpl implements ITicketService{
	
	@Autowired
	private ITicketDao ticketDao;
		
	@Override
	@Transactional(readOnly = true)
	public List<Ticket> findAll() {
		return (List<Ticket>) ticketDao.findAll() ;
	}

	@Override
	public Ticket findById(Long id) {
		return ticketDao.findById(id).orElse(null);
	}

	@Override
	public Ticket save(Ticket ticket) {
		return ticketDao.save(ticket);
	}
	
	public List<DashDto> findNoVip(int vip) {
		return (List<DashDto>)ticketDao.findNoVip(vip);
	}

	@Override
	public boolean existsById(long id) {
		return ticketDao.existsById(id);
	}

	@Override
	public Optional<TicketDetailsDto> findByDetail(long id) {
		return ticketDao.findByDetail(id);
	}

	

	/*@Override
	public Ticket saveDetails(Ticket ticket) {
		return ticketDao.saveDetails();
	}
	*/

	
	
}
