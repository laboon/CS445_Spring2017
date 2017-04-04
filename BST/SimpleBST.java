import java.lang.Math;

public class SimpleBST {

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
     * Program execution starts here
     * Go through several BSTs and show height
     * @param command-line arguments
     */
    
    public static void main(String[] args) {

	// Create a BST with one node.
	// Height should be one:   5
	SimpleBST b1 = new SimpleBST();
	b1.setRoot(new BSTNode(5));

	// Create a BST with two child nodes.
	// Height should be two:   5
	//                        / \
	//                       3   9
	SimpleBST b2 = new SimpleBST();
	b2.setRoot(new BSTNode(5));
	b2.root.left = new BSTNode(3);
	b2.root.right = new BSTNode(9);

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
     * Constructor.  A new BSTNode MUST have data in it.
     * @param int data for this node
     */

    public BSTNode(int newData) {
	data = newData;
    }
    
    
}
