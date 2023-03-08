package telran.io.application;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FilesCopyBuilder {
	
	final static String source = "C:\\Users\\РАА\\Videos\\DALNIY_DRAFT.mp4";
	final static String destination = "C:\\Users\\РАА\\Videos\\copy\\DALNIY_DRAFT.mp4";
	
	final static int MB = 1 * 1024 * 1024;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		int[] bufferSize = { MB / 10, MB, 10 * MB, 100 * MB, (int) Runtime.getRuntime().freeMemory() };
		
		switch (args[0]) {
		case "FilesCopy" : new FilesCopy(args[0], source, destination, true).copyRun(); break;
		case "TransferCopy" : new TransferCopy(args[0], source, destination, false).copyRun(); break;
		case "BufferCopy" : 
			for (int size : bufferSize) {
				new BufferCopy(args[0], source, destination, false, size).copyRun();		
			}
		}	
	}
}
