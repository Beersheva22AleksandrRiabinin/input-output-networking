package telran.io.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class InputOutputTest {

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
	@Disabled
	void printDirectoryFileTest() {
		String path = "D:\\eclipse-workspace";
		int maxLevel = 3;
		File root = new File(path);
		System.out.println("directory: " + root.getName());
		int offset = 5;
		int currentLvl = 0;
		printDirectoryFile(path, maxLevel, currentLvl, offset);
	}

	void printDirectoryFile(String path, int maxLevel, int currentLvl, int offset) {
		if (currentLvl == maxLevel) {
			return;
		}
		File root = new File(path);
		String[] dirContant = root.list();
		int index = 0;
		while (index < dirContant.length) {
			String curPath = path + "\\" + dirContant[index];
			File current = new File(curPath);
			if (current.isDirectory()) {
				System.out.print(" ".repeat(offset));
				System.out.println("directory: " + current.getName());
				if (maxLevel < 1) {
					printDirectoryFile(curPath, maxLevel, currentLvl, offset + 5);
				} else {
					printDirectoryFile(curPath, maxLevel, currentLvl + 1, offset + 5);
				}
			} else {
				System.out.print(" ".repeat(offset));
				System.out.println("file name: " + current.getName());
			}
			index++;
		}


	}

	@Test
	@Disabled
	void testFiles() {
		Path path = Path.of(".");
		System.out.println(path.toAbsolutePath().getNameCount());
	}

	
	@Test
//	@Disabled
	void printDirectoryFilesTest() throws IOException {
		String path = "D:\\eclipse-workspace";
		int maxLevel = 3;	
		int offset = 5;
		printDirectoryFiles(path, maxLevel, offset);
	}

	void printDirectoryFiles(String path, int maxLevel, int offset) throws IOException {
		if (maxLevel < 1) {
			maxLevel = Integer.MAX_VALUE;
		}
		Path root = Paths.get(path);
		Files.walk(root, maxLevel).forEach(x -> printTree(x.toString(), offset));		
	}

	private void printTree(String path, int offset) {
		File current = new File(path);
		int depth = current.toPath().toAbsolutePath().getNameCount();
		if (current.isDirectory()) {
			System.out.print(" ".repeat(offset * depth));
			System.out.println("directory: " + current.getName());
		} else {
			System.out.print(" ".repeat(offset * depth));
			System.out.println("file name: " + current.getName());
		}
	}

}
