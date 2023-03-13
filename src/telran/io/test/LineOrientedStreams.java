package telran.io.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;
import java.util.stream.IntStream;

public class LineOrientedStreams {
	
	static final String fileNamePrintStream = "lines-stream.txt";
	static final String fileNamePrintWriter = "lines-writer.txt";
	static final String line = "Hello World";
	static final String helloFileName = "test.txt";
	private static final int N_RECORDS = 1_000_000_00;
	
	@Test
	void printStreamTest() throws Exception {
		PrintStream printStream = new PrintStream(fileNamePrintStream);
		printStream.println(line);
		printStream.println(line);
	}
//	
//	@Test
//	void printWriterTest() throws Exception {
//		try (PrintWriter printWriter = new PrintWriter(fileNamePrintWriter)) {
//			printWriter.println(line);
////			printWriter.println(line);
//		}
//	}
	
//	@Test
//	@Disabled
//	void printStreamTest() throws Exception{
//		PrintStream printStream = new PrintStream(fileNamePrintStream);
//		IntStream.range(0, N_RECORDS).forEach(printStream::println);	
//	}
	
	@Test
	@Disabled
	void printWriterTest() throws Exception{
		try(PrintWriter printWriter = new PrintWriter(fileNamePrintWriter)){
			IntStream.range(0, N_RECORDS).forEach(printWriter::println);
		}		
	}
	
	@Test
	void bufferedReaderTest() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(helloFileName));
//		while(true) {
//			String nextLine = reader.readLine();
//			if (nextLine == null) {
//				break;
//			}
//			assertEquals(line, nextLine);
//		}
		reader.lines().forEach(l -> assertEquals(line, l));
//		reader.lines().parallel().forEach(l -> assertEquals(line, l));
	}

}
