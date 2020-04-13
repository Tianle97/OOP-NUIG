package assignment2.model;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This implementation uses a minimal model of a single Event class, which in
 * theory accommodates the possibility of event-subevent hierarchies of
 * arbitrary depth. It is also okay to have separate classes for main events
 * (which admit subevents) and subevents (which do not), in which case they
 * should extend a shared abstract class that groups the elements in common
 * (name, year etc.).
 * 
 * @author alessandro.adamou
 *
 */
public class Event implements Comparable<Event> {

	/**
	 * Use a TreeSet to keep subevents sorted.
	 */
	private SortedSet<Event> subevents = new TreeSet<>();

	private Year year;

	private String name;

	private String type;

	/**
	 * Throwing the exception here means making the model itself resistant to
	 * anomalous conditions deriving from inconsistent events. The exception will be
	 * handled in another part of the program (in this case, this very class but
	 * could have been in the Application as well).
	 * 
	 * @param subevent the event to add as a subevent of this one.
	 * @throws InconsistentEventException if the subevent being added took place
	 *                                    before this event.
	 */
	public void addSubevent(Event subevent) throws InconsistentEventException {
		if (subevent.getYear().isBefore(this.getYear()))
			throw new InconsistentEventException(this, subevent);
		this.subevents.add(subevent);
	}

	/**
	 * The events are compared by year, then by name. We could have included types
	 * and subevents to make the comparison but we'll keep it simple this time.
	 */
	@Override
	public int compareTo(Event other) {
		int yearMatch = this.getYear().compareTo(other.getYear());
		if (yearMatch == 0)
			return this.getName().compareTo(other.getName());
		return yearMatch;
	}

	public String getName() {
		return name;
	}

	/**
	 * Returns the subevents of this event.
	 * 
	 * @return the set of subevents in their natural order.
	 */
	public SortedSet<Event> getSubevents() {
		// Prevent the resulting set from external modification.
		return Collections.unmodifiableSortedSet(subevents);
	}

	public String getType() {
		return type;
	}

	public Year getYear() {
		return year;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This custom implementation of setSubEvents() overrides the usual setter
	 * method in the encapsulation. The reason is that I want to make sure
	 * addSubevent() is called, so that it will catch any inconsistent sub-event.
	 * Here, we react to the condition by dropping the subevent altogether but
	 * continuing with the others.
	 * 
	 * Another advantage is that it takes any {@link Collection}: you can give it an
	 * {@link ArrayList}, {@link HashSet} etc. and it will just work.
	 * 
	 * @param subevents the set of events to add as subevents of this one.
	 */
	public void setSubevents(Collection<Event> subevents) {
		for (Event e : subevents)
			try {
				addSubevent(e);
			} catch (InconsistentEventException ex) {
				// Print a warning, but go ahead with the addition of other events.
				System.err.println("[WARN] Skipping addition of " + e + " as a sub-event of " + this);
				/*
				 * Another way to catch it could have been to change the subevent year to match
				 * the main event year, then try adding it again (and you would have to catch
				 * the exception again, but it will most likely not happen a second time).
				 */
			}
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	/**
	 * The string form of the Event is simple, not the pretty-printed one that is
	 * expected by the Application. This is also what gets printed as part of the
	 * logging message for inconsistent events, so it should be concise.
	 */
	@Override
	public String toString() {
		return getName() + " (" + getYear() + ")";
	}

}
