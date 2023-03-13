package telran.util;

import java.time.Instant;
import java.time.ZoneId;

public class Logger {

	private Handler handler;
	private String name;
	private Level level;

	public Logger(Handler handler, String name) {
		this.handler = handler;
		this.name = name;
		this.level = Level.INFO;
	}

	public void setLevel(Level level) {

		this.level = level;
	}

	public LoggerRecord loggerRecord(String message) {

		return new LoggerRecord(Instant.now(), ZoneId.systemDefault().toString(), level, name, message);
	}

	public void trace(String message) {
		if (level.compareTo(Level.TRACE) >= 0) {
			handler.publish(loggerRecord(message));
		}
	}

	public void debug(String message) {
		if (level.compareTo(Level.DEBUG) >= 0) {
			handler.publish(loggerRecord(message));
		}
	}

	public void info(String message) {
		if (level.compareTo(Level.INFO) >= 0) {
			handler.publish(loggerRecord(message));
		}
	}

	public void warn(String message) {
		if (level.compareTo(Level.WARN) >= 0) {
			handler.publish(loggerRecord(message));
		}
	}

	public void error(String message) {

		if (level.compareTo(Level.ERROR) >= 0) {
			handler.publish(loggerRecord(message));
		}
	}

}
