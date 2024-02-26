package runner;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import exception.CustomException;
import helper.Shapes;
import pojos.Customer;
import tasks.ArrayListTask;
import tasks.BasicProgrammingTask;
import tasks.BasicProgrammingTask.Color;
import tasks.HashMapTask;
import utility.CustomLogFormatter;
import utility.Utility;

//   /home/surya-pt-7357/eclipse-workspace/Tasks_TT

public class BasicProgrammingRunner {

	private static final Logger logger = Logger.getLogger(BasicProgrammingRunner.class.getName());

	public static void main(String... args) {

		try (Scanner sc = new Scanner(System.in)) {
			try {
				logger.setUseParentHandlers(false);
				FileHandler fileHandler = new FileHandler("loggerOutput.log");
				fileHandler.setFormatter(new CustomLogFormatter());
				logger.addHandler(fileHandler);
			} catch (SecurityException | IOException e) {
				logger.throwing("BasicProgrammingRunner", "main", e);
				throw new CustomException(CustomException.SOME_ERROR_MESSAGE, e);
//				logger.log(Level.SEVERE, "Exception stack trace : ", e);
			}
			logger.setLevel(Level.INFO);

			BasicProgrammingTask task = new BasicProgrammingTask();
			ArrayListTask arrListTask = new ArrayListTask();
			HashMapTask mapTask = new HashMapTask();
			boolean continueProgram = true;
			int choice = -1;

			while (continueProgram) {

				try {

					logger.info("Enter your choice : ");
					choice = Utility.getIntInput();

					switch (choice) {

					case 1: {
						logger.info("Create sample.txt and write 3 lines in it");
						List<String> contents = arrListTask.getArrayList();

						String path = System.getProperty("user.dir");

						logger.info("Enter your fileName with extension");
						String fileName = sc.nextLine();

						logger.info("Enter your contents :");
						while (sc.hasNextLine()) {
							String contentLine = sc.nextLine();
							if (contentLine.equals("")) {
								break;
							}
							arrListTask.addInputIntoArrList(contentLine, contents);
						}

						logger.info("Task 1 on process...");
						task.createFileAndAddContent(path, fileName, contents);
						logger.info("Task 1 Completed!!!");
						logger.info("");
						break;
					}

					case 2: {
						logger.info(
								"Store 5 values in java.util.properties and store them from properties into myprops.txt");
						Map<String, String> pairs = mapTask.getHashMap();

						logger.info("Enter no.of keys and values to be added : ");
						int noOfValues = Utility.getIntInput();

						for (int i = 0; i < noOfValues; i++) {
							logger.info((i + 1) + " key -> ");
							String key = sc.nextLine();
							logger.info((i + 1) + " value -> ");
							String value = sc.nextLine();
							mapTask.putInputInMap(pairs, key, value);
						}

						String path = System.getProperty("user.dir");
						logger.info("Enter File name with extension : ");
						String fileName = sc.nextLine();

						logger.info("Enter details about properties : ");
						String details = sc.nextLine();

						task.storeInPropertiesAndFile(path, fileName, pairs, details);
						logger.info("");
						break;
					}

					case 3: {
						logger.info("Read the keys & values from the above created myprops.txt file(any\n"
								+ "file) & store those values back into the java.util.Properties object and print the\n"
								+ "properties.");

						String path = System.getProperty("user.dir");
						logger.info("Enter file name with extension : ");
						String fileName = sc.nextLine();

						task.loadDataIntoProperties(path, fileName);

						logger.info("");
						break;
					}
					case 4: {
						logger.info("create the files sample.txt, myprops.txt under\n"
								+ "myDir. Please note that you should create the myDir directory\n"
								+ "programmatically.");

						logger.info("Enter path to make directory : ");
						String path = sc.nextLine();

						logger.info("Enter Directory name : ");
						String name = sc.nextLine();

						File myDir = task.makeDirAndRepeat(path, name);

						String newPath = task.getFilePath(myDir);

						logger.info("New Directory path is : " + newPath);

						path = newPath;

						List<String> contents = arrListTask.getArrayList();

						logger.info("Enter your fileName with extension");
						String fileName = sc.nextLine();

						logger.info("Enter your contents :");
						while (sc.hasNextLine()) {
							String contentLine = sc.nextLine();
							if (contentLine.equals("")) {
								break;
							}
							arrListTask.addInputIntoArrList(contentLine, contents);
						}
						task.createFileAndAddContent(path, fileName, contents); // 1

						Map<String, String> pairs = mapTask.getHashMap();

						logger.info("Enter no.of keys and values to be added : ");
						int noOfValues = Utility.getIntInput();

						for (int i = 0; i < noOfValues; i++) {
							logger.info((i + 1) + " key -> ");
							String key = sc.nextLine();
							logger.info((i + 1) + " value -> ");
							String value = sc.nextLine();
							mapTask.putInputInMap(pairs, key, value);
						}

						logger.info("Enter File name with extension : ");
						String newFileName = sc.nextLine();

						logger.info("Enter details about properties : ");
						String details = sc.nextLine();

						task.storeInPropertiesAndFile(path, newFileName, pairs, details);// 2

						logger.info("Enter file name to get data from with extension : ");
						String existingFileName = sc.nextLine();

						task.loadDataIntoProperties(path, existingFileName);

						break;

					}

					case 5: {
						logger.info(
								"Write a class with an additional constructor which accepts a “String” . Assign that String to an\n"
										+ "instance variable. Invoke this constructor from a separate runner class & print your object.");

						logger.info("Enter String for dummy class : ");
						String input = sc.nextLine();

						Shapes obj = new Shapes(input);

						logger.info("Printing object : " + obj);
						logger.info("");
						break;
					}

					case 6: {
						logger.info("Write a POJO class with a String variable, integer variable. Have the necessary\n"
								+ "getter & setter methods for these variables with proper access specifiers & return\n"
								+ "types. Now define a constructor which accepts all these variables as an argument & set the\n"
								+ "incoming values to the appropriate variables. Now from a separate runner class, you\n"
								+ "should try to create an instance for your class using the above said constructor & print your\n"
								+ "object. You have to print the object alone in the Runner but it should print those\n"
								+ "String & Integer variables automatically.");

						logger.info("Enter POJO name :");
						String name = sc.nextLine();

						logger.info("Enter POJO Number :");
						int pojoNumber = Utility.getIntInput();

						Customer obj = new Customer(name, pojoNumber);
						logger.info(obj.toString());
						break;
					}

					case 7: {
						logger.info(
								"create an instance for the abovePOJO class using the default constructor.Using that ,call the appropriate setter\n"
										+ "methods to set the values for the String, integer. After that invoke the appropriate\n"
										+ "getter methods & print each value that is set previously.");

						logger.info("Enter POJO name :");
						String name = sc.nextLine();

						logger.info("Enter POJO Number :");
						int pojoNumber = Utility.getIntInput();

						Customer obj = new Customer();

						obj.setCustomerName(name);
						obj.setCustomerNumber(pojoNumber);

						logger.info("Pojo Name : " + obj.getCustomerName());
						logger.info("Pojo Number : " + obj.getCustomerNumber());
						logger.info("");
						break;
					}

					case 8: {
						logger.info(
								"Write a POJO class with a default constructor & an overloaded constructor (String & Integer args). It\n"
										+ "have a String variable & Integer variable, with proper getter & setter methods for\n"
										+ "these variables. Compile the class. Write a runner class with a different package than\n"
										+ "the POJO class");

						logger.info("");
						logger.info(
								"i) In the runner class, POJO class should not be imported explicitly or implicitly.\n"
										+ "i) Runner class should get compiled without the POJO class."
										+ "ii) Invoke the default constructor of the POJO from the runner class\n"
										+ "iii) Invoke the overloaded constructor of the POJO from the runner class\n"
										+ "iv) Invoke any one getter method of the POJO from the runner class\n"
										+ "v) Invoke any one setter method of the POJO from the runner class");

						try {
							logger.info("Creating dummy student...");
							logger.info(task.createDummyStudentUsingReflection("pojos.Customer"));

							logger.info("Creating original student...");
							logger.info("Enter student name : ");
							String name = sc.nextLine();
							logger.info("Enter student number : ");
							int number = Utility.getIntInput();

							logger.info("Enter new name : ");
							String newName = sc.nextLine();

							logger.info(
									task.createOriginalStudentUsingReflection(name, number, "pojos.Student", newName));

							break;
						} catch (Exception ex) {
							logger.log(Level.SEVERE, "Exception stack trace : ", ex);
							throw new CustomException(CustomException.SOME_ERROR_MESSAGE, ex);
						}

					}

					case 9: {
						logger.info(
								"Define an Enum for the rainbow colors, with values(colorcode) ranging from 1 to 7.\n"
										+ "Print the color and its corresponding color code from the main method.. For eg: Color\n"
										+ "code of Violet is 1, Color code of Indigo is 2 etc. Invoke values() ordinal methods of\n"
										+ "the enum as well.");

						logger.log(Level.INFO, "Number for Blue color is : " + Color.Blue.getValue());
						Color favColor = Color.Blue;
						logger.log(Level.INFO, "" + favColor.getValue());

						Color colors[] = task.getAllColors();
						for (Color color : colors) {
							logger.info("Value of " + color + " in colors is : " + color.getValue());
						}
						logger.info("");

						break;

					}
					case 10: {
						logger.info(
								"Write a Singleton class, so that there exists only one instance of the class in a JVM.\n"
										+ "Also read about how the Singleton pattern evolved in Java & what will be the best\n"
										+ "way to write a Singleton class.");
						logger.info("First Instance : " + task.getMySQLUserConfig());

						logger.info("Second Instance : " + task.getMySQLUserConfig());
						break;
					}
					case 11: {
						logger.info("Write a class & add methods to do the following.\n"
								+ "1. Return the currentTime with Date, seconds etc\n"
								+ "2. Return the currentTime in milliseconds. Using System class as well.\n"
								+ "3. Return the currentTime with Date,seconds in New york & London. Observer\n"
								+ "the difference.\n"
								+ "4. Return the week day for the currentTime in millis or any given time in millis\n"
								+ "5. Return the month(not numeric) of the currentTime in millis or any given time\n"
								+ "in millis\n"
								+ "6. Return the Year of the currentTime in millis or any given time in millis");

						logger.info("i) Current date and time : " + task.getCurrentDate());
						logger.info("ii) Current time in millis : " + task.getCurrentTimeInMillis());

						for (String string : task.allZoneIds()) {
							logger.log(Level.INFO, string);
						}
						logger.info("Enter zone_id 1 : ");
						String zone1 = sc.nextLine();
						logger.info("Enter zone_id 2 : ");
						String zone2 = sc.nextLine();

						logger.info("iii) Time at " + zone1 + " is " + task.getTimeAtZone(zone1));
						logger.info("iii) Time at " + zone2 + " is " + task.getTimeAtZone(zone2));
						logger.info("iv) Day of current time in millis : "
								+ task.getDayFromMillis(task.getCurrentTimeInMillis()));
						logger.info("v) Month of current time in millis : "
								+ task.getMonthNameFromMillis(task.getCurrentTimeInMillis()));
						logger.info("vi) Year of current time in millis : "
								+ task.getYearFromMillis(task.getCurrentTimeInMillis()));
						break;
					}
					case 12: {
						logger.info("1. Replace all your logger.info() in your previous tasks with appropriate\n"
								+ "Logger.log method. Make sure to do this in your future tasks as well.\n"
								+ "2. Replace all your exp.getMessage() & exp.printStackTrace() with appropriate\n"
								+ "Logger.log method. Make sure to do this in your future tasks as well.");

					}
					default: {
						logger.info("Task Completed!!!");
						continueProgram = false;
						break;
					}
					}
				} catch (CustomException ex) {
					ex.printStackTrace();
					logger.severe(ex.getMessage());
				} catch (Exception ex) {
					logger.log(Level.SEVERE, "Exception stack Trace : ", ex);
					logger.severe(ex.getMessage());
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception stack Trace : ", e);
		}
	}

}
