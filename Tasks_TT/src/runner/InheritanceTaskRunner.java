package runner;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import birds.Duck;
import birds.ParrotMOD;
import cars.Car;
import cars.SCross;
import cars.Swift;
import cars.XUV;
import exception.CustomException;
import utility.CustomLogFormatter;


public class InheritanceTaskRunner{
	
	private static Logger logger = Logger.getLogger(InheritanceTaskRunner.class.toString());

	private static InheritanceTaskRunner runner;

	public static int getIntInput() throws CustomException{
		try (Scanner sc = new Scanner(System.in)) {
			boolean intGot = false;
			int number = -1;
			while(!intGot){
				try {
					number = sc.nextInt();
					intGot = true;
					sc.nextLine();
				} catch(InputMismatchException ex){
					sc.nextLine();
					throw new CustomException(CustomException.INPUT_MISMATCH_MESSAGE);	
				}
			}
			return number;
		}
	}
	
	//1
	public void doOperation1(){
		logger.info("Operation 1");
		logger.info("1) Creating Car class and its subclasses with getter and setter methods...");
		logger.info("Car class and it's subclasses Swift, SCross and XUV are created successfully");
		
	}


	public Swift doOperation2(){
		logger.info("Operation 2");
		try (Scanner sc = new Scanner(System.in)) {
			logger.info("2)Creating a Swift car...");
			Swift swift = new Swift();
			logger.info("Swift object created successfully");

			boolean seatsSetted = false;
			while(!seatsSetted){
				try{
					logger.info("Enter no.of seats :");
					int seats = InheritanceTaskRunner.getIntInput();		
					swift.setSeats(seats);
					seatsSetted = true;
				}
				catch(CustomException ex){
					logger.info(ex.getMessage());
				}
			}
			
			boolean airbagsSetted = false;
			while(!airbagsSetted){
				try{
					logger.info("Enter no.of airbags : ");
					int airbags = InheritanceTaskRunner.getIntInput();
					swift.setAirBags(airbags);
					airbagsSetted = true;
				}
				catch(CustomException ex){
					logger.info(ex.getMessage());
				}
			}


			logger.info("Enter the model : ");
			String model = sc.nextLine();
			swift.setModel(model);

			logger.info("Enter color of swift :");
			String color = sc.nextLine();
			swift.setColor(color);

			
			logger.info(swift.toString());
			logger.info("No.of seats : " + swift.getSeats());
			logger.info("No.of airbags : " + swift.getAirBags());
			logger.info("Model name : " + swift.getModel());
			logger.info("Swift color : " + swift.getColor());
			

			return swift;
		}
	}

	public SCross doOperation3(){
		logger.info("Operation 3");
		try (Scanner sc = new Scanner(System.in)) {
			logger.info("2)Creating a SCross car...");
			SCross scross = new SCross();
			logger.info("SCross object created successfully");

			
			boolean seatsSetted = false;
			while(!seatsSetted){
				try{
					logger.info("Enter no.of seats :");
					int seats = InheritanceTaskRunner.getIntInput();
					scross.setSeats(seats);
					seatsSetted = true;
				}
				catch(CustomException ex){
					logger.info(ex.getMessage());
				}
			}
			
			boolean airbagsSetted = false;
			while(!airbagsSetted){
				try{
					logger.info("Enter no.of airbags : ");
					int airbags = InheritanceTaskRunner.getIntInput();
					scross.setAirBags(airbags);
					airbagsSetted = true;
				}
				catch(CustomException ex){
					logger.info(ex.getMessage());
				}
			}

			try{
				logger.info("Enter the model : ");
				String model = sc.nextLine();
				scross.setModel(model);	
				logger.info("Enter color of scross :");
				String color = sc.nextLine();
				scross.setColor(color);
			}
			catch(CustomException ex){
				logger.info(ex.getMessage());
			}

			

			
			logger.info("SCross...");
			logger.info("Seats : " + scross.getSeats());
			logger.info("AirBags : " + scross.getAirBags());
			logger.info("Model : " + scross.getModel());
			logger.info("Color : " + scross.getColor());
			logger.info("Year Of Making : " + scross.getYearOfMake());
			logger.info("Engine Number : " + scross.getEngineNumber());
			logger.info("Type : " + scross.getType());

			return scross;
		}
	}

	public void doOperation45(Swift swift, SCross scross, XUV xuv){
		
		logger.info("Operation 4 and Operation 5");
		logger.info("A method created to get a car as input...");
		try{
			logger.info("Calling that method with swift object");
			getCarInput(swift);
			logger.info("Compiled successfully");
		}
		catch(Exception e){
			logger.log(Level.SEVERE, " Exception ", e);		}
		

		try{
			logger.info("Calling that method with scross object");
			getCarInput(scross);
			logger.info("Compiled successfully");
		}
		catch(Exception e){
			logger.log(Level.SEVERE, " Exception ", e);		}
		

		try{
			logger.info("Calling that method with XUV object");
			getCarInput(xuv);
			logger.info("Compiled successfully");
		}
		catch(Exception e){
			logger.log(Level.SEVERE, " Exception ", e);		}
	
	}

