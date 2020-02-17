package setup.models;

public abstract class _Primitive_Shapes extends Shapes {
	private double lengthA;
	private double lengthB;

	public _Primitive_Shapes(double lengthA, double lengthB) {
		this.lengthA = lengthA;
		this.lengthB = lengthB;
	}

	public double getLengthA() {
		return lengthA;
	}

	public double getLengthB() {
		return lengthB;
	}

}
