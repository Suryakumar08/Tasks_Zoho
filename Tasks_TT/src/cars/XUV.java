package cars;

import exception.CustomException;
import utility.CarUtils;

public class XUV extends Car{

	private static final int MAX_SEATS = 7;
	private static final int MIN_SEATS = 1;
	private static final int MAX_AIRBAGS = 4;
	private static final int MIN_AIRBAGS = 0;

	private int seats;
	private int airBags;
	private String model;
	private String color;
	public XUV(){
		
	}

	// XUV(int seats, int airBags, String model, String color){
	// 	this.seats = seats;
	// 	this.airBags = airBags;
	// 	this.model = model;
	// 	this.color = color;
	// }

	public XUV(String string){
		super(string);
	}

	public int getSeats(){
		return this.seats;
	}

	public void setSeats(int seats) throws CustomException{
		CarUtils.checkNumber(seats, MAX_SEATS, MIN_SEATS);
		this.seats = seats;
	}

	public int getAirBags(){
		return this.airBags;
	}

	public void setAirBags(int airBags)throws CustomException{
		CarUtils.checkNumber(airBags, MAX_AIRBAGS, MIN_AIRBAGS);
		this.airBags = airBags;
	}

	public String getModel(){
		return this.model;
	}

	public void setModel(String model){
		this.model = model;
	}

	public String getColor(){
		return this.color;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String toString(){
		return ("Here are your XUV car details : \n" + "No.of seats : " + seats +"\nNo.of airbags : " + airBags + "\nModel : " + model + "\nColor : " + color + "\n");
	}

}