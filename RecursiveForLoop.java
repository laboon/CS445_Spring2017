public class RecursiveForLoop {

    /**
     * Count from j to n, printing out each value up
     * to n - 1.
     * Equivalent of:
     * If you pass in 0, equivalent of:
     * for (int j=0; j < 10; j++) {
     *    System.out.println(j);
     * }
     * RECURSIVE CASE: j < 10, calls itself
     * BASE CASE: j >= 10, ceases recursion
     * SIDE EFFECT: Displays current j to console
     * @param j - Current j value
     */

    
    public static void forLoop(int j) {
	
	if (j < 10) {
	    System.out.println(j);
	    forLoop(j + 1);
	} else {
	    // BASE CASE WE'RE DONE
	    
	}
    }

    /**
     * Main - executes one "recursive for loop"
     * @param args - command line arguments (ignored
     */
    
    public static void main(String[] args) {
	forLoop(0);
    }
}
