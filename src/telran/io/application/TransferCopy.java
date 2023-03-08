package telran.io.application;

import java.io.*;
import java.nio.file.Path;

public class TransferCopy extends Copy {	

	public TransferCopy(String type, String source, String destination, boolean overwrite) {
		
		super(type, source, destination, overwrite);
	}

	@Override
	public long copy() throws FileNotFoundException, IOException {
		try(InputStream input = new FileInputStream(source); 
				OutputStream output = new FileOutputStream(destination, overwrite);) {
			input.transferTo(output);			
		}
		Path path = Path.of(destination);			
		return path.toFile().length();
	}

}
