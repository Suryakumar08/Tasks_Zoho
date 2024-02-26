package runner;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import customClasses.CustomClass1;
import exception.CustomException;
import helper.HashMapTaskHelper;
import tasks.HashMapTask;
import utility.CustomLogFormatter;
import utility.Utility;

public class HashMapTaskRunner {
	private static Logger logger = Logger.getLogger(HashMapTaskRunner.class.toString());

	public static void main(String[] args) {
		
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new CustomLogFormatter());
		logger.addHandler(handler);
		
		HashMapTaskHelper helper = new HashMapTaskHelper();
		HashMapTask task = new HashMapTask();
		Scanner sc = new Scanner(System.in);

		boolean continueProgram = true;
		while (continueProgram) {
			try {
				logger.info("Enter your choice : ");
				int choice = Utility.getIntInput();
				switch (choice) {
				case 1: {
					helper.printOperation(choice);
					Map<Integer, Integer> map1 = task.getHashMap();
					logger.info("HashMap : " + map1);
					logger.info("Size : " + task.getMapSize(map1));
					
					break;
				}
				case 2: {
					helper.printOperation(choice);
					Map<String, String> map2 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map2, key, value);
					}
					logger.info("Map : " + map2);
					logger.info("Size : " + task.getMapSize(map2));
					
					break;
				}
				case 3: {
					helper.printOperation(choice);
					Map<Integer, Integer> map3 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter Integer key : ");
						int key = Utility.getIntInput();
						logger.info("Enter Integer value : ");
						int value = Utility.getIntInput();
						task.putInputInMap(map3, key, value);
					}
					logger.info("Map : " + map3);
					logger.info("Size : " + task.getMapSize(map3));
					
					break;
				}
				case 4: {
					helper.printOperation(choice);
					Map<String, Integer> map4 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter Integer value : ");
						int value = Utility.getIntInput();
						task.putInputInMap(map4, key, value);
					}
					logger.info("Map : " + map4);
					logger.info("Size : " + task.getMapSize(map4));
					
