package tasks;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.CustomException;
import validators.Validators;

public class ArrayListTask {
	//Coding to the interface - Java DP
	
	public <T> ArrayList<T> getArrayList(){
		return new ArrayList<T>();
	}
	
	
	public <T> int getArrListSize(List<T> arrList) throws CustomException{
		Validators.isNullInput(arrList);
		return arrList.size();
	}
	
	
	public <T> void addInputIntoArrList(T input, List<T> arrList) throws CustomException{
		arrList.add(input);
	}
	
	public <T> List<Object> appendListToList(List<T> input, List<Object> arrList) throws CustomException{
		Validators.isNullInput(input);
		arrList.addAll(input);
		return arrList;
	}
	
	public <T> int findIndex(T input, List<T> arrList) throws CustomException{
		Validators.isNullInput(input);
		Validators.validateInput(arrList);
		return arrList.indexOf(input);
	}
	
	public <T> Iterator<T> printElementUsingIterator(List<T> arrList) throws CustomException{
		Validators.isNullInput(arrList);
		Iterator<T> iterator = arrList.iterator();
		return iterator;
	}
	
	public <T extends Object> Object getElementAtPosition(int index, List<T> arrList) throws CustomException{
		Validators.isNullInput(arrList);
		Validators.boundaryCheck(arrList, index);
		return arrList.get(index);
	}
	
	public <T extends Object> void addElementAtSpecificPosition(T elementToAdd, int position, List<T> arrList) throws CustomException{
		Validators.isNullInput(elementToAdd);
		Validators.isNullInput(arrList);
		Validators.boundaryCheck(arrList, position);
		arrList.add(position, elementToAdd);
	}
	
	public <T> int findFirstIndex(List<T> arrList, T input) throws CustomException{
		Validators.isNullInput(arrList);
		Validators.isNullInput(input);
		return arrList.indexOf(input);
	}
	
	public <T> int findLastIndex(List<T> arrList, T input) throws CustomException{
		Validators.isNullInput(arrList);
		Validators.isNullInput(input);
		return arrList.lastIndexOf(input);
	}
	
	public <T> List<T> getSubList(List<T> arrList, int from, int to) throws CustomException{
		Validators.isNullInput(arrList);
		Validators.boundaryCheck(arrList, from);
		Validators.boundaryCheck(arrList, to);
		return arrList.subList(from, to);
	}
	
	public <T> List<T> mergeArrayLists(List<T>... arrayLists) throws CustomException{
		List<T> resultList = getArrayList();
		for(List<T> arrList : arrayLists) {
			Validators.isNullInput(arrList);
			resultList.addAll(arrList);
		}
		return resultList;
	}


	public <T> void removeElementAtIndex(List<T> arrList, int index) throws CustomException{
		Validators.isNullInput(arrList);
		Validators.boundaryCheck(arrList, index);
		arrList.remove(index);
	}

	public <T> void deleteAllElements(List<T> arrList) throws CustomException{
		Validators.isNullInput(arrList);
		arrList.clear();
	}

	public <T> void removeElements(List<T> arrList1, List<T> arrList2, boolean removeCommon) throws CustomException{
		Validators.isNullInput(arrList2);
		Validators.isNullInput(arrList1);
		if(removeCommon)arrList1.removeAll(arrList2);
		else arrList1.retainAll(arrList2);
	}


	public <T> boolean checkIfElementPresent(List<T> arrList, T checkInput) throws CustomException{
		Validators.isNullInput(checkInput);
		Validators.isNullInput(arrList);
		return arrList.contains(checkInput);
	}
	

	
}
