import java.util.*;

/**
 * A simple Queue built on top of ArrayList
 */

public class SimpleQueue {

    /**
     * ArrayList which stores values.
     */
    
    private ArrayList<Integer> _data = new ArrayList<Integer>();

    /**
     * Default constructor (no elements in queue)
     */

    public SimpleQueue() {
	// This space deliberately kept blank
    }
    
    /**
     * Add int value onto the queue.
     * @param val value to add to the queue
     */
    
    public void add(int val) {
	// Add the value to the end of the ArrayList
	_data.add(new Integer(val));
    }

    /**
     * Remove an int value from the front of the queue
     * If queue is empty, return 0.
     * @return int - "oldest" value in the queue
     */
    
    public int remove() {
	if (_data.size() <= 0) {
	    return 0;
	} else {
	    Integer val = _data.remove(0);
	    return val.intValue();
	}

    }

    /**
     * View the top int value in the queue WITHOUT removing it
     * If queue is empty, return 0.
     * @return int - oldest value in queue
     */

    
    public int peek() {
	// If there is no data, return our default value (0)
	if (_data.size() < 0) {
	    return 0;
	} else {
	    Integer val = _data.get(0);
	    return val.intValue();
	}
    }

    /**
     * Return String version of the queue for output.
     * @return String string version of queue
     */
    
    public String toString() {
	StringBuilder toReturn = new StringBuilder("[ ");
	for (int j=0; j < (_data.size() - 1); j++) {
	    toReturn.append(_data.get(j) + ", ");
	}
	toReturn.append(_data.get(_data.size() - 1) + " ]");
	return toReturn.toString();
    }

    /**
     * DEMO: Runs a demo of the SimpleQueue which simply adds and 
     * removes NUM_TIMES elements.
     * This can be used for timing (performance) demonstration.
     * SIDE EFFECT: Prints to console before, during, after pushes/pops
     */
    
    public static void demo() {

	final int NUM_TIMES = 200000;
	
	System.out.println("Demo!  Adding and removing " + NUM_TIMES + " elements.");
	SimpleQueue s = new SimpleQueue();
	for (int j = 0; j < NUM_TIMES; j++) {
	    s.add(j);
	}
	System.out.println("Added " + NUM_TIMES + " elements.");
	
	for (int j = 0; j < NUM_TIMES; j++) {
	    // Ignore return value
	    s.remove();
	}	
	System.out.println("Removed " + NUM_TIMES + " elements");
	    
    }
    
    public static void main(String[] args) {

	SimpleQueue s = new SimpleQueue();

	if (args.length == 0) {
	    demo();
	} else {
	    try {
		for (String elem : args) {
		    if (elem.equalsIgnoreCase("remove")) {
			int val = s.remove();
			System.out.println("Remove!  Got out value: " + val);
		    } else if (elem.equalsIgnoreCase("peek")) {
			int val = s.peek();
			System.out.println("Peek!  Saw value: " + val);
		    } else {
			System.out.println("Adding value " + elem);
			int n = Integer.parseInt(elem);
			s.add(n);
		    }
		    // Print out queue in each iteration
		    System.out.println("Queue: " + s);
		}
	    } catch (NumberFormatException nfex) {
		System.out.println("Could not parse value, ceasing execution");
		System.exit(1);
	    }
		
	}
    }
    
}
