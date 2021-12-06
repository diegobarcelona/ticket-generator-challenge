package ticket.generator.controller;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ticket.generator.dto.TicketDTO;
import ticket.generator.service.TicketGeneratorService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	private TicketGeneratorService ticketService;
	@GetMapping(produces = "application/json")
	public ResponseEntity<TicketDTO> getStripe(){
		TicketDTO result = ticketService.generateStripe();
		return new ResponseEntity<TicketDTO>(result, OK);
	}
}
