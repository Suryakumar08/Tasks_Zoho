package runner;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import customClasses.CustomClass1;
import exception.CustomException;
import helper.ArrayListTaskHelper;
import tasks.ArrayListTask;
import utility.CustomLogFormatter;

public class ArrayListTaskRunner {
	
	
	private static final Logger logger = Logger.getLogger(ArrayListTaskRunner.class.toString());
	private static ArrayListTask task = new ArrayListTask();
	private static ArrayListTaskHelper helper = new ArrayListTaskHelper();

	public static <T> void addCustomObjectsInArrayList(List<T> arrList) throws CustomException {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter no.of Custom Objects :");
		int noOfCustomObjects = sc.nextInt();
		sc.nextLine();
		logger.info("Creating objects...");
		for (int i = 0; i < noOfCustomObjects; i++) {
			logger.info("Enter obj" + (i + 1) + " name : ");
			task.addInputIntoArrList((T)new CustomClass1(sc.nextLine()), arrList);
		}
		logger.info("Adding Custom objects into arrayList...");
		logger.info("Custom Objects added!");
		sc.close();
	}

	public static void addFloatsInArrayList(List<Float> arrList) throws CustomException {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter no.of Doubles :");
		int noOfFloats = sc.nextInt();
		sc.nextLine();
		logger.info("Enter " + noOfFloats + " Floats : ");
		for (int i = 0; i < noOfFloats; i++) {
			task.addInputIntoArrList(sc.nextFloat(), arrList);
		}
		logger.info("Adding Integers into arrayList...");
		logger.info("Integers added!");
		sc.close();
	}

	public static void addLongInArrayList(List<Long> arrList) throws CustomException {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter no.of Long :");
		int noOfLongs = sc.nextInt();
		sc.nextLine();
		logger.info("Enter " + noOfLongs + " Longs : ");
		for (int i = 0; i < noOfLongs; i++) {
			task.addInputIntoArrList(sc.nextLong(), arrList);
		}
		logger.info("Adding Longs into arrayList...");
		logger.info("Longs added!");
		sc.close();
	}

	public static void addIntegersInArrayList(List<Integer> arrList) throws CustomException {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter no.of Integers :");
		int noOfIntegers = sc.nextInt();
		sc.nextLine();
		logger.info("Enter " + noOfIntegers + " Integers : ");
		for (int i = 0; i < noOfIntegers; i++) {
			task.addInputIntoArrList(sc.nextInt(), arrList);
		}
		logger.info("Adding Integers into arrayList...");
		logger.info("Integers added!");
		sc.close();
	}

	public static void addStringsInArrayList(List<String> arrList) throws CustomException {
		Scanner sc = new Scanner(System.in);
		logger.info("Enter no.of Strings :");
		int noOfStrings = sc.nextInt();
		sc.nextLine();
		logger.info("Enter " + noOfStrings + " strings : ");
		for (int i = 0; i < noOfStrings; i++) {
			task.addInputIntoArrList(sc.nextLine(), arrList);
		}
		logger.info("Adding Strings into arrayList...");
		logger.info("Strings added!");
		sc.close();
	}

