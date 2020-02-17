package setup.models;

public class Rectangle extends Polygons {

	public Rectangle(double lengthA, double lengthB) {
		super(lengthA, lengthB);
	}

	@Override
	public double getArea() {
		return getLengthA() * getLengthB();
	}

}
