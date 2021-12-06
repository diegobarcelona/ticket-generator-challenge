package ticket.generator.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static ticket.generator.constant.TicketGeneratorConstant.NUM_VALUES_FOR_ROW;
import static ticket.generator.constant.TicketGeneratorConstant.NUM_VALUES_FOR_COLUMN;
import static ticket.generator.constant.TicketGeneratorConstant.TOTAL_TICKETS_FOR_STRIPE;
import static ticket.generator.constant.ColumnConstant.*;
import static ticket.generator.constant.RowConstant.NUMBERS_FOR_ROW;
import static ticket.generator.constant.RowConstant.BLANK_SPACES_FOR_ROW;;

@Component
public class StripeManager {
	private int totalRowsStripe = NUM_VALUES_FOR_COLUMN*TOTAL_TICKETS_FOR_STRIPE;
	private ColumnStripeManager[] columns = new ColumnStripeManager[totalRowsStripe];//[NUM_VALUES_FOR_COLUMN];
	//private LinkedList<LinkedList<Integer>> columnsList = new LinkedList<LinkedList<Integer>>();
	private LinkedList<String>[] columnsList = new LinkedList[NUM_VALUES_FOR_ROW];
	private boolean initialize = true;
	private boolean blankSpace = false;
	private int[] numbersForRowCounter = new int[NUM_VALUES_FOR_ROW];
	private boolean[][] stripeScheme = new boolean[totalRowsStripe][NUM_VALUES_FOR_ROW];
	private int[][] stripe = new int[totalRowsStripe][NUM_VALUES_FOR_ROW];
	private int[] isRowNumber = new int[totalRowsStripe];
	private int[] isRowBlank = new int[totalRowsStripe];
	public void setNumberStripe(int value){//, int sequence) {
		if(initialize) {
			this.setNewRandomStripeScheme();
			this.setColumns();
			this.setNumbersForRowCounter();
			initialize = false;
		}
		if(value>=FIRST_NUMBER_1ST_COLUMN&&value<=LAST_NUMBER_1ST_COLUMN) {
			//columnsList.getFirst().add(value);
			//this.setNumberOnColumn(value, 0);
			for(int row=0; row<totalRowsStripe; row++) {
				if(!stripeScheme[row][0]) {
					stripe[row][0] = value;
					break;
				}
			}
		}
		else if(value>=FIRST_NUMBER_2ND_COLUMN&&value<=LAST_NUMBER_2ND_COLUMN) {
			//columnsList.get(1).add(value);
			//this.setNumberOnColumn(value, 1);
			for(int row=0; row<totalRowsStripe; row++) {
				if(!stripeScheme[row][1]) {
					stripe[row][1] = value;
					break;
				}
			}
		}
		else if(value>=FIRST_NUMBER_3RD_COLUMN&&value<=LAST_NUMBER_3RD_COLUMN) {
			//columnsList.get(2).add(value);
			//this.setNumberOnColumn(value, 2);
			for(int row=0; row<totalRowsStripe; row++) {
				if(!stripeScheme[row][2]) {
					stripe[row][2] = value;
					break;
				}
			}
		}
		else if(value>FIRST_NUMBER_4TH_COLUMN&&value<=LAST_NUMBER_4TH_COLUMN) {
			//columnsList.get(3).add(value);
			//this.setNumberOnColumn(value, 3);
			for(int row=0; row<totalRowsStripe; row++) {
				if(!stripeScheme[row][3]) {
					stripe[row][3] = value;
					break;
				}
			}
		}
		else if(value>FIRST_NUMBER_5TH_COLUMN&&value<=LAST_NUMBER_5TH_COLUMN) {
			//columnsList.get(4).add(value);
			//this.setNumberOnColumn(value, 4);
			for(int row=0; row<totalRowsStripe; row++) {
				if(!stripeScheme[row][4]) {
					stripe[row][4] = value;
					break;
				}
			}
		}
		else if(value>FIRST_NUMBER_6TH_COLUMN&&value<=LAST_NUMBER_6TH_COLUMN) {
			//columnsList.get(5).add(value);
			//this.setNumberOnColumn(value, 5);
			for(int row=0; row<totalRowsStripe; row++) {
				if(!stripeScheme[row][5]) {
					stripe[row][5] = value;
					break;
				}
			}
		}
		else if(value>FIRST_NUMBER_7TH_COLUMN&&value<=LAST_NUMBER_7TH_COLUMN) {
			//columnsList.get(6).add(value);
			//this.setNumberOnColumn(value, 6);
			for(int row=0; row<totalRowsStripe; row++) {
				if(!stripeScheme[row][6]) {
					stripe[row][6] = value;
					break;
				}
			}
		}
		else if(value>FIRST_NUMBER_8TH_COLUMN&&value<=LAST_NUMBER_8TH_COLUMN) {
			//columnsList.get(7).add(value);
			//this.setNumberOnColumn(value, 7);
			for(int row=0; row<totalRowsStripe; row++) {
				if(!stripeScheme[row][7]) {
					stripe[row][7] = value;
					break;
				}
			}
		}
		else if(value>FIRST_NUMBER_9TH_COLUMN&&value<=LAST_NUMBER_9TH_COLUMN) {
			//columnsList.getLast().add(value);
			//this.setNumberOnColumn(value, 8);
			for(int row=0; row<totalRowsStripe; row++) {
				if(!stripeScheme[row][8]) {
					stripe[row][8] = value;
					break;
				}
			}
		}
	}
	
