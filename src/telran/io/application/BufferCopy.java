package telran.io.application;

import java.io.*;

public class BufferCopy extends Copy {
	
	private static int bufferSize;

	@SuppressWarnings("static-access")
	public BufferCopy(String type, String source, String destination, boolean overwrite, int bufferSize) {
		super(type, source, destination, overwrite);
		this.bufferSize = bufferSize;
	}

	@Override
	public long copy() throws FileNotFoundException, IOException {
		int bytesTotal = 0;
		try (InputStream input = new FileInputStream(source);
				OutputStream output = new FileOutputStream(destination, overwrite);) {
			byte[] buffer = new byte[bufferSize];
			int bytes = 0;
			while ((bytes = input.read(buffer)) > -1) {
				output.write(buffer, 0, bytes);
				bytesTotal += bytes;
			}
		}
		return bytesTotal;
	}

	public static int getBufferSize() {
		return bufferSize;
	}

}
