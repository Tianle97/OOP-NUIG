package nuig.oop.runtime;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

import nuig.oop.model.Container;
import nuig.oop.view.Strategy;
import nuig.oop.view.VideoCatalogue;

public class Application {
	
	public static void main(String[] args) {
		
			Container container = new Container();
			try {
				container = jsonContainer("data.json");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//debug
			System.out.println("debug film number: "+container.getFilms().size());
			//debug
			System.out.println("debug tv number: "+container.getTvseries().size());
			Strategy strategy = new VideoCatalogue("Mewtwo");
			strategy.display(container);

	}
	
	/**
	 * Reads an container from a JSON file.
	 * 
	 * @param a the container to serialize
	 */
	public static Container jsonContainer(String filename) throws Exception{
		/*
		 * This is the powerful class of Jackson that does all the translation between
		 * program model and data model.
		 */
		ObjectMapper mapper = new ObjectMapper();
		
		// We use the object mapper to write the container in two ways:
		Container container = null;
		
		container = mapper.readValue(new File(filename), Container.class);
		
		return container;
	}
}
