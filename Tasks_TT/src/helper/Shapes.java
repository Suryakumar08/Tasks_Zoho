package helper;

public class Shapes {
	String shapeName = null;
	public Shapes(String name) {
		shapeName = name;
	}
	
	@Override
	public String toString() {
		return shapeName;
	}
}
