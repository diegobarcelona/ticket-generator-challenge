package ticket.generator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket.generator.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
