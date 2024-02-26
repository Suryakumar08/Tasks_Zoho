package tasks;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.CustomException;
import validators.Validators;

public class RegExTask {
	public boolean isValidMobileNumber(String number) throws CustomException {
		Validators.validateInput(number);
		return Pattern.matches("^[7-9]\\d{9}$", number);
	}

	public boolean hasAlphaNumericOnly(String input) throws CustomException {
		Validators.validateInput(input);
		return Pattern.matches("\\A[0-9a-zA-Z]+\\z", input);
	}
	
	public boolean passwordChecker(String password) throws CustomException{
		Validators.validateInput(password);
		return Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", password);
	}

	public boolean startsWithString(String input, String matchingString) throws CustomException {
		Validators.validateInput(input);
		Validators.validateInput(matchingString);
		return Pattern.matches(("\\A\\Q" + matchingString + "\\E.*\\z"), input);
//		return Pattern.matches(Pattern.quote(matchingString) + ".*", input);
//		return Pattern.matches(("\\Q" + matchingString + "\\E.*"), input);
	}

	public boolean stringContainsString(String input, String matchingString) throws CustomException {
		Validators.validateInput(input);
		Validators.validateInput(matchingString);
		return Pattern.matches(("\\A.*" + Pattern.quote(matchingString) + ".*\\z"), input);
	}

	public boolean stringEndsWithString(String input, String matchingString) throws CustomException {
		Validators.validateInput(input);
		Validators.validateInput(matchingString);
		return Pattern.matches((".*\\Q" + matchingString + "\\E"), input);
	}

	public boolean isStringsExactMatch(String input, String matchingString, boolean caseSensitive)
			throws CustomException {
		Validators.validateInput(input);
		Validators.validateInput(matchingString);
		if (caseSensitive) {
			return Pattern.matches(Pattern.quote(matchingString), input);
		} else {
			return Pattern.matches("(?i)" + Pattern.quote(matchingString), input);
		}
	}

	public boolean isListContainsMatch(List<String> stringList, String matchingString, boolean b)
			throws CustomException {
		Validators.validateInput(matchingString);
		Validators.isNullInput(matchingString);
		for (String currString : stringList) {
			if (this.isStringsExactMatch(currString, matchingString, false)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateEmail(String email) throws CustomException {
		Validators.validateInput(email);
		return Pattern.matches(".+\\@.+\\..+", email);
	}

	public boolean checkListOfStringsWithSpecifiedLength(List<String> stringList, int minLength, int maxLength)
			throws CustomException {
		Validators.isNullInput(stringList);
		for (String string : stringList) {
			if (!Pattern.matches(("(?s).{" + minLength + "," + maxLength + "}"), string)) {
				return false;
			}
		}
		return true;
	}

	public Map<String, Integer> getPositionOfString(List<String> list1, List<String> list2)
			throws CustomException {
		Validators.isNullInput(list1);
		Validators.isNullInput(list2);
		HashMapTask mapObject = new HashMapTask();
		ArrayListTask listObject = new ArrayListTask();
		Map<String, Integer> stringToIndMap = mapObject.getHashMap();
		for (String string : list2) {
			mapObject.putInputInMap(stringToIndMap, string, listObject.findFirstIndex(list1, string));
		}
		return stringToIndMap;
	}

	public List<String> getStringWithinCharacters(String htmlCode, String string1, String string2)
			throws CustomException {
		Validators.validateInput(htmlCode);
		Validators.validateInput(string1);
		Validators.validateInput(string2);
		ArrayListTask listObject = new ArrayListTask();
		List<String> stringList = listObject.getArrayList();
		Pattern pattern = Pattern.compile((Pattern.quote(string2) + "[^" + Pattern.quote(string2) + "]+" + Pattern.quote(string2)));
		Matcher matcher = pattern.matcher(htmlCode);
		while (matcher.find()) {
			String string = matcher.group();
			listObject.addInputIntoArrList(string, stringList);
		}
		return stringList;
	}
}
