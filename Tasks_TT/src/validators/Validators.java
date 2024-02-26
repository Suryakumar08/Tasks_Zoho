package validators;
import java.util.Collection;

import exception.CustomException;

public class Validators{
	
	public static int getLength(CharSequence input) throws CustomException{
		isNullInput(input);
		return input.length();
	}
	
	
	public static void isNullInput(Object input) throws CustomException{
		if(input == null){
			throw new CustomException(CustomException.NULL_MESSAGE);
		}
	}

	public static <T extends Collection<?>> void validateInput(T input) throws CustomException{
		isNullInput(input);
		if(input.size() == 0){
			throw new CustomException(CustomException.EMPTY_MESSAGE);
		}
	}

	public static void validateInput(CharSequence input) throws CustomException{
		isNullInput(input);
		if(input.length() == 0){
			throw new CustomException(CustomException.EMPTY_MESSAGE);
		}
	}
	
	public static void boundaryCheck(Collection<?> input, int index) throws CustomException{
		if(index < 0 || index >= input.size()){
			CustomException newException;
			if(index < 0){
				newException = new CustomException(CustomException.INDEX_OUT_OF_BOUNDS_MESSAGE, new CustomException("Index value must be greater than 0"));
			}
			else{
				newException = new CustomException(CustomException.INDEX_OUT_OF_BOUNDS_MESSAGE);
			}
			throw newException;
		}
	}

	public static void boundaryCheck(CharSequence input, int index) throws CustomException{
		if(index < 0 || index >= input.length()){
			CustomException newException;
			if(index < 0){
				newException = new CustomException(CustomException.INDEX_OUT_OF_BOUNDS_MESSAGE, new CustomException("Index value must be greater than 0"));
			}
			else{
				newException = new CustomException(CustomException.INDEX_OUT_OF_BOUNDS_MESSAGE);
			}
			throw newException;
		}
	}

}