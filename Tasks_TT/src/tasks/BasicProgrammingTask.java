package tasks;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import exception.CustomException;
import helper.MyFileHandler;
import helper.PropertiesHandler;
import pojos.MySQLUserConfig;
import validators.Validators;

public class BasicProgrammingTask {

	private PropertiesHandler propHandler = new PropertiesHandler();
	private MyFileHandler myFileHandler = new MyFileHandler();
	private HashMapTask mapTask = new HashMapTask();
	private MyDateTime myDateTime = new MyDateTime();

	public void createFileAndAddContent(String path, String fileName, List<String> contents)
			throws CustomException {
		Validators.validateInput(path);
		Validators.validateInput(fileName);
		Validators.isNullInput(contents);
		File file = myFileHandler.getFile(path + File.separator + fileName);
		myFileHandler.writeInFile(file, contents, true);
	}

	public void storeInPropertiesAndFile(String path, String fileName, Map<String, String> map, String details)
			throws CustomException {
		Validators.validateInput(path);
		Validators.validateInput(fileName);
		Validators.validateInput(details);
		Validators.isNullInput(map);
		Properties properties = propHandler.getProperties();

		Iterator<Map.Entry<String, String>> iterator = mapTask.getIterator(map);
		while (iterator.hasNext()) {
			Map.Entry<String, String> element = iterator.next();
			propHandler.setInputInProperty(properties, element.getKey(), element.getValue());
		}

		File file = myFileHandler.getFile(path + File.separator + fileName);

		propHandler.storePropertiesInFile(file, properties, details);
	}

	public void loadDataIntoProperties(String path, String fileName) throws CustomException {
		Validators.validateInput(path);
		Validators.validateInput(fileName);
		Properties props = propHandler.getProperties();

		File file = myFileHandler.getFile(path + File.separator + fileName);

		propHandler.loadPropertiesIntoFile(file, props);

		propHandler.printProperties(props);

	}

	public File makeDirAndRepeat(String path, String name) throws CustomException {
		Validators.validateInput(path);
		Validators.validateInput(name);
		return myFileHandler.makeDirectory(path, name);
	}

	public String getFilePath(File file) throws CustomException {
		Validators.isNullInput(file);
		return myFileHandler.getPath(file);
	}

	public String createDummyStudentUsingReflection(String className) throws CustomException {
		try {
			Validators.validateInput(className);
			Class<?> myStudentClass = Class.forName(className);
			Object dummyStudent = myStudentClass.getDeclaredConstructor().newInstance();
			return "" + dummyStudent;
		} catch (Exception ex) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, ex);
		}
	}

	public String createOriginalStudentUsingReflection(String name, int number, String className, String newName)
			throws CustomException {
		try {
			Validators.validateInput(name);
			Validators.validateInput(className);
			Validators.validateInput(newName);
			Class<?> myStudentClass = Class.forName(className);
			Object originalStudent = myStudentClass.getDeclaredConstructor(String.class, int.class).newInstance(name,
					number);

			String initialState = "Initial State : " + originalStudent;

			Method setName = myStudentClass.getMethod("setName", String.class);

			setName.invoke(originalStudent, newName);

			String finalState = "Final State : " + originalStudent;

			return initialState + ", " + finalState;
		} catch (Exception ex) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, ex);
		}
	}

	public MySQLUserConfig getMySQLUserConfig() throws CustomException {
		return MySQLUserConfig.getInstance();
	}

	public String getCurrentDate() {
		return myDateTime.getCurrentDateTime();
	}

	public Set<String> allZoneIds() {
		return myDateTime.getAllZoneIDs();
	}

	public String getTimeAtZone(String zone) throws CustomException {
		Validators.validateInput(zone);
		Set<String> allZoneIds = allZoneIds();
		for (String zoneId : allZoneIds) {
			if (zoneId.contains(zone)) {
				return myDateTime.getTimeAtZone(zoneId);
			}
		}
		return "";
	}

	public long getCurrentTimeInMillis() {
		return System.currentTimeMillis();
	}

	public ZonedDateTime getLocalDateTime(Instant instant, ZoneId zoneId) throws CustomException {
		return myDateTime.getTimeFromZoneId(instant, zoneId);
	}

	public String getMonthNameFromMillis(long timeInMillis) throws CustomException {
		return myDateTime.getSystemDefaultDateTime(myDateTime.getInstant(timeInMillis)).getMonth().toString();
	}

	public String getDayFromMillis(long timeInMillis) throws CustomException {
		return myDateTime.getSystemDefaultDateTime(myDateTime.getInstant(timeInMillis)).getDayOfWeek().toString();
	}

	public int getYearFromMillis(long timeInMillis) throws CustomException {
		return myDateTime.getSystemDefaultDateTime(myDateTime.getInstant(timeInMillis)).getYear();
	}

	public Color[] getAllColors() {
		return Color.values();
	}
	
	public enum Color {
		Violet(1), Indigo(2), Blue(3), Green(4), Yellow(5), Orange(6), Red(7);

		private int colorNumber;

		private Color(int colorNumber) {
			this.colorNumber = colorNumber;
		}

		public int getValue() {
			return this.colorNumber;
		}
	}

}
