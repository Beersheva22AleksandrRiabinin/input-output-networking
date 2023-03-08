package telran.io.application;

public class DisplayResultBuffer extends DisplayResult {

	int bufferSize;

	public DisplayResultBuffer(String type, long size, long time, int bufferSize) {
		super(type, size, time);
		this.bufferSize = bufferSize;
	}

	@Override
	public String toString() {

		return String.format(super.toString() + "; buffer size: %s kb", bufferSize / 1024);
	}

}
