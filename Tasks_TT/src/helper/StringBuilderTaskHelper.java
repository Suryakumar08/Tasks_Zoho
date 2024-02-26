package helper;

import java.util.HashMap;
import java.util.Map;



public class StringBuilderTaskHelper{

	private Map<Integer, String> tasks;
	
	public StringBuilderTaskHelper(){
		tasks = new HashMap<>();
		setOperations();
	}
	
	private void setOperations(){
		tasks.put(1, "Create a StringBuilder with no String & print the length of it. Then add a String to it & print the length & the final String");
		tasks.put(2, "Create a StringBuilder with a String & print the length of it. Then add 4 Strings to it & each String separated by a “#” & print the length & the final String");
		tasks.put(3, "Create a StringBuilder with two Strings with a space in between & print the length of it. Then insert another String in between those two Strings & print the length & the final String. Space should be there between Strings");
		tasks.put(4, "Create a StringBuilder with two Strings with a space in between & print the length of it. Then delete the first String & print the length & the final String");
		tasks.put(5, "Create a StringBuilder with 3 Strings with a space in between & print the length of it. Then replace the space with “-” & print the length & the final String");
		tasks.put(6, "Create a StringBuilder with 3 Strings with a space in between & print the length of it. Then reverse the string & print the length & the final String");
		tasks.put(7, "Create a StringBuilder with a String(minimum 10 chars) & print the length of it. Then delete the characters from 6 to 8 index & print the length & the final String");
		tasks.put(8, "Create a StringBuilder with a String(minimum 10 chars) & print the length of it. Then replace the characters from 6 to 8 index with “XYZ” & print the length & the final String");
		tasks.put(9, "Create a StringBuilder with 3 Strings with a “#” in between & print the length of it. Then find the index of the first “#” in the StringBuilder");
		tasks.put(10, "Create a StringBuilder with 3 Strings with a “#” in between & print the length of it. Then find the index of the last “#” in the StringBuilder");
		tasks.put(0, "Exit");

		printOperations();

	}

	private void printOperations(){
		for(Map.Entry<Integer, String> element : tasks.entrySet()){
			System.out.println(element.getKey() + " : " + element.getValue());
		}
	}

	public void printTask(int taskNo){
		System.out.println(taskNo + " : " + tasks.get(taskNo));
	}

	public void printLine(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	}

}