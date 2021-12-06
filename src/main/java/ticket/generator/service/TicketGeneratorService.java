package ticket.generator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket.generator.dto.TicketDTO;

import static ticket.generator.constant.TicketGeneratorConstant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TicketGeneratorService {
	@Autowired
	private StripeManager stripManager;
	
	public TicketDTO generateStripe() {
		TicketDTO result = new TicketDTO();
		for(int n=FIRST_NUMBER; n<=LAST_NUMBER; n++) 
			stripManager.setNumberStripe(n);
		result.setNumbers(stripManager.getStripe());
		return result;
	}

}