	public void doOperation6(Swift swift, Car carReferencedSwift, XUV xuv, SCross scross){
		logger.info("\nOperation 6");
		try{
			logger.info("Calling getOnlySwift with swift");
			getOnlySwift(swift);
			logger.info("Compiled successfully");
		}
		catch(Exception e){
			logger.log(Level.SEVERE, " Exception ", e);		}
		


/*
		try{
			logger.info("Calling getOnlySwift with carReferencedswift");
			getOnlySwift(carReferencedSwift);											//Compilation error




			InheritanceRunner.java:192: error: incompatible types: Car cannot be converted to Swift
			getOnlySwift(carReferencedSwift);
			             ^
InheritanceRunner.java:202: error: incompatible types: XUV cannot be converted to Swift
			getOnlySwift(xuv);
			             ^
InheritanceRunner.java:212: error: incompatible types: SCross cannot be converted to Swift
			getOnlySwift(scross);
			             ^




						logger.info("Compiled successfully");
		}
		catch(Exception e){
logger.log(Level.SEVERE, " Exception ", e);		}
		

		try{
			logger.info("Calling getOnlySwift with Xuv");
			getOnlySwift(xuv);
			logger.info("Compiled successfully");
		}
		catch(Exception e){
logger.log(Level.SEVERE, " Exception ", e);		}
		

		try{
			logger.info("Calling getOnlySwift with Scross");
			getOnlySwift(scross);
			logger.info("Compiled successfully");
		}
		catch(Exception e){
logger.log(Level.SEVERE, " Exception ", e);		}*/

		

	}

	public void doOperation7(SCross scross, Car carReferencedSCross, Car car, Swift swift){
		
		logger.info("Operation 7");
		logger.info("Maintenance ...");
		try{
			logger.info("SCross scross");
			scross.maintenance();
			logger.info("Compiled successfully");			
		}
		catch(Exception e){
			logger.log(Level.SEVERE, " Exception ", e);		}

		try{
			logger.info("Car carReferencedSCross");
			carReferencedSCross.maintenance();
			logger.info("Compiled successfully");			
		}
		catch(Exception e){
			logger.log(Level.SEVERE, " Exception ", e);		}

		try{
			logger.info("Car car");
			car.maintenance();
			logger.info("Compiled successfully");			
		}
		catch(Exception e){
			logger.log(Level.SEVERE, " Exception ", e);		}

		try{
			logger.info("Swift swift");
			scross.maintenance();
			logger.info("Compiled successfully");			
		}
		catch(Exception e){
			logger.log(Level.SEVERE, " Exception ", e);
		}

	}


	public void doOperation8(){
		
		logger.info("Operation 8");
		XUV xuv3 = new XUV("I am a car");
		logger.info(xuv3.toString());
	}


	public void doOperation9(){
		logger.info("Operation 9");
		//i)//compilation error
		// try{
		// 	logger.info("Abstract BirdAbstract class created.. creating object for that");
		// 	BirdAbstract bird1 = new BirdAbstract();
		// 	logger.info("Compiled successfully");
		// }catch(Exception e){
		// 	logger.info(e);
		// 	
		// }

		//ii)
		try{
			logger.info("ParrotMOD created... calling fly and speak of ParrotMOD");
			ParrotMOD parrot = new ParrotMOD();
			parrot.fly();
			parrot.speak();
		}
		catch(Exception e){
			logger.info("Compiled successfully");
		}
	}

	public void doOperation10(Duck duck){

		duck.fly();
		duck.speak();
	}

	public static void main(String args[]){
		
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new CustomLogFormatter());
		logger.addHandler(handler);

		logger.info("Inheritance task !!!");
		runner = new InheritanceTaskRunner();

		//1
		runner.doOperation1();
		
		//2
		Swift swift = runner.doOperation2();
		
		//3
		SCross scross = runner.doOperation3();
		
		//4,5
		XUV xuv = new XUV();
		runner.doOperation45(swift, scross, xuv);
		


		//6

		Car carReferencedSwift = new Swift();
		runner.doOperation6(swift, carReferencedSwift, xuv, scross);
		

		//7
		Car car = new Car();
		Car carReferencedSCross = new SCross();
		runner.doOperation7(scross, car, carReferencedSCross, swift);


		//8
		runner.doOperation8();


		//9
		runner.doOperation9();


		//10
		
		logger.info("Operation 10");
		logger.info("Duck object created");
		Duck duck = new Duck();
		runner.doOperation10(duck);

	}


	//4
	public static void getCarInput(Car car){
		logger.info("Inside getCarInput");
		if(car instanceof Swift){
			logger.info("Hatch");
		}
		else if(car instanceof XUV){
			logger.info("SUV");
		}
		else if(car instanceof SCross){
			logger.info("Sedan");
		}
	}


	//5
	public static void getOnlySwift(Swift swift){
		logger.info("Inside getOnlySwift");
	}
}