	public static int getIntInput(int min, int max) throws CustomException {
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new CustomLogFormatter());
		logger.addHandler(handler);
		try (Scanner sc = new Scanner(System.in)) {
			logger.info("Enter a number (" + min + ", " + max + ") :");
			int number = -1;
			while (true) {
				try {
					number = sc.nextInt();
					sc.nextLine();
					return number;
				} catch (InputMismatchException ex) {
					sc.nextLine();
					throw new CustomException(CustomException.INPUT_MISMATCH_MESSAGE);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		helper.printOperations();
		int choice = -1;
		try {
			logger.info("Enter your choice (1 to 17) : ");
			choice = sc.nextInt();
			sc.nextLine();
			if (choice < 1 || choice > 17) {
				throw new CustomException(CustomException.NUMBER_INVALID_MESSAGE);
			}
			switch (choice) {
			case 1: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<Integer> arrList = task.getArrayList();
				logger.info("ArrayList Created!");
				logger.info("Length of ArrayList is : " + task.getArrListSize(arrList) + "\n");
				break;
			}
			case 2: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<String> arrList = task.getArrayList();
				logger.info("ArrayList Created!");

				addStringsInArrayList(arrList);

				logger.info("ArrayList : " + arrList);
				logger.info("Length : " + task.getArrListSize(arrList));
				break;
			}
			case 3: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<Integer> arrList = task.getArrayList();
				logger.info("ArrayList Created!");

				addIntegersInArrayList(arrList);

				logger.info("ArrayList : " + arrList);
				logger.info("Length : " + task.getArrListSize(arrList));
				break;
			}
			case 4: {
				helper.printTask(choice);
				List<CustomClass1> arrList = task.getArrayList();
				logger.info("ArrayList of custom Objects created !");

				addCustomObjectsInArrayList(arrList);

				logger.info("ArrayList : " + arrList);
				logger.info("Length : " + task.getArrListSize(arrList));
				break;
			}
			case 5: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<Object> arrList = task.getArrayList();
				logger.info("ArrayList created!");
				try {
					List<Integer> intList = task.getArrayList();
					addIntegersInArrayList(intList);
					List<String> stringList = task.getArrayList();
					addStringsInArrayList(stringList);
					List<CustomClass1> objList = task.getArrayList();
					addCustomObjectsInArrayList(objList);
					task.appendListToList(intList, arrList);
					task.appendListToList(stringList, arrList);
					task.appendListToList(objList, arrList);

					logger.info("ArrayList  : " + arrList);
					logger.info("Length : " + task.getArrListSize(arrList));
				} catch (InputMismatchException e) {
					throw new CustomException(CustomException.INPUT_MISMATCH_MESSAGE);
				}

			}
			case 6: {
				helper.printTask(choice);
				logger.info("Creating String arrayList...");
				List<String> arrList = task.getArrayList();
				logger.info("String ArrayList created successfully");

				addStringsInArrayList(arrList);

				logger.info("Enter string to find its index");
				String toFind = sc.nextLine();

				int index = task.findIndex(toFind, arrList);

				logger.info("Index of " + toFind + " in arrayList is : " + index);
			}
			case 7: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<String> arrList = task.getArrayList();
				logger.info("ArrayList Created!");

				addStringsInArrayList(arrList);

				Iterator<String> iterator = task.printElementUsingIterator(arrList);
				while(iterator.hasNext()) {
					logger.info(iterator.next());
				}
			}
			case 8: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<String> arrList = task.getArrayList();
				addStringsInArrayList(arrList);
				logger.info("ArrayList Created!");
				logger.info("Enter index position :");
				int index = sc.nextInt();
				sc.nextLine();
				String element = (String) task.getElementAtPosition(index, arrList);
				logger.info("Element at index " + index + " is " + element);
				logger.info("ArrayList : " + arrList);
				logger.info("Length : " + task.getArrListSize(arrList));
			}
			case 9: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<String> arrList = task.getArrayList();
				logger.info("Enter duplicate elements!!");
				addStringsInArrayList(arrList);
				logger.info("ArrayList Created!");

				String duplicateString = sc.nextLine();
				int firstIndex = task.findFirstIndex(arrList, duplicateString);
				int lastIndex = task.findLastIndex(arrList, duplicateString);

				logger.info("First Index : " + firstIndex);
				logger.info("Last Index : " + lastIndex);
			}
			case 10: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<String> arrList = task.getArrayList();
				addStringsInArrayList(arrList);
				logger.info("ArrayList Created!");
				logger.info("Enter index position to add:");
				int index = sc.nextInt();
				sc.nextLine();
				logger.info("Enter String to add :");
				String stringToAdd = sc.nextLine();

				task.addElementAtSpecificPosition(stringToAdd, index, arrList);
				logger.info("Element added");
				logger.info("ArrayList : " + arrList);
				logger.info("Length : " + task.getArrListSize(arrList));
			}
			case 11: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<String> arrList = task.getArrayList();
				addStringsInArrayList(arrList);
				logger.info("ArrayList Created!");
				logger.info("Enter starting index : ");
				int from = sc.nextInt();
				logger.info("Enter ending index :");
				int to = sc.nextInt() + 1;
				sc.nextLine();

				List<String> subList = task.getSubList(arrList, from, to);

				logger.info(subList.toString());
			}
			case 12: {
				helper.printTask(choice);
				logger.info("Creating arrayList1...");
				List<String> arrList1 = task.getArrayList();
				addStringsInArrayList(arrList1);
				logger.info("ArrayList1 Created!");

				logger.info("Creating arrayList2...");
				List<String> arrList2 = task.getArrayList();
				addStringsInArrayList(arrList2);
				logger.info("ArrayList2 Created!");

				List<String> arrList3 = task.mergeArrayLists(arrList1, arrList2);
				logger.info("ArrayList 3 : " + arrList3);
			}
			case 13: {
				helper.printTask(choice);
				logger.info("Creating arrayList1...");
				List<String> arrList1 = task.getArrayList();
				addStringsInArrayList(arrList1);
				logger.info("ArrayList1 Created!");

				logger.info("Creating arrayList2...");
				List<String> arrList2 = task.getArrayList();
				addStringsInArrayList(arrList2);
				logger.info("ArrayList2 Created!");

				List<String> arrList3 = task.mergeArrayLists(arrList2, arrList1);
				logger.info("ArrayList 3 : " + arrList3);
				logger.info("Length : " + task.getArrListSize(arrList3));
			}

			case 14: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<Float> arrList = task.getArrayList();
				addFloatsInArrayList(arrList);
				logger.info("ArrayList Created!");
				logger.info("Enter index position to remove:");
				int index = sc.nextInt();
				sc.nextLine();

				task.removeElementAtIndex(arrList, index);

				logger.info("ArrayList : " + arrList);
			}
			case 15: {
				helper.printTask(choice);
				logger.info("Creating arrayList1...");
				logger.info("Enter minimum 5 strings");
				List<String> arrList1 = task.getArrayList();
				addStringsInArrayList(arrList1);
				logger.info("ArrayList1 Created!");

				logger.info("Creating arrayList2...");
				logger.info("Enter 3 strings same as first arrayList");
				List<String> arrList2 = task.getArrayList();
				addStringsInArrayList(arrList2);
				logger.info("ArrayList2 Created!");

				task.removeElements(arrList1, arrList2, true);
				logger.info("ArrayList : " + arrList1);
			}
			case 16: {
				helper.printTask(choice);
				logger.info("Creating arrayList1...");
				logger.info("Enter minimum 5 strings");
				List<String> arrList1 = task.getArrayList();
				addStringsInArrayList(arrList1);
				logger.info("ArrayList1 Created!");

				logger.info("Creating arrayList2...");
				logger.info("Enter 3 strings same as first arrayList");
				List<String> arrList2 = task.getArrayList();
				addStringsInArrayList(arrList2);
				logger.info("ArrayList2 Created!");

				task.removeElements(arrList1, arrList2, false);
				logger.info("ArrayList : " + arrList1);
			}
			case 17: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<Long> arrList = task.getArrayList();
				logger.info("ArrayList Created!");

				logger.info("Enter minimum of 10 Long values : ");
				addLongInArrayList(arrList);
				logger.info("Initial arrayList : " + arrList);
				task.deleteAllElements(arrList);
				logger.info("Final arrayList : " + arrList);
			}
			case 18: {
				helper.printTask(choice);
				logger.info("Creating arrayList...");
				List<String> arrList = task.getArrayList();
				addStringsInArrayList(arrList);
				logger.info("ArrayList Created!");
				logger.info("Enter String to check : ");
				String checkString = sc.nextLine();

				boolean isContain = task.checkIfElementPresent(arrList, checkString);
				logger.info("Is given string contain : " + isContain);
			}
			}

		} catch (CustomException ex) {
			sc.nextLine();
			logger.warning(ex.getMessage());
		}

	}

}
