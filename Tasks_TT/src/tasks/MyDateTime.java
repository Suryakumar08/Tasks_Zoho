package tasks;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import exception.CustomException;
import validators.Validators;

public class MyDateTime {
	public String getCurrentDateTime() {
		ZonedDateTime currentDateTime = ZonedDateTime.now();
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		return currentDateTime.format(formater);
	}
	
	public Set<String> getAllZoneIDs() {
		return ZoneId.getAvailableZoneIds();
	}
	
	public ZonedDateTime getSystemDefaultDateTime(Instant instant) throws CustomException{
		Validators.isNullInput(instant);
		return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
	}
	
	public Instant getInstant(long timeInMillis) {
		return Instant.ofEpochMilli(timeInMillis);
	}

	public ZonedDateTime getTimeFromZoneId(Instant instant, ZoneId zoneId) throws CustomException{
		Validators.isNullInput(zoneId);
		Validators.isNullInput(instant);
		return ZonedDateTime.ofInstant(instant, zoneId);
	}
	
	public String getTimeAtZone(String zoneId) {
		ZoneId currZoneId = ZoneId.of(zoneId);
		ZonedDateTime currDateTimeAtZone = ZonedDateTime.now(currZoneId);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh-mm-ss");
		return currDateTimeAtZone.format(formatter);
	}
	
}

