package setup.models;

public abstract class Shapes {
	private String name;

	public abstract double getArea();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
