package tasks;

import java.util.List;

import exception.CustomException;
import validators.Validators;

public class StringBuilderTask{

	public StringBuilder getStringBuilder(){
		return new StringBuilder();
	}

	public StringBuilder getStringBuilder(String input) throws CustomException{
		Validators.isNullInput(input);
		return new StringBuilder(input);
	}

	public StringBuilder addStringToStringBuilder(StringBuilder stringBuilder, String input) throws CustomException{
		Validators.isNullInput(stringBuilder);
		Validators.validateInput(input);
		return stringBuilder.append(input);
	}

	public StringBuilder addStringToStringBuilder(StringBuilder stringBuilder, String input, int startIndex) throws CustomException{
		Validators.isNullInput(stringBuilder);
		Validators.validateInput(input);
		Validators.boundaryCheck(stringBuilder, startIndex);
		return stringBuilder.insert(startIndex, input);
	}

	public StringBuilder getStringBuilder(StringBuilder stringBuilder, List<String> list, String delimiter)throws CustomException{
		Validators.validateInput(list);
		int listSize = list.size();
		int index = 0;
		if(getLength(stringBuilder) == 0 && listSize > 0){
			addStringToStringBuilder(stringBuilder, list.get(index++));
		}
		for(int i = index; i < listSize; i++){
			addStringToStringBuilder(stringBuilder, delimiter);
			addStringToStringBuilder(stringBuilder, list.get(i));
		}
		return stringBuilder;
	}

	public int getLength(StringBuilder stringBuilder)throws CustomException{
		Validators.isNullInput(stringBuilder);
		return stringBuilder.length();
	}

	public StringBuilder replaceInStringBuilder(StringBuilder stringBuilder, String from, String to, boolean replaceAll)throws CustomException{
		Validators.validateInput(stringBuilder);
		int fromLength = Validators.getLength(from);
		if(!replaceAll){
			int index = stringBuilder.indexOf(from);
			if(index != -1){
				replaceCharacters(stringBuilder, index, index + fromLength, to);
			}
		}
		else{
			int index = stringBuilder.indexOf(from);
			while(index != -1){
				replaceCharacters(stringBuilder, index, index + fromLength, to);
				index = stringBuilder.indexOf(from);
			}
		}
		return stringBuilder;
	}


	public StringBuilder replaceCharacters(StringBuilder stringBuilder, int start, int end, String toReplace)throws CustomException{
		Validators.validateInput(stringBuilder);
		Validators.boundaryCheck(stringBuilder, start);
		Validators.boundaryCheck(stringBuilder, end);
		return stringBuilder.replace(start, end, toReplace);
	}

	public void reverseStringBuilder(StringBuilder stringBuilder)throws CustomException{
		Validators.isNullInput(stringBuilder);
		stringBuilder.reverse();
	}

	public int findFirstOccurrenceIndex(StringBuilder stringBuilder, String string)throws CustomException{
		Validators.validateInput(stringBuilder);
		Validators.isNullInput(string);
		return stringBuilder.indexOf(string);
	}

	public int findLastOccurrenceIndex(StringBuilder stringBuilder, String string)throws CustomException{
		Validators.validateInput(stringBuilder);
		Validators.isNullInput(string);
		return stringBuilder.lastIndexOf(string);
	}

}