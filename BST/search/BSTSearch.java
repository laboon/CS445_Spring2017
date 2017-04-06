import java.lang.Math;

public class BSTSearch {

    /**
     * Program execution starts here
     * Go through several BSTs and show height
     * @param command-line arguments
     */
    
    public static void main(String[] args) {

	// Create a large BST, with diff number of child nodes
	// BST:                      5
	//                          / \ 
	//                         3   7
	//                        /   / \
	//                       1   6   9
	//                              / \
	//                             8  10

	System.out.println("Generating BST...");
	
	BST b = new BST();
	b.setRoot(new BSTNode(5));
	b.add(3);
	b.add(7);
	b.add(1);
	b.add(6);
	b.add(9);
	b.add(8);
	b.add(10);
	
	System.out.println("\n****************************************");
	System.out.println("Values which exist in BST (should return true)");
	System.out.println("\nLooking for 5");
	System.out.println("5 exists?   " + b.contains(5));
	System.out.println("\nLooking for 9");
	System.out.println("9 exists?   " + b.contains(9));
	System.out.println("\nLooking for 3");
	System.out.println("3 exists?   " + b.contains(3));
	System.out.println("\nLooking for 10");
	System.out.println("10 exists?   " + b.contains(10));
	System.out.println("\nLooking for 8");
	System.out.println("8 exists?   " + b.contains(8));
	
	System.out.println("\n****************************************");
	System.out.println("Values which don't exist in BST (should return false)");
	System.out.println("\nLooking for 100");
	System.out.println("100 exists? " + b.contains(100));
	System.out.println("\nLooking for 2");
	System.out.println("2 exists?   " + b.contains(2));
	System.out.println("\nLooking for 4");
	System.out.println("4 exists?   " + b.contains(4));
	System.out.println("\nLooking for -1");
	System.out.println("-1 exists?  " + b.contains(-1));

	
	
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
	root.add(n);
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
