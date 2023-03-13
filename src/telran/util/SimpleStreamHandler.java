package telran.util;

import java.io.PrintStream;

public class SimpleStreamHandler implements Handler {

	private PrintStream stream;

	public SimpleStreamHandler(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void publish(LoggerRecord loggerRecord) {
		stream.println(loggerRecord.timestamp);
		stream.println(loggerRecord.zoneId);
		stream.println(loggerRecord.level);
		stream.println(loggerRecord.loggerName);
		stream.println(loggerRecord.message);
		stream.println();
	}

}
