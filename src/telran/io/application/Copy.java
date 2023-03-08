package telran.io.application;

import java.io.*;
import java.util.Date;

public abstract class Copy {
	
	protected String type;
	protected String source;
	protected String destination;
	protected boolean overwrite;
	
	public Copy (String type, String source, String destination, boolean overwrite) {
		this.type = type;
		this.source = source;
		this.destination = destination;
		this.overwrite = overwrite;
	}

	abstract public long copy() throws FileNotFoundException, IOException;
	
	void copyRun() throws FileNotFoundException, IOException {
		Date dateBefore = new Date();
		
		long size = copy();
		
		Date dateAfter = new Date();
		long time = dateAfter.getTime() - dateBefore.getTime();
		
		int bufferSize;
		if ((bufferSize = BufferCopy.getBufferSize()) == 0) {
			System.out.println(new DisplayResult(type, size, time).toString());
		} else {
			System.out.println(new DisplayResultBuffer(type, size, time, bufferSize).toString());
		}
	}

}
