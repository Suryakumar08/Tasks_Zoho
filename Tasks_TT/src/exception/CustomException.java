package exception;

public class CustomException extends Exception{

	private static final long serialVersionUID = 1L;
	public static final String SOME_ERROR_MESSAGE = "Some error occurred";
	public static final String FILE_NOT_FOUND_MESSAGE = "File not found";
	public static final String NUMBER_INVALID_MESSAGE = "Invalid number";
	public static final String NULL_MESSAGE = "Given Input is NULL";
	public static final String EMPTY_MESSAGE = "Given Input is Empty";
	public static final String INDEX_OUT_OF_BOUNDS_MESSAGE = "Given index out of bounds";
	public static final String INPUT_MISMATCH_MESSAGE = "Mismatched Input";
	public static final String LENGTH_NOT_ENOUGH_MESSAGE = "Input length not enough";

	public CustomException(String errorMessage){
		super(errorMessage);
	}
	public CustomException(String message, Throwable cause){
		super(message, cause);
	}
}