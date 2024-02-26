package customClasses;

import exception.CustomException;
import validators.Validators;

public class CustomClass1 {
	private String name;

	public CustomClass1(String name) throws CustomException {
		Validators.validateInput(name);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomClass1 [name=" + name + "]";
	}
	
	
}
