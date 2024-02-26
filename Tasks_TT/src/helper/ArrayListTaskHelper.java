package helper;

import java.util.HashMap;
import java.util.Map.Entry;

public class ArrayListTaskHelper {
	private HashMap<Integer, String> tasks;
	public ArrayListTaskHelper(){
		tasks = new HashMap<>();
		setOperations();
	}
	
	private void setOperations() {
		tasks.put(1, "create an ArrayList & print the size of it");
		tasks.put(2, "create an ArrayList & add 5 Strings from the command line to it.\n"
				+ "Print the ArrayList & the size of it");
		tasks.put(3, "create an ArrayList & add 5 integers from the command line to it.\n"
				+ "Print the ArrayList & the size of it");
		tasks.put(4, "create an ArrayList & add your custom objects to it. Print the\n"
				+ "ArrayList & the size of it");
		tasks.put(5, "create an ArrayList & add 2 integers, add 3 Strings from\n"
				+ "command line & 2 custom objects.Print the ArrayList & the size of it");
		tasks.put(6, "create an ArrayList & add 4 Strings from the command line to it.\n"
				+ "Then find the index of any one of the already added String. Print the ArrayList & the\n"
				+ "size of it as well.");
		tasks.put(7, "create an ArrayList & add 5 Strings from the command line to it.\n"
				+ "Use the iterator method & for loop to print each element in the ArrayList");
		tasks.put(8, "create an ArrayList & add Strings from the command line to it.\n"
				+ "Print the String at a given index in the ArrayList & the size of it");
		tasks.put(9, "create an ArrayList & add 5 Strings(with duplicates) from the\n"
				+ "command line to it. Find the first & last position(index) of a duplicate string.");
		tasks.put(10, "create an ArrayList & add 5 Strings from the command line to it.\n"
				+ "After that add a given String at the 2nd position of the ArrayList. Print the ArrayList &\n"
				+ "the size of it as well.");
		tasks.put(11, "create an ArrayList(first ArrayList) & add 10 Strings from the\n"
				+ "command line to it. Using that ArrayList create a new ArrayList(second ArrayList)\n"
				+ "with elements from 3 to 8 position of the first ArrayList");
		tasks.put(12, "create an ArrayList(first ArrayList) & add 3 Strings from the\n"
				+ "command line to it. Create another ArrayList(second ArrayList) with 5 more Strings\n"
				+ "from the Command line. Now create another ArrayList (third ArrayLIst) using the\n"
				+ "above two ArrayLists. Print the third ArrayList & size of it. Note: You should not use a\n"
				+ "loop to create a 3rd ArrayList.");
		tasks.put(13, "create an ArrayList(first ArrayList) & add 5 Strings from the\n"
				+ "command line to it. Create another ArrayList(second ArrayList) with 3 more Strings\n"
				+ "from the Command line. Now create another ArrayList (third ArrayLIst) using theabove two ArrayLists. But all the elements of secondArrayList should be ahead of the\n"
				+ "first ArrayList elements. Print the third ArrayList & size of it. Note: You should not use\n"
				+ "a loop to create a 3rd ArrayList.");
		tasks.put(14, "create an ArrayList & add 5 decimal values from the command\n"
				+ "line to it. Remove a decimal value at position 4 from the ArrayList.Print the ArrayList\n"
				+ "& the size of it as well.");
		tasks.put(15, "create an ArrayList(first ArrayList) & add 5 Strings from the\n"
				+ "command line to it. Create another ArrayList(second ArrayList) with the same 3\n"
				+ "Strings in the previous 5 Strings. Now remove the elements from the first ArrayList\n"
				+ "which are present in the secondArrayList. Note: You should not use a loop to remove\n"
				+ "the elements. Print the ArrayList & the size of it as well.");
		tasks.put(16, "create an ArrayList(first ArrayList) & add 5 Strings from the\n"
				+ "command line to it. Create another ArrayList(second ArrayList) with the same 3\n"
				+ "Strings in the previous 5 Strings. Now remove the elements from the first ArrayList\n"
				+ "which are not present in the secondArrayList. Note: You should not use a loop to\n"
				+ "remove the elements. Print the ArrayList & the size of it as well.");
		tasks.put(17, "create an ArrayList & add 10 long values from the command line\n"
				+ "to it. Remove all the long values from the ArrayLIst.Print the ArrayList & the size of it\n"
				+ "as well.");
		tasks.put(18,  "create an ArrayList & add 5 String values from the command line\n"
				+ "to it. Check whether a given String is present in the ArrayList.Print the ArrayList & the\n"
				+ "size of it as well.");
	}
	
	public void printOperations() {
		for(Entry<Integer, String> element : tasks.entrySet()) {
			System.out.println(element.getKey() + " : " + element.getValue());
		}
		System.out.println();
	}
	
	
	public void printTask(int taskNo) {
		System.out.println(taskNo + " : " + tasks.get(taskNo));
	}
	
	
	
}
