package cars;
import java.time.YearMonth;

import exception.CustomException;
import utility.CarUtils;
public class Car{

	private static final int MIN_YEAR = 1800;

	private int yearOfMake;
	private String engineNumber;
	private String type;

	public Car(){
		
	}

	public Car(String string){
		System.out.println(string);
	}

	public int getYearOfMake(){
		return this.yearOfMake;
	}

	public void setYearOfMake(int yearOfMake)throws CustomException{
		CarUtils.checkNumber(yearOfMake, YearMonth.now().getYear(), MIN_YEAR);
		this.yearOfMake = yearOfMake;
	}

	public String getEngineNumber(){
		return this.engineNumber;
	}

	public void setEngineNumber(String engineNumber){
		this.engineNumber = engineNumber;
	}

	public String getType(){
		return this.type;
	}

	public void setType(String type){
		this.type = type;
	}


	public void maintenance(){
		System.out.println("Car under maintenance");
	}

	public String toString(){
		return ("Here are your car details : \n" + "Year of making : " + yearOfMake +"\nEngine number : " + engineNumber + "\nType : " + type + "\n");
	}

}