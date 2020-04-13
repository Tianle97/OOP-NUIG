package assignment2.model;

import java.util.HashSet;
import java.util.Set;

/**
 * A collection of events that can be used as the root of the JSON data.
 * 
 * @author alessandro.adamou
 *
 */
public class EventContainer {

	/**
	 * Event sorting is taken care of by the Timeline, so I'm better off with a
	 * faster HashSet here.
	 */
	private Set<Event> events = new HashSet<>();

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}
