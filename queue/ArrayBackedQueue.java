import java.util.*;

/**
 * A simple Queue built on top of ArrayList
 */

public class ArrayBackedQueue {

    /**
     *  Default size of array backing this queue
     */
    
    private final int DEFAULT_SIZE = 4;

    /**
     * Current number of elements in queue
     */
    
    private int size = 0;

    /**
     * Front of the queue stored in the array
     */
    
    private int beginIndex = 0;

    /**
     * End of the queue stored in the array
     */
    
    private int endIndex = 0;
    
    /**
     * ArrayList which stores values.
     */
    
    private int[] _data = new int[DEFAULT_SIZE];

    /**
     * Default constructor (no elements in queue)
     */

    public ArrayBackedQueue() {
	// This space deliberately kept blank
    }

    /**
     * Get size of the queue
     * @return int size of the queue
     */

    public int getSize() {
	return size;
    }
    
    /** 
     * Resize the backing array if limit is hit
     * This consists of several steps:
     *   1. Starting from the beginning of the queue in the array,
     *      copy all of the data elements over to the new array
     *   2. The new begin index is 0
     *   3. The new end index is the size of the old array
     * PRECONDITION: The old array must be ENTIRELY filled
     * SIDE EFFECT: Resizes the backing array, modifies begin and end indexes
     */
    
    private void resize() {
	// System.out.println("Resizing!");
	int oldLength = _data.length;
	int newLength = oldLength * 2;
	int [] newData = new int[newLength];

	int newPtr = 0;
	for (int j = beginIndex; j != endIndex ; j = (j + 1) % oldLength) {

	    // Uncomment to see how data is copied over
	    // System.out.println("\tCopying _data[" + j + "] (" + _data[j]
	    // 		       + ") to newData[" + newPtr + "]");
	    newData[newPtr] = _data[j];
	    newPtr++;
	}

	beginIndex = 0;
	endIndex = newPtr;

	_data = newData;
	
    }

    
    /**
     * Add int value onto the queue.
     * SIDE EFFECT: Modifies _data array and endIndex value
     * @param val value to add to the queue
     */
    
    public void add(int val) {
	// Size is now one greater
	size++;
	if (size == _data.length) {
	    // No more room!  Resize our backing array
	    // Uncomment to see how data gets copied over
	    // System.out.println("Size (" + size + ") == Array Length ("
	    // 		       + _data.length + "), resizing!");
	    resize();
	}
	_data[endIndex] = val;
	endIndex = (endIndex + 1) % _data.length;

    }

    /**
     * Remove an int value from the front of the queue
     * If queue is empty, return 0.
     * SIDE EFFECT: Modifies _data array and beginIndex value
     * @return int - "oldest" value in the queue
     */
    
    public int remove() {
	if (_data.length < 0) {
	    return 0;
	} else {
	    int toReturn = _data[beginIndex];
	    beginIndex = (beginIndex + 1) % _data.length;
	    size--;
	    return toReturn;
	}

    }

    /**
     * View the top int value in the queue WITHOUT removing it
     * If queue is empty, return 0.
     * @return int - oldest value in queue
     */

    
    public int peek() {
	// If there is no data, return our default value (0)
	if (size <= 0) {
	    return 0;
	} else {
	    return _data[beginIndex];
	}
    }

    /**
     * Return String version of the queue for output.
     * @return String string version of queue
     */
    
    public String toString() {
	StringBuilder toReturn = new StringBuilder("[ ");
	for (int j=0; j < (_data.length - 1); j++) {
	    toReturn.append(_data[j] + ", ");
	}
	toReturn.append(_data[_data.length - 1] + " ]");
	toReturn.append("\nBegin = " + beginIndex + ", End = " + endIndex
			+ ", Size = " + size);
	return toReturn.toString();
    }

    /**
     * DEMO: Runs a demo of the ArrayBackedQueue which simply adds and 
     * removes NUM_TIMES elements.
     * This can be used for timing (performance) demonstration.
     * SIDE EFFECT: Prints to console before, during, after pushes/pops
     */
    
    public static void demo() {

	final int NUM_TIMES = 200000;
	
	System.out.println("Demo!  Adding and removing " + NUM_TIMES + " elements.");
	ArrayBackedQueue s = new ArrayBackedQueue();
	for (int j = 0; j < NUM_TIMES; j++) {
	    s.add(j);
	}
	System.out.println("Added " + NUM_TIMES + " elements.");
	
	for (int j = 0; j < NUM_TIMES; j++) {
	    // Ignore return value
	    s.remove();
	}	
	System.out.println("Removed " + NUM_TIMES + " elements");
	System.out.println("Final size (should be 0) = " + s.getSize());
    }

    /**
     * Main program
     */
    
    public static void main(String[] args) {

	ArrayBackedQueue s = new ArrayBackedQueue();

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
