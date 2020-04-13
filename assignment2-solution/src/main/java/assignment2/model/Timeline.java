package assignment2.model;

import java.time.Year;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * The class that implements the index of events by year and provides singleton
 * access.
 * 
 * @author alessandro.adamou
 *
 */
public class Timeline {

	/**
	 * Singleton instance
	 */
	private static Timeline me;

	public static Timeline getInstance() {
		if (me == null)
			me = new Timeline();
		return me;
	}

	/**
	 * This is the actual index. At the definition level I don't care if the sets
	 * inside the SortedMap are themselves sorted or not. In fact, I don't need them
	 * to be, because the sorting of keys is guaranteed by the SortedMap (which
	 * TreeMap implements) and all the events in a set will have the same year.
	 */
	private SortedMap<Year, Set<Event>> eventIndex;

	private Timeline() {
		eventIndex = new TreeMap<Year, Set<Event>>();
	}

	public void addEvent(Event e) {
		Year y = e.getYear();
		if (y == null)
			// Without a suitable key, we cannot index the event.
			throw new IllegalArgumentException("Cannot index an event without a year");
		if (!eventIndex.containsKey(y))
			/*
			 * In the actual implementation, I make them TreeSets. They could be HashSets
			 * too, but in that case it would be better for Event to fulfil the HashSet
			 * contract by overriding equals() and hashCode() so we won't do that.
			 */
			eventIndex.put(y, new TreeSet<Event>());
		// The previous instruction will have guaranteed that a Set for y exists.
		eventIndex.get(y).add(e);
		// Note that we don't need to put the set back into the index after changing it.
	}

	/**
	 * Useful for guiding the user in entering satisfiable queries.
	 * 
	 * @return the year of the earliest main event.
	 */
	public Year getFirstYear() {
		return eventIndex.firstKey();
	}

	/**
	 * We'll make it easy and ignore subevents that took place after the last main
	 * event began.
	 * 
	 * @return the year of the latest main event.
	 */
	public Year getLastYear() {
		return eventIndex.lastKey();
	}

	public List<Event> listEvents(Year year) {
		// Just call the two-year version of the method, with the same year.
		return listEvents(year, year);
	}

	public List<Event> listEvents(Year from, Year to) {
		// A LinkedList is enough as it will only be accessed iteratively.
		List<Event> result = new LinkedList<Event>();
		// Note that we have to advance the second year by one for subMap to include it.
		SortedMap<Year, Set<Event>> sub = eventIndex.subMap(from, to.plusYears(1));
		for (Entry<Year, Set<Event>> entry : sub.entrySet())
			result.addAll(entry.getValue());
		// Close to modification: do not allow the resulting list to be tampered with.
		return Collections.unmodifiableList(result);
	}
}
