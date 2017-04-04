import java.lang.Math;

public class BSTHeightDemo {

    /**
     * Program execution starts here
     * Go through several BSTs and show height
     * @param command-line arguments (ignored)
     */
    
    public static void main(String[] args) {

	// Create a BST with one node.
	// Height should be one:   5
	SimpleBST b1 = new SimpleBST();
	b1.setRoot(new BSTNode(5));
	System.out.println("b1 height = " + b1.height());

	// Create a BST with two child nodes.
	// Height should be two:   5
	//                        / \
	//                       3   9
	SimpleBST b2 = new SimpleBST();
	b2.setRoot(new BSTNode(5));
	b2.root.left = new BSTNode(3);
	b2.root.right = new BSTNode(9);
	System.out.println("b2 height = " + b2.height());

	// Create a degenerate BST, with the same number of nodes
	// as before, but not a full tree, all left child nodes.
	// Height should be three:   5
	//                          / 
	//                         3
	//                        /
	//                       1
	SimpleBST b3 = new SimpleBST();
	b3.setRoot(new BSTNode(5));
	b3.root.left = new BSTNode(3);
	b3.root.left.left = new BSTNode(1);
	System.out.println("b3 height = " + b3.height());

	// Create a larger BST, with diff number of child nodes
	// Height should be four:    5
	//                          / \ 
	//                         3   7
	//                        /   / \
	//                       1   6   9
	//                              / \
	//                             8  10
	SimpleBST b4 = new SimpleBST();
	b4.setRoot(new BSTNode(5));
	b4.root.left = new BSTNode(3);
	b4.root.left.left = new BSTNode(1);
	b4.root.right = new BSTNode(7);
	b4.root.right.left = new BSTNode(6);
	b4.root.right.right = new BSTNode(9);
	b4.root.right.right.left = new BSTNode(8);
	b4.root.right.right.right = new BSTNode(10);
	System.out.println("b4 height = " + b4.height());
	
    }
    
}

/**
 * A simple int binary search tree
 * Note that search parts aren't actually implemented here,
 * nor are any restrictions, for simplicity.
 */

class SimpleBST {

    /**
     * The root of this tree
     */
    
    public BSTNode root = null;

    /**
     * Return height of this tree
     * @param int height of tree starting at root
     */
    public int height() {
	if (root == null) {
	    return 0;
	} else {
	    return root.height();
	}
    }

    /**
     * Set the root of this tree
     * @param newRoot - the new root of this tree
     */
    
    public void setRoot(BSTNode newRoot) {
	root = newRoot;
    }
    
}

/**
 * A single node in the BST
 * Consists of data and references to L and R child
 * nodes (null if nonexistent)
 */

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
     * Constructor.  A new BSTNode MUST have data in it.
     * @param int data for this node
     */

    public BSTNode(int newData) {
	data = newData;
    }
    
    /**
     * Get string form of data
     * @return String string form of data
     */
    
    public String getData() {
	return "" + data;
    }

    /**
     * Return height of this tree
     * Note this is recursive!
     * Base case - no child nodes
     * Recursive cases - L or R child node, or both
     * @return int height of tree
     */
    
    public int height() {

	// Fill in placeholder "impossible" value of -1
	
	int leftHeight = -1;
	int rightHeight = -1;

	// If left is null, then height from left on down is 1
	// We auto-add one as part of the return statement so set
	// to 0.
	// Otherwise, recurse to find height
	
	if (left == null) {
	    leftHeight = 0;
	} else {
	    leftHeight = left.height();
	}

	// If right is null, then height from right on down is 1
	// We auto-add one as part of the return statement so set
	// to 0.
	// Otherwise, recurse to find height
	
	if (right == null) {
	    rightHeight = 0;
	} else {
	    rightHeight = right.height();
	}

	// Return the greater of left or right height
	return 1 + Math.max(leftHeight, rightHeight);
    }
}
