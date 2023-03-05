package telran.io.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class InputOutputTest {
	
	int offset = 5;

	String fileName = "myFile";
//	String directoryName = "myDirectory1";
	String directoryName = "myDirectory1/myDirectory2";

	@BeforeEach
	void setUp() throws Exception {
		new File(fileName).delete();
		new File(directoryName).delete();
	}

	@Test
	@Disabled
	void testFile() throws IOException {
		File f1 = new File(fileName);
		assertTrue(f1.createNewFile());
		assertTrue(f1.exists());

		File dir1 = new File(directoryName);
//		assertTrue(dir1.mkdir());
		assertTrue(dir1.mkdirs());
		System.out.println(dir1.getAbsolutePath());
	}

	@Test
//	@Disabled
	void printDirectoryFileTest() {

		printDirectoryFile("D:\\eclipse-workspace", 3);
	}

	void printDirectoryFile(String path, int maxLevel) {		
		if (maxLevel < 1) {
			maxLevel = Integer.MAX_VALUE;
		}		
		File root = new File(path);	
		int depth = root.toPath().toAbsolutePath().getNameCount();
		printName(depth, root);
		filePrintTree(maxLevel, root, depth);
	}

	private void filePrintTree(int maxLevel, File root, int depth) {
		if (depth > maxLevel) {
			return;		
		}
		File[] dirContant = root.listFiles();
		for (File file : dirContant) {			
			File current = file;
			depth = current.toPath().toAbsolutePath().getNameCount();
			if (current.isDirectory()) {				
				printName(depth, current);	
				filePrintTree(maxLevel, current, depth);
			} else {
				printName(depth, current);
			}
		}
	}

	private void printName(int depth, File current) {
		System.out.print(" ".repeat(offset * depth));
		System.out.printf("%s%s\n", current.isDirectory() ? "directory: " : "file name: ", current.getName());
	}

	@Test
	@Disabled
	void testFiles() {
		Path path = Path.of(".");
		System.out.println(path.toAbsolutePath().getNameCount());
	}

	
	@Test
	@Disabled
	void printDirectoryFilesTest() throws IOException {
		
		printDirectoryFiles("D:\\eclipse-workspace", 3);
	}

	void printDirectoryFiles(String path, int maxLevel) throws IOException {
		if (maxLevel < 1) {
			maxLevel = Integer.MAX_VALUE;
		}
		Path root = Paths.get(path);
		Files.walk(root, maxLevel).forEach(p -> filesPrintTree(p));		
	}

	private void filesPrintTree(Path path) {
		int depth = path.toAbsolutePath().getNameCount();		
		printName(depth, path.toFile());
	}

}
