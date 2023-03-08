package telran.io.test;

import org.junit.jupiter.api.Test;
import java.io.*;

public class LineOrientedStreams {
	
	static final String fileNamePrintStream = "lines-stream.txt";
	static final String fileNamePrintWriter = "lines-writer.txt";
	static final String line = "Hello World";
	
	@Test
	void printStreamTest() throws Exception {
		PrintStream printStream = new PrintStream(fileNamePrintStream);
		printStream.println(line);
	}
	
	@Test
	void printWriterTest() throws Exception {
		try (PrintWriter printWriter = new PrintWriter(fileNamePrintWriter)) {
			printWriter.println(line);			
		}
	}

}
