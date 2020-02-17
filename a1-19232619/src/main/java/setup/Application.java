package setup;

import setup.models.Circle;
import setup.models.Ellipse;
import setup.models.Rectangle;
import setup.models.Shapes;
import setup.models.Triangle;
import setup.models._Composite_Shapes;

public class Application {
	public static void main(String[] args) {
		// declare i type int to calculate the number of times which is I add elements
		// into cs1
		int i = 0;
		// create two _Composite_Shapes objects;
		// one calls cs1 , one called cs2
		_Composite_Shapes cs1 = new _Composite_Shapes();
		_Composite_Shapes cs2 = new _Composite_Shapes();

		// create a circle object give radius and name
		Shapes circle = new Circle(5);
		circle.setName("circle");
		cs1.addShapes(circle);
		// record the number of time add into cs
		i++;

		Shapes rectangle = new Rectangle(7, 8);
		rectangle.setName("rectangle");
		cs1.addShapes(rectangle);
		i++;

		Shapes ellipse = new Ellipse(6, 8);
		ellipse.setName("ellipse");
		cs1.addShapes(ellipse);
		i++;

		Shapes triangle = new Triangle(6, 8);
		triangle.setName("triangle");
		cs1.addShapes(triangle);
		i++;

		cs1.addShapes(circle);
		i++;
		cs1.addShapes(circle);
		i++;

		cs2.addShapes(circle);
		cs2.addShapes(cs1);
		// guve the cs1 name in the cs2
		cs2.getShapes().iterator().next().setName("cs1");
		cs2.addShapes(cs1);

		System.out.println("\n----------Result----------");
		
		System.out.println("I add " + i
				+ " times different shapes in cs1(have 2 same circle) however the hashset(no repeat) size is: "
				+ cs1.getShapeCount());

		System.out.println("I add 3 times different shapes in sc2(one circle and two cs1, then get the size is: "
				+ cs2.getShapeCount() + "\n");

		for (Shapes _c_s : cs1.getShapes()) {
			System.out.println("CS1---Name:" + _c_s.getName() + " \t\t --------  Area: " + _c_s.getArea());
		}
		System.out.println();
		for (Shapes _c_s : cs2.getShapes()) {
			System.out.println("CS2---Name:" + _c_s.getName() + "  \t\t --------  Area: " + _c_s.getArea());
		}

		System.out.println("\nCS1 Total Area:" + cs1.getArea());
		System.out.println("CS2 Total Area:" + cs2.getArea());
	}

}
