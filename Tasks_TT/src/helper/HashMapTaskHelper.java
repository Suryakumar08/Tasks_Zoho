package helper;

import java.util.HashMap;
import java.util.Map;

public class HashMapTaskHelper {
	private static Map<Integer, String> tasks = new HashMap<>();
	public HashMapTaskHelper() {
		setOperations();
		printOperations();
	}
	
	private void setOperations() {
        tasks.put(1, "Create a HashMap. Print the HashMap & its size.\n");

        tasks.put(2, "Create a HashMap & add 3 pairs of keys(String) & values(String)." +
                "Print the HashMap & its size.\n");

        tasks.put(3, "Create a HashMap & add 3 pairs of keys(Integer) & values(Integer)." +
                "Print the HashMap & its size.\n");

        tasks.put(4, "Create a HashMap & add 3 pairs of keys(String) & values(Integer)." +
                "Print the HashMap & its size.\n");

        tasks.put(5, "Create a HashMap & add 3 pairs of keys(String) & value(your own object)." +
                "Print the HashMap & its size.\n");

        tasks.put(6, "Create a HashMap & add 3 keys(String). With a null value to one of the keys." +
                "Print the HashMap & its size.\n");

        tasks.put(7, "Create a HashMap & add a null key & non-null value to it." +
                "Print the HashMap & its size.\n");

        tasks.put(8, "Check if a key exists in a HashMap.\n");

        tasks.put(9, "Check if a value exists in a HashMap.\n");

        tasks.put(10, "Create a HashMap & add 3 pairs of keys(String) & values(String). " +
                "Change the values for all the 3 keys. Print before & after.\n");

        tasks.put(11, "Get the value of an existing key in a HashMap.\n");

        tasks.put(12, "Get the value of a non-existing key in a HashMap.\n");

        tasks.put(13, "Return 'Zoho' as a value for a given non-existing key in a HashMap." +
                "Print before & after.\n");

        tasks.put(14, "Remove an existing key in a HashMap. Print before & after.\n");

        tasks.put(15, "Remove an existing key only if its value matches with the given value." +
                "Print before & after.\n");

        tasks.put(16, "Replace the value of an existing key in a HashMap. Print before & after.\n");

        tasks.put(17, "Replace the value of an existing key only if its value matches with the given value." +
                "Print before & after.\n");

        tasks.put(18, "Transfer all keys & values of a HashMap to another HashMap." +
                "Print both HashMaps before & after.\n");

        tasks.put(19, "Iterate over a HashMap & print all its key & corresponding value.\n");

        tasks.put(20, "Remove all entries in a HashMap. Print before & after.");

	}
	
	private void printOperations() {
		System.out.println("Tasks : ");
		System.out.println(tasks);
	}
	
	public void printOperation(int number) {
		System.out.println(number + " : " + tasks.get(number));
	}
}
