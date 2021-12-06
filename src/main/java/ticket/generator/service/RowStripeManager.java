package ticket.generator.service;

import org.springframework.stereotype.Component;
import static ticket.generator.constant.RowConstant.*;
import static ticket.generator.constant.TicketGeneratorConstant.NUM_VALUES_FOR_ROW;

import java.util.Random;;

@Component
public class RowStripeManager {
	//generate a row with 5 numbers in random positions and 4 blank spaces
	public char[] getRow(int[] numbers) {
		char[] result = new char[NUM_VALUES_FOR_ROW];
		int numValuesSelected = 0;
		for(int n = 0; n < numbers.length&&numValuesSelected<NUMBERS_FOR_ROW; n++) {
			Random rd = new Random();
			if(rd.nextBoolean()) {
				result[n] = (char) numbers[n];
				numValuesSelected += 1;
			}
			else
				result[n] = ' ';
		}
		return result;
	}
}
