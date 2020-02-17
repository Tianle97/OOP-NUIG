package setup.models;

public class Ellipse extends _Primitive_Shapes {

	public Ellipse(double lengthA, double lengthB) {
		super(lengthA, lengthB);
	}

	@Override
	public double getArea() {
		return Math.PI * getLengthA() * getLengthB();
	}

}
