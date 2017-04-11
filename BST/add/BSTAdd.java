import java.lang.Math;
import java.util.*;

public class BSTAdd {

    /**
     * Program execution starts here
     * Generate a BST by asking for elements, and adding them one at a time
     * @param command-line arguments
     */
    
    public static void main(String[] args) {

	String input = "";
	BST b = new BST();
	Scanner sc = new Scanner(System.in);

	boolean first = true;
	
	while (!input.equalsIgnoreCase("Q")) {
	    System.out.print("Enter int to add int, or Q to quit > ");
	    input = sc.next();
	    if (input.equalsIgnoreCase("Q")) {
		// Wait and quit
	    } else {
		try {
		    int valToAdd = Integer.parseInt(input);
		    b.add(valToAdd);
		    b.prettyPrint();
		} catch (NumberFormatException nfex) {
		    System.out.println("Sorry, can't parse " + input + "!");
		}
	    }
	    
	}
    }
}

class BST {
    /**
     * The root of this tree
     */
    
    public BSTNode root = null;

    /**
     * Set the root of this tree
     * @param newRoot - the new root of this tree
     */
    
    public void setRoot(BSTNode newRoot) {
	root = newRoot;
    }

    /**
     * Add element to the BST in the appropriate location
     * @param n value to add
     */

    public void add(int n) {
	if (root == null) {
	    setRoot(new BSTNode(n));
	} else {
	    root.add(n);
	}
    }

    /**
     * Pretty print out this BST
     * SIDE EFFECT: Prints out BST to console
     */

    public void prettyPrint() {
	if (root == null) {
	    System.out.println("Empty BST!");
	} else {
	    root.prettyPrint(0);
	}
    }

    
    /**
     * Checks to see if value exists in the BST
     * @param value to search for
     * @return boolean true if value exists in BST; false otherwise
     */

    public boolean contains(int n) {

	// If there are no nodes in the tree, whatever value
	// we are looking for is definitely not there.
	
	if (root == null) {
	    return false;
	}

	// Otherwise, start recursively looking through the tree,
	// starting with the root node.
	
	return root.contains(n);
    }

}

class BSTNode {

    /**
     * Data stored in this node
     */
    
    public int data;

    /**
     * Left child node, null if none
     */
    
    public BSTNode left = null;

    /**
     * Right child node, null if none
     */
    
    public BSTNode right = null;

    /**
     * Add a value in the appropriate location
     * BASE CASE: n == data in this node OR child where data would go is null
     * RECURSIVE CASE: proper location for n has a node, call down to it
     * @param n value to add in the BST
     */

    public void add(int n) {
	if (data == n) {
	    // The data is here!  We won't add it again, since n == n
	    // Do nothing
	    System.out.println("\tData = " + data + " n = " + n);
	} else if (n < data) {
	    // Go to the left!  Either something is there, so we should jump
	    // down to that node, or make a new node to store the data
	    if (left == null) {
		System.out.println("\tData = " + data + ", creating left node = " + n);
		left = new BSTNode(n);
	    } else {
		System.out.println("\tData = " + data + ", going left");
		left.add(n);
	    }
	} else {
	    // Only possibility is that data > n (already covered == and <)
	    // So go to the right.  If right is null, make a new node
	    // and put the data there; otherwise, recursively go down
	    if (right == null) {
		System.out.println("\tData = " + data + ", creating right node = " + n);
		right = new BSTNode(n);
	    } else {
		System.out.println("\tData = " + data + ", going right");
		right.add(n);
	    }
	}
    }

    /**
     * Pretty-print out this node and all child nodes.
     * Keeps track of how deep we are in tree via indent argument
     * SIDE EFFECT: Prints this node and child nodes to console
     * @param indent - indent level (depth of tree)
     */
    
    public void prettyPrint(int indent) {
	for (int j = 0; j <= indent; j++) {
	    if (j == indent) {
		System.out.print("|->");
	    } else {
		System.out.print("   ");
	    }
	}
	System.out.println(data);
	if (left != null) {
	    left.prettyPrint(indent + 1);
	}
	if (right != null) {
	    right.prettyPrint(indent + 1);
	}
    }
    
    /**
     * Checks to see if value exists in this node or its sub-tree
     * (children)
     * NOTE: This is a recursive method
     * BASE CASE: Data is stored here, or where it would be is null
     * RECURSIVE CASE: DAta may be 
     * @param value to search for
     * @return boolean true if value exists in subtree; false otherwise
     */

    public boolean contains(int n) {

	boolean toReturn = false;
	
	// We've found it!
	if (n == data) {
	    System.out.println("\tFound it! Data = " + data + ", n = " + n);
	    toReturn = true;
	} else if (n < data) {
	    
	    // If n < data, then the value should be to the left somewher
	    // If left node does not exist, then the value is not in this
	    // BST.  Otherwise, recursively call down to look for it
	    // there.
	    if (left == null) {
		System.out.println("\t*" + n + "* < " + data +
				   ", but left is null! *" + n + "* does not exist!");
		toReturn = false;
	    } else {
		System.out.println("\t*" + n + "* < " + data + " - going left");
		toReturn = left.contains(n);
	    }
	} else {
	    // n must be > data
	    // So the value should be somewhere to the right
	    // If right node does not exist, then the value is not in
	    // in this BST.  Otherwise, recursively call down to look
	    // for it there.
	    
	    if (right == null) {
		System.out.println("\t*" + n + "* > " + data +
				   ", but right is null! *" + n + "* does not exist!");

		toReturn = false;
	    } else {
		System.out.println("\t*" + n + "* > " + data + " - going right");
		toReturn = right.contains(n);
	    }
	}

	return toReturn;
    }

    
    /**
     * Constructor.  A new BSTNode MUST have data in it.
     * @param int data for this node
     */

    public BSTNode(int newData) {
	data = newData;
    }
    
    
}
