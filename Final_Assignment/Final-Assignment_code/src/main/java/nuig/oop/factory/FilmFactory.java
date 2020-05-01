package nuig.oop.factory;

import nuig.oop.model.Films;

public class FilmFactory implements Factory{

	public Films getInstance() {
		return Films.getInstance();
	}
	
}
