package ticket.generator.service;

import org.springframework.stereotype.Component;
import java.util.LinkedList;
import lombok.Data;

@Component
@Data
public class ColumnStripeManager {
	private LinkedList<String> column;
	public ColumnStripeManager(LinkedList<String> column) {
		this.column = column;
	}
	
}
