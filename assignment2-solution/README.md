# CT548 2019-20 Assignment 2

# Example solution

This package contains one possible solution to this year's Assignment 2 - Historical timeline.

This particular solution incorporates the following assumptions:
1. Interactive, one-shot application: the program gets the year parameters by prompting for user input, and answers one single query per run.
2. Minimal event model: one single concrete class is shared between events and sub-events, which means sub-sub-events etc. are also possible.
3. If there is an inconsistent sub-event in the data, it is dropped and the remaining events and sub-events are still processed.

Note that alternative approaches are also acceptable, for example:
1. Interactive application that answers multiple queries in one run, or a non-interactive program that takes the input from the parameters passed to the JVM (the `args` string array in the main method).
2. Separate classes for main event and sub-event  _if_  they do not extend one another. Rather, they should extend a common abstract class that groups the features in common.
3. The program aborting if an inconsistent sub-event is found (as long as this is done through exception handling and the model prevents such anomalies).

For details on specific implementation choices, please consult the Javadoc and comments present in each Java source file.

The main program is the class `assignment2.Application`

The data file `assignment_2_data.json` has been extended to showcase anomalous conditions such as repeated events, random ordering, and sub-events taking place before the main event.