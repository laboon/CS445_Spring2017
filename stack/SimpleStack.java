import java.util.*;

/**
 * The program stack.
 */

public class SimpleStack {

    /**
     * ArrayList which stores values.
     */
    
    private ArrayList<Integer> _data = new ArrayList<Integer>();

    /**
     * Default constructor (no elements on stack)
     */

    public SimpleStack() {
	// This space deliberately kept blank
    }
    
    /**
     * Push an int value onto the stack.
     * @param val value to push
     */
    
    public void push(int val) {
	// Add the value to the end of the ArrayList
	_data.add(new Integer(val));
    }

    /**
     * Pop an int value off of the stack.
     * If stack is empty, return 0.
     * @return int - last-input value on stack
     */
    
    public int pop() {
	// Index of the last element in the ArrayList
	int endIndex = _data.size() - 1;
	if (endIndex < 0) {
	    return 0;
	} else {
	    Integer val = _data.remove(endIndex);
	    return val.intValue();
	}

    }

    /**
     * View the top int value on the stack WITHOUT popping
     * If stack is empty, return 0.
     * @return int - last-input value on stack
     */

    
    public int peek() {
	// If there is no data, return our default value (0)
	if (_data.size() < 0) {
	    return 0;
	} else {
	    Integer val = _data.get(_data.size() - 1);
	    return val.intValue();
	}
    }

    /**
     * Return String version of the stack for output.
     * @return String string version of stack
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
     * DEMO: Runs a demo of the SimpleStack which simply adds and 
     * removes NUM_TIMES elements.
     * This can be used for timing (performance) demonstration.
     * SIDE EFFECT: Prints to console before, during, after pushes/pops
     */
    
    public static void demo() {

	final int NUM_TIMES = 10000000;
	
	System.out.println("Demo!  Pushing and popping " + NUM_TIMES + " elements.");
	SimpleStack s = new SimpleStack();
	for (int j = 0; j < NUM_TIMES; j++) {
	    s.push(j);
	}
	System.out.println("Pushed " + NUM_TIMES + " elements.");
	for (int j = 0; j < NUM_TIMES; j++) {
	    // Ignore return value
	    s.pop();
	}
	System.out.println("Popped " + NUM_TIMES + " elements");
	    
    }
    
    public static void main(String[] args) {

	SimpleStack s = new SimpleStack();

	if (args.length == 0) {
	    demo();
	} else {
	    try {
		for (String elem : args) {
		    if (elem.equalsIgnoreCase("pop")) {
			int val = s.pop();
			System.out.println("Pop!  Got out value: " + val);
		    } else if (elem.equalsIgnoreCase("peek")) {
			int val = s.peek();
			System.out.println("Peek!  Saw value: " + val);
		    } else {
			System.out.println("Pushing value " + elem);
			int n = Integer.parseInt(elem);
			s.push(n);
		    }
		    // Print out stack in each iteration
		    System.out.println("Stack: " + s);
		}
	    } catch (NumberFormatException nfex) {
		System.out.println("Could not parse value, ceasing execution");
		System.exit(1);
	    }
		
	}
    }
    
}
