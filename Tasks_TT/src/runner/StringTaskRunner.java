package runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import exception.CustomException;
import helper.StringTaskHelper;
import tasks.StringTask;
import utility.CustomLogFormatter;

public class StringTaskRunner{

	private static final Logger logger = Logger.getLogger(StringTaskRunner.class.toString());

	public static void main(String args[]){
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new CustomLogFormatter());
		logger.addHandler(handler);
		StringTaskHelper taskHelper = new StringTaskHelper();
		taskHelper.setOperations();
		taskHelper.printOperations();
		taskHelper.printLine();
		boolean flag = true;

		while(flag){

			Scanner sc = new Scanner(System.in);
			StringTask task = new StringTask();


				logger.info("\nEnter your choice : ");

				String choiceString = sc.nextLine();
				while(!taskHelper.isValidNumber(choiceString)){
					logger.warning("Enter valid choice!");
					choiceString = sc.nextLine();
				}
				int choice = Integer.parseInt(choiceString);

				switch(choice){

				case 1:{
					taskHelper.printTask(1);
					if(args.length != 0){
						logger.info("Input String : " + args[0]);
						try{
							int length = task.findLength(args[0]);
							logger.info("output : " + length);
						}
						catch(CustomException ex){
							logger.info(ex.getMessage());
						}

					}
					else{
						logger.warning("No String found from main method arguments");
					}
					taskHelper.printLine();

					break;
				}

				case 2:{
					taskHelper.printTask(2);
					taskHelper.printEnterString();
					String string = sc.nextLine();
					try{
						logger.info("output : " + Arrays.toString(task.stringToCharArray(string)));						
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 3:{

						taskHelper.printTask(3);
						taskHelper.printEnterString();
						try{
							String string = sc.nextLine();
							logger.info("Enter index position : ");
							String indexString = sc.nextLine();
							while(!taskHelper.isValidNumber(indexString)){
								logger.info("Provide valid number!");
								indexString = sc.nextLine();
							}
							int index = Integer.parseInt(indexString);
							char character = task.charAtSpecifiedIndex(string, index);
							logger.info("output : " + character);
						}
						catch(CustomException ex){
							logger.warning(ex.getMessage());
						}
						taskHelper.printLine();
					break;
				}

				case 4:{
					try{
						taskHelper.printTask(4);
						taskHelper.printEnterString();
						String string = sc.nextLine();
						taskHelper.printEnterCharacter();
						String characterString = sc.nextLine();
						while(characterString.length() != 1){
							logger.info("Enter a valid character!");
							characterString = sc.nextLine();
						}
						char character = characterString.charAt(0);
						int occurrences = task.findOccurrenceOfCharacter(string, character);
						logger.info("output : " + occurrences);	
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 5:{
					try{
						taskHelper.printTask(5);
						taskHelper.printEnterString();
						String string = sc.nextLine();
						taskHelper.printEnterCharacter();
						String characterString = sc.nextLine();
						while(characterString.length() != 1){
							logger.info("Enter a valid character!");
							characterString = sc.nextLine();
						}
						char character = characterString.charAt(0);
						int index = task.greatestPositionOfCharacter(string, character);
						logger.info((index == -1) ? ("output : There is no given character in the given string") : ("output : " + index));
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 6:{

						taskHelper.printTask(6);
						taskHelper.printEnterString();
						String string = sc.nextLine();
						try{
							int noOfCharacters = 0;
							while(true){
								logger.info("Enter no of Characters : ");
								String noOfCharactersString = sc.nextLine();
								
								while(!taskHelper.isValidNumber(noOfCharactersString)){
									noOfCharactersString = sc.nextLine();
								}
								noOfCharacters = Integer.parseInt(noOfCharactersString);
								if(task.findLength(string) < noOfCharacters){
									logger.info("Enter number from 0 to "+ task.findLength(string));
								}
								else{
									break;
								}
							}
							String lastNCharacters = task.printNCharacters(string, noOfCharacters, true);
							logger.info("output : " + Arrays.toString(task.stringToCharArray(lastNCharacters)));
						}
						catch(CustomException ex){
							logger.warning(ex.getMessage());
						}
						taskHelper.printLine();

					break;
				}

				case 7:{
						taskHelper.printTask(7);
						taskHelper.printEnterString();
						String string = sc.nextLine();
						try{
							int noOfCharacters = 0;
							while(true){
								logger.info("Enter no of Characters : ");
								String noOfCharactersString = sc.nextLine();
								
								while(!taskHelper.isValidNumber(noOfCharactersString)){
									noOfCharactersString = sc.nextLine();
								}
								noOfCharacters = Integer.parseInt(noOfCharactersString);
								if(task.findLength(string) < noOfCharacters){
									logger.info("Enter number from 0 to "+ task.findLength(string));
								}
								else{
									break;
								}
							}
							String firstNCharacters = task.printNCharacters(string, noOfCharacters, false);
							logger.info("output : " + Arrays.toString(task.stringToCharArray(firstNCharacters)));
						}
						catch(CustomException ex){
							logger.warning(ex.getMessage());
						}
						taskHelper.printLine();
					
					break;
				}

				case 8:{
					taskHelper.printTask(8);
					taskHelper.printEnterString();
					String string = sc.nextLine();
					logger.info("Enter replacing string : ");
					String replacingString = sc.nextLine();
					try{
						int noOfCharacters = 0;
						while(true){
							logger.info("Enter no of Characters : ");
							String noOfCharactersString = sc.nextLine();
								
							while(!taskHelper.isValidNumber(noOfCharactersString)){
								noOfCharactersString = sc.nextLine();
							}
							noOfCharacters = Integer.parseInt(noOfCharactersString);
							if(task.findLength(string) < noOfCharacters){
								logger.info("Enter number from 0 to "+ task.findLength(string));
							}
							else{
								break;
							}
						}
						String replacedString = task.replaceCharacters(string, replacingString, noOfCharacters);
						logger.info("output : " + replacedString);	
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 9:{
					taskHelper.printTask(9);
					taskHelper.printEnterString();
					String string = sc.nextLine();
					logger.info("Enter prefix to check : ");
					String prefix = sc.nextLine();
					try{
						boolean isStarts = task.hasPrefix(string, prefix);
						logger.info("output : " + isStarts);
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 10:{
					taskHelper.printTask(10);
					taskHelper.printEnterString();
					try{
						String string = sc.nextLine();
						logger.info("Enter suffix to check : ");
						String suffix = sc.nextLine();
						boolean isEnds = task.hasSuffix(string, suffix);
						logger.info("output : " + isEnds);
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 11:{
					taskHelper.printTask(11);
					taskHelper.printEnterString();
					try{
						String string = sc.nextLine();
						String upperCaseString = task.convertToUpperCase(string);
						logger.info("output : " + upperCaseString);	
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 12:{
					taskHelper.printTask(12);
					taskHelper.printEnterString();
					try{
						String string = sc.nextLine();
						String lowerCaseString = task.convertToLowerCase(string);
						logger.info("output : " + lowerCaseString);
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 13:{
					taskHelper.printTask(13);
					taskHelper.printEnterString();
					try{
						String string = sc.nextLine();
						String reversedString = task.reverseTheString(string);
						logger.info("output : " + reversedString);	
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 14:{
					taskHelper.printTask(14);
					taskHelper.printEnterString();
					try{
						String strings = sc.nextLine();
						String stringArray[] = task.splitString(strings, " ");
						logger.info(Arrays.toString(stringArray));
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 15:{
					taskHelper.printTask(15);
					taskHelper.printEnterString();
					try{
						String string = sc.nextLine();
						String concatenatedString = task.concatStringsToSingleString(string, " ","");
						logger.info("output : " + concatenatedString);
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 16:{
					taskHelper.printTask(16);
					taskHelper.printEnterString();
					try{
						String string = sc.nextLine();
						String[] resultArray = task.splitString(string, " ");
						logger.info("output : " + Arrays.toString(resultArray));
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 17:{
					taskHelper.printTask(17);
					logger.info("Enter Strings : ");
					List<String> stringList = new ArrayList<>();
					while(sc.hasNextLine()){
						String currentString = sc.nextLine();
						if(currentString.equals("")){
							break;
						}
						stringList.add(currentString);
					}
					try{
						String concatenatedString = task.concatStringsWithGivenCharacter(stringList, "-");
						logger.info("output : " + concatenatedString);
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 18:{
					taskHelper.printTask(18);
					try{
						logger.info("Enter your first String : ");
						String string1 = sc.nextLine();
						logger.info("Enter your second String : ");
						String string2 = sc.nextLine();
						boolean isEqual = task.isEqualCaseSensitive(string1, string2);
						logger.info("output : " + isEqual);
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 19:{
					taskHelper.printTask(19);
					try{
						logger.info("Enter your first String : ");
						String string1 = sc.nextLine();
						logger.info("Enter your second String : ");
						String string2 = sc.nextLine();
						boolean isEqual = task.isEqualCaseInSensitive(string1, string2);
						logger.info("output : " + isEqual);
					}
					catch(CustomException ex){
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				case 20:{
					taskHelper.printTask(20);
					try{
						logger.info("Enter String with leading and trailing spaces : ");
						String string = sc.nextLine();
						String resultString = task.stripString(string);
						logger.info("output : " + resultString);
					}
					catch (CustomException ex) {
						logger.warning(ex.getMessage());
					}
					taskHelper.printLine();
					break;
				}

				default:
					{
						flag = false;
					}
				}

			if(flag == false){
				logger.info("\nTask completed!!!");
			}
			sc.close();
		}
	}
}