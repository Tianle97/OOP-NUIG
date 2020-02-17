package setup.models;

public class Triangle extends Polygons {

	public Triangle(double lengthA, double lengthB) {
		super(lengthA, lengthB);
	}

	@Override
	public double getArea() {
		return getLengthA() * getLengthB() * 0.5;
	}

}
