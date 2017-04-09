import java.util.*;

public class ParenCheck {

    public static void main(String[] args) {

	// Make sure one argument was passed in
	
	if (args.length != 1) {
	    System.out.println("Enter one argument only!");
	    System.exit(1);
	}

	// Get our argument from the command line
	
	String in = args[0];
	System.out.println("Checking " + in + " for balance..");

	// Create the stack
	
	SimpleStackWithException s = new SimpleStackWithException();

	// Convert our string to an array of chars (easier for traversing!)
	
	char[] charArray = in.toCharArray();

	try {

	    // Go through array of chars.  Add an element to the stack
	    // every time we have a (, remove an element every time we have
	    // a ).
	    // Other chars are ignored.
	    // If an exception is thrown, we have a ) with an unmatched (.
	    // e.g. something like the last char here: ()())
	    // This is one way of finding out we are unbalanced 
	    
	    for (char x : charArray) {
		if (x == '(') {
		    // Add an element to the stack
		    // Doesn't matter what we push here
		    s.push(1);
		    System.out.println("\tPUSH! stack depth = " + s.size());
		} else if (x == ')') {
		    // Pop an element from the stack
		    // We can ignore whatever it returns
		    s.pop();
		    System.out.println("\tPOP! stack depth = " + s.size());
		} else {
		    // Ignore the char
		}

	    }
	} catch (EmptyStackException esex) {
	    System.out.println("\tTried to pop from empty stack!");
	    System.out.println("Not balanced!");
	    System.exit(0);
	}

	// We never went negative in stack size, so only two possible
	// results: we are exactly even and final stack size is 0, OR
	// we have more ('s than )'s and are thus unbalanced.
	
	System.out.println("\tStack size = " + s.size());	
	if (s.size() == 0) {
	    System.out.println("Perfectly balanced!");
	} else {
	    System.out.println("Not balanced!");
	}

	
    }
}