					break;
				}
				case 5: {
					helper.printOperation(choice);
					Map<Integer, CustomClass1> map5 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter Integer key : ");
						int key = Utility.getIntInput();
						logger.info("Creating custom object : ");
						CustomClass1 value = Utility.getCustomClassObject();
						task.putInputInMap(map5, key, value);
					}
					logger.info("Map : " + map5);
					logger.info("Size : " + task.getMapSize(map5));
					
					break;
				}
				case 6: {
					helper.printOperation(choice);
					Map<String, String> map6 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						String value = null;
						if (i == 0) {
							logger.info("First value is null");
						} else {
							logger.info("Enter String value : ");
							value = sc.nextLine();
						}
						task.putInputInMap(map6, key, value);
					}
					logger.info("Map : " + map6);
					logger.info("Size : " + task.getMapSize(map6));
					
					break;
				}
				case 7: {
					helper.printOperation(choice);
					Map<String, String> map7 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						String key = null;
						if (i == 0) {
							logger.info("First key is null");
						} else {
							logger.info("Enter String key : ");
							key = sc.nextLine();
						}
						logger.info("Enter String value : ");
						String value = sc.nextLine();

						task.putInputInMap(map7, key, value);
					}
					logger.info("Map : " + map7);
					logger.info("Size : " + task.getMapSize(map7));
					
					break;
				}
				case 8: {
					helper.printOperation(choice);
					Map<String, String> map8 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map8, key, value);
					}
					logger.info("Map : " + map8);
					logger.info("Size : " + task.getMapSize(map8));
					logger.info("Enter a string to check : ");
					String toCheck = sc.nextLine();
					boolean isPresent = task.isKeyPresent(map8, toCheck);
					logger.info("Is given key present? " + isPresent);
					
					break;
				}
				case 9: {
					helper.printOperation(choice);
					Map<String, String> map9 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map9, key, value);
					}
					logger.info("Map : " + map9);
					logger.info("Size : " + task.getMapSize(map9));
					logger.info("Enter a string to check : ");
					String toCheck = sc.nextLine();
					boolean isPresent = task.isValuePresent(map9, toCheck);
					logger.info("Is given value present? " + isPresent);
					
					break;
				}
				case 10: {
					helper.printOperation(choice);
					Map<String, String> map10 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map10, key, value);
					}
					logger.info("Map : " + map10);
					logger.info("Size : " + task.getMapSize(map10));
					logger.info("Enter a value to replace : ");
					String valueToReplace = sc.nextLine();
					logger.info("Replacing all values...");
					task.replaceAllValues(map10, valueToReplace);
					logger.info("Map : " + map10);
					logger.info("Size : " + task.getMapSize(map10));
					
					break;
				}
				case 11: {
					helper.printOperation(choice);
					Map<String, String> map11 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map11, key, value);
					}
					logger.info("Map : " + map11);
					logger.info("Size : " + task.getMapSize(map11));
					logger.info("Enter the key to get value : ");
					String toFind = sc.nextLine();
					String resultValue = (String) task.getValueFromKey(map11, toFind);
					logger.info("Value of " + toFind + " : " + resultValue);
					
					break;
				}
				case 12: {
					helper.printOperation(choice);
					Map<String, String> map12 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map12, key, value);
					}
					logger.info("Map : " + map12);
					logger.info("Size : " + task.getMapSize(map12));
					logger.info("Enter the non-existing key : ");
					String toFind = sc.nextLine();
					String resultValue = (String) task.getValueFromKey(map12, toFind);
					logger.info("Value of " + toFind + " : " + resultValue);
					
					break;
				}
				case 13: {
					helper.printOperation(choice);
					Map<String, String> map13 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map13, key, value);
					}
					logger.info("Map : " + map13);
					logger.info("Size : " + task.getMapSize(map13));
					logger.info("Enter the key : ");
					String toFind = sc.nextLine();
					logger.info("Enter default value to show :");
					String defaultValue = sc.nextLine();
					String resultValue = (String)task.getValueOrDefault(map13, toFind, defaultValue);
					logger.info("Value of " + toFind + " : " + resultValue);
					
					break;
				}
				case 14: {
					helper.printOperation(choice);
					Map<String, String> map14 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map14, key, value);
					}
					logger.info("Map : " + map14);
					logger.info("Size : " + task.getMapSize(map14));
					logger.info("Enter the key : ");
					String toRemove = sc.nextLine();
					task.removeEntry(map14, toRemove);
					logger.info("Entry removed!");
					logger.info("Map : " + map14);
					logger.info("Size : " + task.getMapSize(map14));
					
					break;
				}
				case 15: {
					helper.printOperation(choice);
					Map<String, String> map15 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map15, key, value);
					}
					logger.info("Map : " + map15);
					logger.info("Size : " + task.getMapSize(map15));
					logger.info("Enter the key : ");
					String toRemove = sc.nextLine();
					logger.info("Enter value to check : ");
					String toCheck = sc.nextLine();
					boolean isRemoved = task.removeEntryOnCondition(map15, toRemove, toCheck);
					if (isRemoved) {
						logger.info("Entry removed!");
					}
					logger.info("Map : " + map15);
					logger.info("Size : " + task.getMapSize(map15));
					
					break;
				}
				case 16: {
					helper.printOperation(choice);
					Map<String, String> map16 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map16, key, value);
					}
					logger.info("Map : " + map16);
					logger.info("Size : " + task.getMapSize(map16));
					logger.info("Enter the key : ");
					String changeKey = sc.nextLine();
					logger.info("Enter new value to replace : ");
					String changeValue = sc.nextLine();
					task.replaceValue(map16, changeKey, changeValue);
					logger.info("Entry replaced!");
					logger.info("Map : " + map16);
					logger.info("Size : " + task.getMapSize(map16));
					
					break;
				}
				case 17: {
					helper.printOperation(choice);
					Map<String, String> map17 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map17, key, value);
					}
					logger.info("Map : " + map17);
					logger.info("Size : " + task.getMapSize(map17));
					logger.info("Enter the key : ");
					String changeKey = sc.nextLine();
					logger.info("Enter initial Value : ");
					String initialValue = sc.nextLine();
					logger.info("Enter new value to replace : ");
					String changeValue = sc.nextLine();
					boolean isReplaced = task.replaceValueOnCondition(map17, changeKey, initialValue, changeValue);
					if (isReplaced) {
						logger.info("Entry replaced!");
					}
					logger.info("Map : " + map17);
					logger.info("Size : " + task.getMapSize(map17));
					
					break;
				}
				case 18: {
					helper.printOperation(choice);
					Map<String, String> map18 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map18, key, value);
					}
					logger.info("Initial Map : " + map18);
					logger.info("Initial map Size : " + task.getMapSize(map18));
					logger.info("Creating new HashMap with same entries...");
					Map<String, String> newHashMap = task.getHashMap(map18);
					logger.info("Final new Map : " + map18);
					logger.info("Final new map Size : " + newHashMap);
					
					break;
				}
				case 19: {
					helper.printOperation(choice);
					Map<String, String> map19 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map19, key, value);
					}
					logger.info("Printing all entries through iteration");
					Iterator<Map.Entry<String, String>> iterator = task.getIterator(map19);
					while (iterator.hasNext()) {
						Map.Entry<String, String> el = iterator.next();
						logger.info("Key : " + el.getKey() + " ___ Value : " + el.getValue());
					}
					break;
				}
				case 20: {
					helper.printOperation(choice);
					Map<String, String> map20 = task.getHashMap();
					logger.info("Enter no.of inputs : ");
					int noOfInputs = Utility.getIntInput();
					for (int i = 0; i < noOfInputs; i++) {
						logger.info("Enter String key : ");
						String key = sc.nextLine();
						logger.info("Enter String value : ");
						String value = sc.nextLine();
						task.putInputInMap(map20, key, value);
					}
					logger.info("Map : " + map20);
					logger.info("Size : " + task.getMapSize(map20));
					logger.info("Removing all entries : ");
					task.removeAllEntries(map20);
					logger.info("Map : " + map20);
					logger.info("Size : " + task.getMapSize(map20));
					break;
				}
				}

			} catch (CustomException ex) {
				logger.warning(ex.getMessage());
			} catch (Exception e) {
				logger.warning(e.getMessage());
			}
		}
		sc.close();
	}

}
