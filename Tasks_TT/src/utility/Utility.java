package utility;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import customClasses.CustomClass1;
import exception.CustomException;
import tasks.ArrayListTask;
import validators.Validators;

public class Utility {

	private static Scanner sc = new Scanner(System.in);

	public static int getIntInput() throws CustomException {

		try {
			int input = sc.nextInt();
			sc.nextLine();
			return input;
		} catch (InputMismatchException ex) {
			sc.nextLine();
			throw new CustomException(CustomException.INPUT_MISMATCH_MESSAGE);
		}

	}

	public static List<String> createListAndGetStrings() throws CustomException {
		ArrayListTask arrayListTask = new ArrayListTask();
		List<String> stringList = arrayListTask.getArrayList();
		while (sc.hasNextLine()) {
			String currString = sc.nextLine();
			if (currString.equals("")) {
				break;
			}
			arrayListTask.addInputIntoArrList(currString, stringList);
		}
		return stringList;
	}

	public static CustomClass1 getCustomClassObject() throws CustomException {
		System.out.println("Enter object name : ");
		String name = sc.nextLine();
		Validators.validateInput(name);
		return new CustomClass1(name);
	}

}