	public int[][] getStripe(){
		return stripe;
	}
	
	private void setColumns() {
		for(int n = 0; n < TOTAL_TICKETS_FOR_STRIPE; n++) {
			//columnsList.add(new LinkedList<Integer>());
			//columns[n] = new ColumnStripeManager(columnsList.get(n));
			columns[n] = new ColumnStripeManager(columnsList[n]);
		}
	}
	private void setNumbersForRowCounter() {
		for(int n=0; n<numbersForRowCounter.length; n++)
			numbersForRowCounter[n] = 0;
	}
	private void setNumberOnColumn(int value, int numColumn) {
		if(!blankSpace) {
			columnsList[numColumn].add(String.valueOf(value));
			if(numbersForRowCounter[numColumn]!=0&&numbersForRowCounter[numColumn]%NUMBERS_FOR_ROW==0)
				blankSpace = true;
			numbersForRowCounter[numColumn] += 1;
		}
		else {
			Random rand = new Random();
			int int_random = rand.nextInt(2);
			if(int_random==1) {
				String val = columnsList[numColumn].pop();
				columnsList[numColumn].add(" ");
				columnsList[numColumn].add(val);
			}
			else
				columnsList[numColumn].add(" ");
			if(columnsList[numColumn].size()!=0&&columnsList[numColumn].size()%NUM_VALUES_FOR_COLUMN==0) {
				String val = columnsList[numColumn].pop();
				String val2 = columnsList[numColumn].pop();
				if(val.equals(" ")&&val2.equals(" ")) {
					String val3 = columnsList[numColumn].pop();
					columnsList[numColumn].add(val);
					columnsList[numColumn].add(val3);
					columnsList[numColumn].add(val2);
				}
				else {
					columnsList[numColumn].add(val);
					columnsList[numColumn].add(val2);
				}
			}
			if(numbersForRowCounter[numColumn]!=0&&numbersForRowCounter[numColumn]%BLANK_SPACES_FOR_ROW==0)
				blankSpace = false;
		}
	}
	
	private boolean[][] setNewRandomStripeScheme() {
		this.setIsNumber();
		List<Boolean> isNumber = new ArrayList<Boolean>();
		for(int row=0; row<totalRowsStripe; row++) {
			for(int column=0; column<NUM_VALUES_FOR_ROW; column++) {
				stripeScheme[row][column] = isRowBlankSpace(column);
			}
		}
		/*
		int isBlank = 0;
		for(int column=0; column<NUM_VALUES_FOR_ROW; column++) {
			for(int row=0; row<totalRowsStripe; row++) {
				
				if(stripeScheme[row][column])
					isBlank += 1;
				else
					isBlank = 0;
				if(isBlank>MAX_BLANK_SPACES_FOR_COLUMN&&row%MAX_BLANK_SPACES_FOR_COLUMN==0) {
					for(int rowR=row; rowR<totalRowsStripe; rowR++) {
						if(!stripeScheme[rowR][column]) {
							stripeScheme[rowR][column] = true;
							Random random = new Random();
							int randomForIndex = random.nextInt(MAX_BLANK_SPACES_FOR_COLUMN);
							stripeScheme[row-randomForIndex][column] = false;
						}
					}
				}
				else
					isBlank = 0;
			}
		}
		*/
		for(int row=0; row<totalRowsStripe; row++){
			System.out.println("("+row+")");
			for(int column=0; column<NUM_VALUES_FOR_ROW; column++)  {
				System.out.print(" "+stripeScheme[row][column]);
			}
		}
		return stripeScheme;
	}
	
	private boolean isRowBlankSpace(int numRow) {
		Random isNumber = new Random();
		if(isNumber.nextBoolean()&&isRowNumber[numRow] > 0) {
			isRowNumber[numRow] -= 1;
		}
		else if(isRowBlank[numRow] > 0) {
			isRowBlank[numRow] -= 1;
			return true;
		}
		else
			isRowNumber[numRow] -= 1;
		return false;
	}
	
	private void setIsNumber() {
		for(int n=0; n<totalRowsStripe; n++) {
			isRowNumber[n] = NUMBERS_FOR_ROW;
			isRowBlank[n] = NUM_VALUES_FOR_ROW-NUMBERS_FOR_ROW;
		}
	}
}
