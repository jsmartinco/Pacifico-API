package com.bolivar.pacifico.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolivar.pacifico.models.criteria.TicketCriteria;
import com.bolivar.pacifico.models.dao.ITicketDao;
import com.bolivar.pacifico.models.entitys.Ticket;

import io.github.jhipster.service.QueryService;

@Service
@Transactional(readOnly = true)
public class FiltroService extends QueryService<Ticket> {

	@Autowired
	ITicketDao iTicketDao;

	public List<Ticket> findByCriteria(TicketCriteria ticketCriteria) {
		final Specification<Ticket> specification = createSpecification(ticketCriteria);
		List<Ticket> tickets = iTicketDao.findAll(specification);
		return tickets;
	}

	private Specification<Ticket> createSpecification(TicketCriteria criteria) {
		Specification<Ticket> specification = Specification.where(null);
		if (criteria != null) {
			/*
			   if (criteria.getEmployee() != null) specification =
			   specification.and(buildStringSpecification(criteria.getEmployee(), Ticket_));
			  
			 */
		}
		return specification;

	}
}
