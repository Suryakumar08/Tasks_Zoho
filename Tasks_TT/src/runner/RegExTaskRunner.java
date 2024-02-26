package runner;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import exception.CustomException;
import tasks.HashMapTask;
import tasks.RegExTask;
import utility.CustomLogFormatter;
import utility.Utility;

public class RegExTaskRunner {
	private static final Logger logger = Logger.getLogger(RegExTaskRunner.class.toString());

	public static void setLogInfos() {
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setFormatter(new CustomLogFormatter());
		logger.addHandler(consoleHandler);
	}

	public static void main(String[] args) {
		setLogInfos();

		try (Scanner sc = new Scanner(System.in)) {
			RegExTask task = new RegExTask();
			boolean continueProgram = true;
			while (continueProgram) {
				try {
					logger.info("Enter your choice : ");
					int choice = Utility.getIntInput();

					switch (choice) {
					case 1: {
						logger.info("Enter a mobile number to validate : ");
						String number = sc.nextLine();
						boolean isValid = task.isValidMobileNumber(number);
						logger.info("Given number is " + (isValid ? "Valid" : "Invalid"));
						break;
					}
					case 2: {
						logger.info("Enter string to check whether it only contains AlphaNumeric characters :");
						String input = sc.nextLine();
						boolean hasAlphaNumericOnly = (task.hasAlphaNumericOnly(input));
						logger.info("Given input is " + (hasAlphaNumericOnly ? "Valid" : "Invalid"));
						break;
					}
					case 3: {
						logger.info("Enter input String : ");
						String input = sc.nextLine();
						logger.info("Enter matching String : ");
						String matchingString = sc.nextLine();

						boolean startsWithMatchingString = task.startsWithString(input, matchingString);
						logger.info("i) Given String starts with matching String : " + startsWithMatchingString);

						boolean stringContainsMatchingString = task.stringContainsString(input, matchingString);
						logger.info("ii) Given String contains matching String : " + stringContainsMatchingString);

						boolean stringEndsWithMatchingString = task.stringEndsWithString(input, matchingString);
						logger.info("ii) Given String ends with matching String : " + stringEndsWithMatchingString);

						boolean stringExactMatchOfString = task.isStringsExactMatch(input, matchingString, true);
						logger.info("ii) Given String exact match with matching String : " + stringExactMatchOfString);
						break;
					}
					case 4: {
						logger.info("Enter list of Strings : ");
						List<String> stringList = Utility.createListAndGetStrings();
						logger.info("Enter matching String : ");
						String matchingString = sc.nextLine();

						boolean listContainsMatch = task.isListContainsMatch(stringList, matchingString, false);
						logger.info("Given strings contains matching String(Case Insensitive) : " + listContainsMatch);
						break;
					}
					case 5: {
						logger.info("Enter a email to validate : ");
						String email = sc.nextLine();
						boolean isValidEmail = task.validateEmail(email);
						logger.info("Given email is valid : " + isValidEmail);
						break;
					}
					case 6: {
						logger.info("Enter list of Strings to check list only contain specified length of strings...");
						List<String> stringList = Utility.createListAndGetStrings();
						logger.info("Enter min length : ");
						int minLength = Utility.getIntInput();
						logger.info("Enter max length : ");
						int maxLength = Utility.getIntInput();
						boolean isStringsWithSpecifiedLength = task.checkListOfStringsWithSpecifiedLength(stringList,
								minLength, maxLength);
						logger.info("Given list contains strings with length ranging from " + minLength + " to "
								+ maxLength + " : " + isStringsWithSpecifiedLength);
						break;
					}
					case 7: {
						logger.info("Enter List1 Strings(Minimum 10 Strings) : ");
						List<String> list1 = Utility.createListAndGetStrings();
						logger.info("Enter List2 Strings(Maximum 3 strings and all strings must be in List1) : ");
						List<String> list2 = Utility.createListAndGetStrings();
						Map<String, Integer> stringToIndMap = task.getPositionOfString(list1, list2);
						Iterator<Map.Entry<String, Integer>> iterator = new HashMapTask().getIterator(stringToIndMap);
						while (iterator.hasNext()) {
							Map.Entry<String, Integer> element = (Map.Entry<String, Integer>) iterator.next();
							logger.info(element.getKey() + " -> " + element.getValue());
						}
						break;
					}
					case 8: {
						logger.info("Enter HTML code as String : ");
						String htmlCode = sc.nextLine();
						List<String> tagList = task.getStringWithinCharacters(htmlCode, "<", ">");
						int count = 1;
						for (String tag : tagList) {
							logger.info(count++ + ") " + tag);
						}
						break;
					}
					case 9:{
						logger.info("Enter your password : ");
						String password = sc.nextLine();
						boolean isValidPass = task.passwordChecker(password);
						logger.info("Valid pass : " + isValidPass);
						break;
					}
					default: {
						continueProgram = false;
						logger.info("Task Completed!!!");
						break;
					}
					}

				} catch (CustomException ex) {
					logger.log(Level.SEVERE, ex.getMessage());
				} catch (Exception ex) {
					logger.log(Level.SEVERE, ex.getMessage());
				}
			}
		}
	}
}
