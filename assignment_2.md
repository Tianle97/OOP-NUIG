# CT548 OO Software Development - Assignment 2

__Deadline: Wednesday, Feb 26, 2020, 18:00__

## A timeline of Historical events

Design (in UML) and implement (in Java) a system that catalogues historical events by year. The program will load event data from an existing catalogue in JSON. Then in the application, the user will be able to do the following:

* Enter a year or a range of two years, and obtain a list of all the historical events on record that began in a year within the provided range (including extremities), ordered by year. The list prints information on each event.

The information to be displayed is as follows:

1. Every event has a __name__ and a __year__: if it lasted more than one year, make that the year it started (e.g. 1914 for World War I).
2. Events can be of several __types__, such as conflicts (e.g. World War I, 1914-1918), demonstrations/uprisings (Los Angeles riots, 1992), elections/polls (e.g. Italian institutional referendum, 1946), treaties (e.g. the Congress of Vienna, 1814–15), awards (e.g. Marie Curie's Nobel Prize, 1903) and more. Note that __events can also exist without a specific type__.
3. Finally, events may __include other events__. These sub-events are logically related and have the characteristic that they cannot start before the "containing" event. For example, the Battle of Verdun (1916) is a sub-event of World War I. The program __does not need__ to search in sub-events to find matches with the user query (i.e. it is enough to look at "main" events only).

The above example events, types etc. are not exhaustive. In fact, each student MUST extend the event dataset with at least three more main events, at least two of which with sub-events.

The lists of events returned to the user MUST be __ordered by year__ and __without repetitons of events__. The order of events in the same year is irrelevant.

The __model__ of your program, in addition to containing the above information, MUST have the following characteristics:

a. At least one application of the _Singleton pattern_.
c. _Encapsulate_ the fields that require to be accessed outside the class.
d. Must fulfil the Open-Closed principle: I want to be able to create new subclasses of event (for example events with an end date, or with participants), _without having to modify your code_.

Both UML __use case__ and __class diagrams__ are mandatory.

### Bonus requirements
* Make it efficient for the system to retrieve events when the user inputs the year (or year range): keep an index of events by year instead of inspecting each event for its year, but _do not duplicate events_ in doing so. It is okay to scan the entire data _once_ in order to build the index.
* Make it impossible for an event to accept a sub-event starting on an earlier year. For this requirement to be fulfilled, this has to be done at model level (e.g. the Event class) by throwing and handling exceptions.

### Instructions for packaging

Same as for Assignment 1.

A JSON file with some data to get you started is attached. You can modify the structure of the JSON schema to suit the needs of your model, if with appropriate justification (to be documented in the README file). The actual data file that you used for your tests must be included with your package.

### Hints and recommendations

* It is your decision whether you want the application to be an interactive menu or a one-off program that takes arguments (i.e. the `String[] args` of the main method) for the user to enter the year(s).
* You can use Jackson to read from JSON. As with writing, you can use Jackson's `ObjectMapper` again, but this time invoking its `readValue()` method(s). Note that Jackson requires the classes of your model to have default constructors (without arguments, e.g. `Event()`).
* The data structure that holds the index of events could be a singleton.
* A reasonably efficient way to organise your events by year could be to use a `TreeMap<Year, TreeSet<Event>>`, where `Event` is a class that you will have created and `Year` is the class `java.time.Year` - https://docs.oracle.com/javase/8/docs/api/java/time/Year.html (you could use strings or integers instead of Year but it would be more error-prone, not to mention less elegant). This would give you sorting and matching almost for free (you can scroll the treemap's keys and they will appear in order). Note that `TreeMap` has the same methods as `HashMap`, and `TreeSet` has almost the same methods as `ArrayList` so it's no steep learning curve. Tree sets also help you keep the list of events to be returned in order. When you don't need ordering, you can instead use `HashSet` to boost performance.
* To make the above work, however, you should make the `Event` a `Comparable` (e.g. by year). Note that `java.time.Year` is already `Comparable`.
* Regarding sub-event restrictions: you can ensure consistency of years by preventing an event from being added a sub-event that starts before or ends later, and throwing an exception accordingly if someone (such as the user, or Jackson when it loads data) tries to do it.

