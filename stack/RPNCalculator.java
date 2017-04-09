public class RPNCalculator {

    /**
     * Our stack of values
     */
    
    SimpleStack s = new SimpleStack();

    /**
     * Apply "add" operation to top two values of stack"
     */
    
    public void add() {
	int x = s.pop();
	int y = s.pop();
	int z = x + y;
	s.push(z);
    }

    /**
     * Apply "subtract" operation to top two values of stack"
     */
    
    public void subtract() {
	int x = s.pop();
	int y = s.pop();
	int z = y - x;
	s.push(z);
    }

    /**
     * Apply "multiply" operation to top two values of stack"
     */

    public void multiply() {
	int x = s.pop();
	int y = s.pop();
	int z = x * y;
	s.push(z);
    }

    /**
     * Apply "divide" operation to top two values of stack"
     */
    
    public void divide() {
	int x = s.pop();
	int y = s.pop();
	int z = y / x;
	s.push(z);
    }

    /**
     * Given some list of arguments from the command line, interpret
     * them as an RPN list of operations and calculate them
     * Possible arguments: +, -, x, /, or an integer value
     * Example: "2 3 4 + x"
     *   Creates a stack with values 2, 3, 4
     *   Applies + to the top two elements (3, 4) = 7, 
     *      then puts result (7) on stack
     *   New stack is now 2, 7
     *   Applies x to top two elements (2, 7) = 14,
     *      then puts result (14) on stack
     * @param args List of arguments
     * SIDE EFFECT
     */
    
    public void calculate(String[] args) {
	for (String x : args) {

	    System.out.println("Stack: " + s + " | Applying " + x);
	    
	    if (x.equals("+")) {
		add();
	    } else if (x.equals("-")) {
		subtract();
	    } else if (x.equals("x")) {
		multiply();
	    } else if (x.equals("/")) {
		divide();
	    } else {
		try {
		    int val = Integer.parseInt(x);
		    s.push(val);
		} catch (NumberFormatException nfex) {
		    System.out.println("Could not parse " + x);
		    System.exit(1);
		}
	    }
	    
	}

	System.out.println("Final stack: " + s);
	    
    }
    
    public static void main(String[] args) {

	RPNCalculator r = new RPNCalculator();
	r.calculate(args);
    }
    
}
