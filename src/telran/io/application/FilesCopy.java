package telran.io.application;

import java.io.*;
import java.nio.file.*;
public class FilesCopy extends Copy {

	public FilesCopy(String type, String source, String destination, boolean overwrite) {

		super(type, source, destination, overwrite);
	}

	@Override
	public long copy() throws IOException{
		Path path1 = Path.of(source);
		Path path2 = Path.of(destination);
		try {
			if (overwrite) {
				Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
			} else {
				Files.copy(path1, path2);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path2.toFile().length();
	}

}
