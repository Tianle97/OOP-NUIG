package nuig.oop.factory;

import nuig.oop.model.TVseries;

public class TVFactory implements Factory {

	public TVseries getInstance() {
		return TVseries.getInstance();
	}

}
