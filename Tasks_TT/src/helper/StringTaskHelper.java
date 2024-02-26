package helper;
import java.util.HashMap;
import java.util.Map;

public class StringTaskHelper{

	private Map<Integer, String> tasks = null;

	public StringTaskHelper(){
		tasks = new HashMap<>();
		setOperations();
	}

	public void setOperations(){
		tasks.put(1, "Find the length of the string");
		tasks.put(2, "Convert String to Character array");
		tasks.put(3, "Find the Character at the Specified Index");
		tasks.put(4, "Find no.of occurrences of given character");
		tasks.put(5, "Find the greatest position of given character");
		tasks.put(6, "Print last N characters of string");
		tasks.put(7, "Print first N characters of string");
		tasks.put(8, "Replace starting characters with given string");
		tasks.put(9, "Check whether a string starts with given string");
		tasks.put(10, "Check whether a string ends with given string");
		tasks.put(11, "Convert an all lowercase string to an uppercase string");
		tasks.put(12, "Convert an all uppercase string to an lowercase string");
		tasks.put(13, "Reverse a string");
		tasks.put(14, "Accept a line with multiple strings");
		tasks.put(15, "Accept a line with multiple Strings and concatenate to single string");
		tasks.put(16, "Accept a line of strings and put all in array");
		tasks.put(17, "Accept multiple strings and merge each string with hyphen");
		tasks.put(18, "Check two strings are equal (Case sensitive)");
		tasks.put(19, "Check two strings are equal (Case insensitive)");
		tasks.put(20, "Accept a String with a space at the end and beginning or both and output the proper String with no space at the beginning or end");
		tasks.put(0, "Exit");
	}

	public void printOperations(){
		for(Map.Entry<Integer,String> element : tasks.entrySet()){
			System.out.println(element.getKey() + " : " + element.getValue() + "\n");
		}
	}

	public void printTask(int taskNumber){
		System.out.println("Task " + taskNumber + " : " + tasks.get(taskNumber));
	}

	public void printLine(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
	}

	public void printEnterString(){
		System.out.println("Enter your String : ");
	}

	public void printEnterCharacter(){
		System.out.println("Enter the character : ");
	}

	public void printInstruction(){
		System.out.println("Give proper Input");
	}

	public boolean isValidNumber(String number){
		boolean isValid = true;
		for(char ch : number.toCharArray()){
			if(!Character.isDigit(ch)){
				isValid = false;
				break;
			}
		}
		return isValid;
	}

}