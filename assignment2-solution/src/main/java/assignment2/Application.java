package assignment2;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import assignment2.model.Event;
import assignment2.model.EventContainer;
import assignment2.model.Timeline;

/**
 * The main application, with dedicated functions for clarity's sake.
 * 
 * @author alessandro.adamou
 *
 */
public class Application {

	/**
	 * Given a dataset of events, creates an index by year out of it.
	 * 
	 * @param events the event dataset.
	 * @return the populated event index.
	 */
	private static void indexData(EventContainer events) {
		Timeline tl = Timeline.getInstance();
		for (Event e : events.getEvents())
			tl.addEvent(e);
	}

	/**
	 * The main program.
	 * 
	 * @param args this program takes no arguments.
	 */
	public static void main(String[] args) {
		// Load the dataset in memory first
		String path = "assignment_2_data.json";
		ObjectMapper mapper = new ObjectMapper();
		EventContainer events = null;
		final Timeline tl;
		try {
			// Use Jackson to load the data into an EventContainer that it will generate
			events = mapper.readValue(new File(path), EventContainer.class);
			// Then index the data.
			indexData(events);
			// because Timeline is singleton, I can reference it statically, knowing
			// that it will always be the one that was populated by indexData()
			tl = Timeline.getInstance();
			System.out.println(
					"The catalogue contains events in the range " + tl.getFirstYear() + "-" + tl.getLastYear());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-9);
			/*
			 * We'll never get to this next instruction, but adding it will prevent the
			 * compiler from complaining about not having assigned final variable tl.
			 */
			throw new RuntimeException(e);
		}
		// Then process user input
		List<Year> years = parseParams();
		List<Event> results;
		if (years.size() == 1)
			results = tl.listEvents(years.get(0));
		else
			results = tl.listEvents(years.get(0), years.get(1));
		// Finally, print the events that match the query.
		prettyPrintEvents(results, System.out);
	}

	/**
	 * Gets the year query from user input.
	 * 
	 * @return a list of one or two {@link Year} objects.
	 */
	private static List<Year> parseParams() {
		List<Year> params = new ArrayList<Year>();
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter first year: ");
		Year y1 = Year.of(Integer.parseInt(reader.nextLine()));
		params.add(0, y1);
		System.out.print("Enter second year (or press Enter for same as first year): ");
		String line = reader.nextLine();
		if (!line.isBlank())
			params.add(1, Year.of(Integer.parseInt(line)));
		reader.close();
		return params;
	}

	/**
	 * Prints event details to the indicated printer (such as the console).
	 * 
	 * @param events the results
	 * @param out    the destination
	 */
	private static void prettyPrintEvents(Collection<Event> events, PrintStream out) {
		for (Event e : events) {
			out.println(e.getYear() + " : " + e.getName());
			if (e.getType() != null)
				out.println("\ta " + e.getType());
			if (!e.getSubevents().isEmpty()) {
				out.println("\tsub-events:");
				for (Event sub : e.getSubevents())
					out.println("\t - " + sub + (sub.getType() != null ? ": " + sub.getType() : ""));
			}
		}
	}

}
