public class RPNCalculator {

    SimpleStack s = new SimpleStack();

    public void add() {
	int x = s.pop();
	int y = s.pop();
	int z = x + y;
	s.push(z);
    }

    public void subtract() {
	int x = s.pop();
	int y = s.pop();
	int z = y - x;
	s.push(z);
    }
    
    public void multiply() {
	int x = s.pop();
	int y = s.pop();
	int z = x * y;
	s.push(z);
    }

    public void divide() {
	int x = s.pop();
	int y = s.pop();
	int z = y / x;
	s.push(z);
    }

    public void calculate(String[] args) {
	for (String x : args) {

	    System.out.println("Stack: " + s + " | Applying " + x);
	    
	    if (x.equals("+")) {
		add();
	    } else if (x.equals("-")) {
		subtract();
	    } else if (x.equals("*")) {
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
