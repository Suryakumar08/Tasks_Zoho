package runner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import exception.CustomException;
import helper.StringBuilderTaskHelper;
import tasks.StringBuilderTask;
import utility.CustomLogFormatter;


public class StringBuilderTaskRunner{

	private static StringBuilderTaskHelper helper;
	private static StringBuilderTask task;
	private static final Logger logger = Logger.getLogger(StringBuilderTaskRunner.class.toString());
	
	public static void main(String args[]){
		
		logger.setLevel(Level.ALL);
		logger.setUseParentHandlers(false);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new CustomLogFormatter());
		logger.addHandler(handler);
		
		Scanner sc = new Scanner(System.in);
		helper = new StringBuilderTaskHelper();
		task = new StringBuilderTask();

		boolean flag = true;
		while(flag){
			logger.info("Enter your choice : ");
			int choice = 0;
			try{
				try{
					choice = sc.nextInt();
					sc.nextLine();
				}
				catch(InputMismatchException ex){
					sc.nextLine();
					throw new CustomException(CustomException.INPUT_MISMATCH_MESSAGE, ex);
				}

				switch(choice){
					case 1:
						{
							try{
								helper.printTask(1);
								StringBuilder stringBuilder = task.getStringBuilder();
								int initialLength = task.getLength(stringBuilder);
								logger.info("StringBuilder created... Length = " + initialLength);
								System.out.print("Enter a string to add : ");
								String toAdd = sc.nextLine();
								stringBuilder = task.addStringToStringBuilder(stringBuilder, toAdd);
								int finalLength = task.getLength(stringBuilder);
								logger.info("Final String : " + stringBuilder);
								logger.info("Final Length : " + finalLength);	
							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					case 2:
						{
							try{
								helper.printTask(2);
								logger.info("Enter your string : ");
								StringBuilder stringBuilder = task.getStringBuilder(sc.nextLine());
								int initialLength = task.getLength(stringBuilder);
								logger.info("StringBuilder created with given string... Length = " + initialLength);
								logger.info("Enter 4 strings to add :");
								List<String> list = new ArrayList<>();
								for(int i = 0; i < 4; i++){
									list.add(sc.nextLine());
								}
								stringBuilder = task.getStringBuilder(stringBuilder, list, "#");
								logger.info("Final StringBuilder : " + stringBuilder);
								logger.info("Final length of StringBuilder : " + task.getLength(stringBuilder));

							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					case 3:
						{
							try{
								helper.printTask(3);
								StringBuilder stringBuilder = task.getStringBuilder();
								List<String> list = new ArrayList<>();
								logger.info("Enter 2 strings : ");
								for(int i = 0; i < 2; i++){
									list.add(sc.nextLine());
								}
								stringBuilder = task.getStringBuilder(stringBuilder, list, ",");
								logger.info("Length of original string : " + task.getLength(stringBuilder));
								logger.info("Enter string to add at middle of two strings : ");
								stringBuilder = task.replaceInStringBuilder(stringBuilder, ","," " + sc.nextLine() + " ", false);
								logger.info("Final StringBuilder : " + stringBuilder);
								logger.info("Final length : " + task.getLength(stringBuilder));
							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					case 4:
						{
							try{
								helper.printTask(4);
								StringBuilder stringBuilder = task.getStringBuilder();
								List<String> list = new ArrayList<>();
								logger.info("Enter 2 strings : ");
								for(int i = 0; i < 2; i++){
									list.add(sc.nextLine());
								}
								stringBuilder = task.getStringBuilder(stringBuilder, list, " ");
								logger.info("Length of original string : " + task.getLength(stringBuilder));
								logger.info("Deleting first String... Deletion completed..");
								stringBuilder = task.replaceInStringBuilder(stringBuilder, list.get(0), "", false);
								logger.info("Final StringBuilder : " + stringBuilder);
								logger.info("Final Length : " + task.getLength(stringBuilder));
							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					case 5:
						{
							try{
								helper.printTask(5);
								StringBuilder stringBuilder = task.getStringBuilder();
								List<String> list = new ArrayList<>();
								logger.info("Enter 3 strings : ");
								for(int i = 0; i < 3; i++){
									list.add(sc.nextLine());
								}
								stringBuilder = task.getStringBuilder(stringBuilder, list, " ");
								logger.info("Length of original string : " + task.getLength(stringBuilder));
								logger.info("Replacing all spaces with hyphen...");
								stringBuilder = task.replaceInStringBuilder(stringBuilder, " ", "-", true);
								logger.info("Final StringBuilder : " + stringBuilder);
								logger.info("Final length : " + task.getLength(stringBuilder));
							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					case 6:
						{
							try{
								helper.printTask(6);
								StringBuilder stringBuilder = task.getStringBuilder();
								List<String> list = new ArrayList<>();
								logger.info("Enter 3 strings : ");
								for(int i = 0; i < 3; i++){
									list.add(sc.nextLine());
								}
								stringBuilder = task.getStringBuilder(stringBuilder, list, " ");
								logger.info("Length of original string : " + task.getLength(stringBuilder));
								logger.info("Reversing String...");
								task.reverseStringBuilder(stringBuilder);
								logger.info("Final StringBuilder : " + stringBuilder);
								logger.info("Final length : " + task.getLength(stringBuilder));
							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					case 7:
						{
							try{
								helper.printTask(7);
								logger.info("Enter String (Minimum 10 characters) : ");
								StringBuilder stringBuilder = task.getStringBuilder(sc.nextLine());
								int initialLength = task.getLength(stringBuilder);
								if(initialLength < 10){
									throw new CustomException(CustomException.LENGTH_NOT_ENOUGH_MESSAGE);
								}
								logger.info("Original String Length : " + initialLength);
								logger.info("Deleting characters from 6 to 8");
								stringBuilder = task.replaceCharacters(stringBuilder, 5, 8, "");
								logger.info("Final StringBuilder : " + stringBuilder);
								logger.info("Final length : " + task.getLength(stringBuilder));
							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					case 8:
						{
							try{
								helper.printTask(8);
								logger.info("Enter String (Minimum 10 characters) : ");
								StringBuilder stringBuilder = task.getStringBuilder(sc.nextLine());
								int initialLength = task.getLength(stringBuilder);
								if(initialLength < 10){
									throw new CustomException(CustomException.LENGTH_NOT_ENOUGH_MESSAGE);
								}
								logger.info("Original String Length : " + initialLength);
								logger.info("Deleting characters from 6 to 8");
								stringBuilder = task.replaceCharacters(stringBuilder, 5, 8, "XYZ");
								logger.info("Final StringBuilder : " + stringBuilder);
								logger.info("Final length : " + task.getLength(stringBuilder));
							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					case 9:
						{
							try{
								helper.printTask(9);
								logger.info("Enter 3 strings : ");
								List<String> list = new ArrayList<>();
								for(int i = 0; i < 3; i++){
									list.add(sc.nextLine());
								}
								StringBuilder stringBuilder = task.getStringBuilder();
								stringBuilder = task.getStringBuilder(stringBuilder, list, "#");
								logger.info("Length of original string : " + task.getLength(stringBuilder));
								logger.info("Index of first # : " + task.findFirstOccurrenceIndex(stringBuilder, "#"));
							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					case 10:
						{
							try{
								helper.printTask(10);
								logger.info("Enter 3 strings : ");
								List<String> list = new ArrayList<>();
								for(int i = 0; i < 3; i++){
									list.add(sc.nextLine());
								}
								StringBuilder stringBuilder = task.getStringBuilder();
								stringBuilder = task.getStringBuilder(stringBuilder, list, "#");
								logger.info("Length of original string : " + task.getLength(stringBuilder));
								logger.info("Index of last # : " + task.findLastOccurrenceIndex(stringBuilder, "#"));
							}
							catch(CustomException ex){
								logger.warning(ex.getMessage());
							}
							helper.printLine();
							break;
						}
					default:
					{
						logger.info("Task Completed");
						flag = false;
					}
				}
			}
			catch(CustomException e){
				logger.warning(e.getMessage());
			}
		}
		sc.close();

	}
}