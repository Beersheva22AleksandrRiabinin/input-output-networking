package telran.util;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class LoggerTest {

	static final String fileName = "file.txt";

	@Test
	void consoleTest() {
		SimpleStreamHandler handler = new SimpleStreamHandler(new PrintStream(System.out));
		Logger logger = new Logger(handler, "logger");
//		logger.setLevel(Level.ERROR);
		logger.trace("trace message");
		logger.debug("debug message");
		logger.info("info message");
		logger.warn("warn message");
		logger.error("error message");

	}

	@Test
	void fileTest() throws FileNotFoundException {
		SimpleStreamHandler handler = new SimpleStreamHandler(new PrintStream(fileName));
		Logger logger = new Logger(handler, "logger");
		logger.setLevel(Level.DEBUG);
		logger.trace("trace message");
		logger.debug("debug message");
		logger.info("info message");
		logger.warn("warn message");
		logger.error("error message");
	}

}
