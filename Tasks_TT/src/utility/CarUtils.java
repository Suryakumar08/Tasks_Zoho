package utility;

import exception.CustomException;

public class CarUtils{
	public static void checkNumber(int number, int maxLimit, int minLimit) throws CustomException{
		if(number > maxLimit || number < minLimit){
			throw new CustomException(CustomException.NUMBER_INVALID_MESSAGE);
		}
	}
}