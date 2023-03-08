package telran.io.application;

public class DisplayResult {

	String type;
	long size;
	long time;

	public DisplayResult(String type, long size, long time) {
		this.type = type;
		this.size = size;
		this.time = time;
	}

	public String toString() {

		return String.format("copying type: %s; file size: %s mb; time: %s ms", type, size / 1024 / 1024, time);
	}

}
