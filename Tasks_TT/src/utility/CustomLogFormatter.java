package utility;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomLogFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		return "---------------------------------------------------------------------------------------------------------\n" + record.getThreadID() + "::" + record.getSourceClassName() + "::" + record.getSourceMethodName() + "::"
				+ new Date(record.getMillis()) + "::\n" + record.getMessage() + "\n";
	}

}
