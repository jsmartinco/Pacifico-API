package com.bolivar.pacifico.models.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import com.bolivar.pacifico.models.dto.DashDto;
import com.bolivar.pacifico.models.dto.TicketDetailsDto;
import com.bolivar.pacifico.models.entitys.Ticket;

public interface ITicketDao extends CrudRepository<Ticket, Long>, 
JpaSpecificationExecutor<Ticket>{
	
	//@Query("select t from Ticket t JOIN t.employee e where e.name = :priority")
	//public List<Ticket> findDash(@Param("priority") String priority);
	//@Query("select new com.bolivar.pacifico.models.dto.DashDto(t2.name, c.priority, i.difference, e.name) from Ticket t JOIN t.employee e JOIN t.invoice i JOIN i.customer c JOIN c.town t2 where e.name = :priority")

	//Este sirve para hacer join y solicitar dos campos
	//@Query("select new com.bolivar.pacifico.models.dto.DashDto(t.state, e.name, i.kwh) from Ticket t JOIN t.employee e join t.invoice i where e.vip = :priority and e.role = :role ")
	
	@Query("select new com.bolivar.pacifico.models.dto.DashDto(t.state, e.name, i.kwh) from Ticket t JOIN t.employee e join t.invoice i where e.vip = :noVip")
	public List<DashDto>findNoVip(@Param("noVip") int noVip);
	
	//@Query(nativeQuery = true, value = "SELECT t2.tname, c.address, c.name, c.additionalinfo, c.typedocument, c.document, c.priority, t.state, t.difference FROM TICKET t JOIN INVOICE i ON (t.INVOICEID = i.INVOICEID) JOIN CUSTOMER c ON (i.CUSTOMERID = c.CUSTOMERID) JOIN TOWN t2 ON (c.TOWNID = t2.TOWNID) WHERE t.TICKETID = :id")
	
	@Query("select new com.bolivar.pacifico.models.dto.TicketDetailsDto(t.ticketid, t2.tname, c.address, c.cname, c.additionalinfo, c.typedocument, c.document, c.priority, t.state, t.difference, t.observations, t.conditions, t.fraud, e.name) from Ticket t join t.invoice i join i.customer c join c.town t2 join t.employee e where t.ticketid = :id")
	public Optional<TicketDetailsDto>findByDetail(@Param("id") long id);
	
		
	
}
