package nuig.oop.view;

import java.util.List;
import java.util.TreeMap;

import nuig.oop.model.Container;
import nuig.oop.model.Media;

public interface Strategy {
	
	public void display(Container c);
	
	public TreeMap<?, List<Media>> sortMap();

}
