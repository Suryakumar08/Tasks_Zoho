package helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import exception.CustomException;
import validators.Validators;

public class MyFileHandler {

	public File getFile(String path) throws CustomException {
		Validators.validateInput(path);
		try {
			File file = new File(path);
			file.createNewFile();
			return file;
		} catch (Exception ex) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, ex);
		}
	}

	public void writeInFile(File file, List<String> contents, boolean append) throws CustomException {
		Validators.isNullInput(file);
		Validators.isNullInput(contents);
		try (Writer bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
			for (String content : contents) {
				Validators.validateInput(content);
				if (!file.exists()) {
					throw new CustomException(CustomException.FILE_NOT_FOUND_MESSAGE);
				}
				bufferedWriter.write(content + "\n");
			}
		} catch (Exception ex) {
			throw new CustomException(CustomException.SOME_ERROR_MESSAGE, ex);
		}

	}

	public File makeDirectory(String path, String dirName) throws CustomException {
		Validators.validateInput(dirName);
		Validators.validateInput(path);
		File dir = new File(path + File.separator + dirName);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir;
	}

	public String getPath(File file) {
		return file.getPath();
	}

}
