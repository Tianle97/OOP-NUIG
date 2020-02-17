package setup.models;

public class Circle extends _Primitive_Shapes {

	private double radius = getLengthA();

	public Circle(double radius) {
		super(radius, radius);
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

}
