package tasks;

import java.util.List;

import exception.CustomException;
import validators.Validators;

public class StringTask{

	//1
	public int findLength(String string) throws CustomException{
		Validators.validateInput(string);
		return string.length();
	}

	//2
	public char[] stringToCharArray(String string) throws CustomException{
		Validators.validateInput(string);
		return string.toCharArray();
	}

	//3
	public char charAtSpecifiedIndex(String string, int index)throws CustomException{
		Validators.validateInput(string);
		Validators.boundaryCheck(string, index);
		return string.charAt(index);
	}

	//4
	public int findOccurrenceOfCharacter(String string, char character)throws CustomException{
		Validators.validateInput(string);
		int occurrences = 0;
		for(char ch : stringToCharArray(string)){
			if(ch == character){
				occurrences++;
			}
		}
		return occurrences;
	}

	//5
	public int greatestPositionOfCharacter(String string, char character) throws CustomException{
		Validators.validateInput(string);
		return string.lastIndexOf(character);
	}

	//6,7
	public String printNCharacters(String string, int noOfCharacters,boolean fromLast) throws CustomException{
		int length = findLength(string);
		Validators.boundaryCheck(string, noOfCharacters);
		if(fromLast){
			return string.substring(length - noOfCharacters);
		}
		return string.substring(0, noOfCharacters);
	}

	//8
	public String replaceCharacters(String string, String replacingString, int noOfCharacters) throws CustomException{
		Validators.validateInput(string);
		Validators.validateInput(replacingString);
		Validators.boundaryCheck(string, noOfCharacters);
		return replacingString + string.substring(noOfCharacters);
	}

	//9
	public boolean hasPrefix(String string, String prefix)throws CustomException{
		Validators.validateInput(string);
		Validators.validateInput(prefix);
		return string.startsWith(prefix);
	}

	//10
	public boolean hasSuffix(String string, String suffix) throws CustomException{
		Validators.validateInput(string);
		Validators.validateInput(suffix);
		return string.endsWith(suffix);
	}

	//11
	public String convertToUpperCase(String string) throws CustomException{
		Validators.validateInput(string);
		return string.toUpperCase();
	}

	//12
	public String convertToLowerCase(String string) throws CustomException{
		Validators.validateInput(string);
		return string.toLowerCase();
	}

	//13
	public String reverseTheString(String string) throws CustomException{
		Validators.validateInput(string);
		char characterArray[] = string.toCharArray();
		int left = 0, right = characterArray.length - 1;
		while(left < right){
			char currCharacter = characterArray[left];
			characterArray[left] = characterArray[right];
			characterArray[right] = currCharacter;
			left++;
			right--;
		}
		return String.copyValueOf(characterArray);
	}

	//14
	public String[] splitString(String string, String delimiter) throws CustomException{
		Validators.validateInput(string);
		Validators.isNullInput(delimiter);
		return string.split(delimiter);
	}

	//15
	public String concatStringsToSingleString(String string, String from, String to) throws CustomException{
		Validators.validateInput(string);
		Validators.isNullInput(from);
		Validators.isNullInput(to);
		return string.replace(from,to);
	}

	//17
	public String concatStringsWithGivenCharacter(List<String> stringList, String character) throws CustomException{
		Validators.validateInput(stringList);
		Validators.isNullInput(character);
		return String.join(character, stringList);

	}

	//18
	public boolean isEqualCaseSensitive(String string1, String string2) throws CustomException{
		Validators.validateInput(string1);
		Validators.validateInput(string2);
		return string1.equals(string2);
	}

	//19
	public boolean isEqualCaseInSensitive(String string1, String string2) throws CustomException{
		Validators.validateInput(string1);
		Validators.validateInput(string2);
		return string1.equalsIgnoreCase(string2);
	}

	//20
	public String stripString(String string)  throws CustomException{
		Validators.validateInput(string);
		return string.strip();
	}

}