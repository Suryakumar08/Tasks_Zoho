package helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import exception.CustomException;
import validators.Validators;

public class PropertiesHandler {

	public Properties getProperties() {
		return new Properties();
	}

	public void setInputInProperty(Properties properties, String key, String value) throws CustomException {
		Validators.isNullInput(key);
		Validators.isNullInput(value);
		properties.setProperty(key, value);
	}

	public void storePropertiesInFile(File file, Properties properties, String command) throws CustomException {
		Validators.isNullInput(properties);
		Validators.isNullInput(file);
		try (Writer writer = new BufferedWriter(new FileWriter(file))) {
			properties.store(writer, command);
		} catch (IOException ex) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, ex);
		}
	}

	public void loadPropertiesIntoFile(File file, Properties properties) throws CustomException {
		Validators.isNullInput(properties);
		Validators.isNullInput(file);
		try (Reader reader = new BufferedReader(new FileReader(file))) {
			properties.load(reader);
		} catch (IOException ex) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, ex);
		}
	}

	public void printProperties(Properties props) throws CustomException {
		Validators.isNullInput(props);
		props.list(System.out);
	}

}
