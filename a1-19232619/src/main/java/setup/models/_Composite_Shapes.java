//Student name: Tianle Shu
//ID: 19232619
//Lecturer: DR. ALESSANDRO ADAMOU

package setup.models;

import java.util.HashSet;

public class _Composite_Shapes extends Shapes {

	// create a hashset collection the type is Shapes
	// Reference:https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html
	private HashSet<Shapes> shapes = new HashSet<Shapes>();

	// create a method called addShapes to add elements into hashset
	public void addShapes(Shapes s) {
		shapes.add(s);
	}

	// this method for return the hashset
	public HashSet<Shapes> getShapes() {
		return shapes;
	}

	// calculate totally area
	@Override
	public double getArea() {
		double totalArea = 0;
		for (Shapes s : shapes) {
			totalArea += s.getArea();
		}
		return totalArea;
	}

	// this method to count the number of shapes add
	public int getShapeCount() {
		return getShapes().size();
	}

}
