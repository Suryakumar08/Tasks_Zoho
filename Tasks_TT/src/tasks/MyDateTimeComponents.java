package tasks;

public class MyDateTimeComponents {
	private final int year, month, date, hour, minutes, seconds, milliseconds;
	private final String formattedTime;
	public MyDateTimeComponents(int year, int month, int date, int hour, int minutes, int seconds, int milliseconds, String formattedTime) {
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = seconds;
		this.formattedTime = formattedTime;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDate() {
		return date;
	}
	public int getHour() {
		return hour;
	}
	public int getMinutes() {
		return minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public int getMilliseconds() {
		return milliseconds;
	}
	public String getFormattedTime() {
		return formattedTime;
	}
}
