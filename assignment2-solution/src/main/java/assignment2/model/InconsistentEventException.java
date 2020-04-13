package assignment2.model;

/**
 * Thrown whenever an attempt is made to add to an event a sub-event that took
 * place earlier.
 * 
 * @author alessandro.adamou
 *
 */
public class InconsistentEventException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8035569608367507969L;

	/**
	 * This exception type is also aware of which events were involved in the
	 * "attempted crime".
	 */
	private Event mainEvent, subEvent;

	public InconsistentEventException(Event mainEvent, Event subEvent) {
		// There is a constructor in Exception that takes the message as a String.
		super("Cannot add a sub-event from " + subEvent.getYear() + " to an event from " + mainEvent.getYear());
	}

	public Event getMainEvent() {
		return mainEvent;
	}

	public Event getSubEvent() {
		return subEvent;
	}

}
