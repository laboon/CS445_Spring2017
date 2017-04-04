import java.lang.Math;

public class BSTTraverseDemo {

    /**
     * Given a SimpleBST, traverse in the following
     * manners:
     *   1. Pre-Order
     *   2. In-Order
     *   3. Post-Order
     * @param b A simple BST
     */
    
    public static void traverseDemo(SimpleBST b) {
	System.out.println("Pre-order:");
	b.preOrderTraverse();
	System.out.println("In-order:");
	b.inOrderTraverse();
	System.out.println("Post-order:");
	b.postOrderTraverse();
    }
    
    /**
     * Program execution starts here
     * Go through several BSTs and traverse in three
     * different ways: pre-order, in-order, post-order
     * @param command-line arguments (ignored)
     */
    
    public static void main(String[] args) {

	// Create a BST with one node, and traverse
	// BST:         5
	SimpleBST b1 = new SimpleBST();
	b1.setRoot(new BSTNode(5));

	System.out.println("\n\nb1:");
	traverseDemo(b1);
	
	// Create a BST with two child nodes, and traverse.
	// BST:                    5
	//                        / \
	//                       3   9
	SimpleBST b2 = new SimpleBST();
	b2.setRoot(new BSTNode(5));
	b2.root.left = new BSTNode(3);
	b2.root.right = new BSTNode(9);

	System.out.println("\n\nb2:");
	traverseDemo(b2);

	// Create a degenerate BST, with the same number of nodes
	// as before, but not a full tree, all left child nodes.
	// BST:                      5
	//                          / 
	//                         3
	//                        /
	//                       1
	SimpleBST b3 = new SimpleBST();
	b3.setRoot(new BSTNode(5));
	b3.root.left = new BSTNode(3);
	b3.root.left.left = new BSTNode(1);

	System.out.println("\n\nvb3:");
	traverseDemo(b3);
	
	// Create a larger BST, with diff number of child nodes
	// BST:                      5
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
	
	System.out.println("\n\nb4:");
	traverseDemo(b4);

	
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
     * Return a copy of this tree.
     * Simply involves making a copy of the root node!
     * Recursion takes care of the rest
     * @return SimpleBST - copy of this BST
     */

    public SimpleBST copy() {
	
	// If null, just return null
	// Otherwise, get a copy of the root node
	// That will also get copies of all its children
	
	if (root == null) {
	    return null;
	} else {
	    // Create a new tree and a copy of the root
	    // node, then set the root node of the new
	    // tree to be the copy of the original root node

	    SimpleBST toReturn = new SimpleBST();
	    BSTNode newRoot = root.copy();
	    toReturn.setRoot(newRoot);
	    return toReturn;
	}
    }

    /**
     * Traverse this tree using PRE-ORDER TRAVERSAL
     */
    
    public void preOrderTraverse() {
	root.preOrder();
    }

    /**
     * Traverse this tree using IN-ORDER TRAVERSAL
     */

    
    public void inOrderTraverse() {
	root.inOrder();
    }

    /**
     * Traverse this tree using POST-ORDER TRAVERSAL
     */

    public void postOrderTraverse() {
	root.postOrder();
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
     * Traverse tree in pre-order
     * NOTE: Recursive method
     * Base case: L and R are null (this is a leaf node)
     * Recursive cases: L or R are not null (this is an interior node)
     * SIDE EFFECT: Prints out data to console
     */

    public void preOrder() {
	// FIRST print out data
	System.out.println(data);
	// THEN traverse left
	if (left != null) {
	    left.preOrder();
	}
	// FINALLY traverse right 
	if (right != null) {
	    right.preOrder();
	}
    }

    /**
     * Traverse tree in-order
     * NOTE: Recursive method
     * Base case: L and R are null (this is a leaf node)
     * Recursive cases: L or R are not null (this is an interior node)
     * SIDE EFFECT: Prints out data to console
     */

    public void inOrder() {
	// FIRST traverse left
	if (left != null) {
	    left.inOrder();
	}
	// THEN print out data
	System.out.println(data);
	// FINALLY traverse right
	if (right != null) {
	    right.inOrder();
	}
    }

    /**
     * Traverse tree in post-order
     * NOTE: Recursive method
     * Base case: L and R are null (this is a leaf node)
     * Recursive cases: L or R are not null (this is an interior node)
     * SIDE EFFECT: Prints out data to console
     */
    
    public void postOrder() {
	// FIRST traverse left
	if (left != null) {
	    left.postOrder();
	}
	// THEN traverse right
	if (right != null) {
	    right.postOrder();
	}
	// FINALLY print out data
	System.out.println(data);

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

    /**
     * Create a copy of this tree/subtree
     * Note this is recursive!
     * Base case - both left and right are null (ie node is a leaf)
     * Recursive case - either L or R exist as child nodes (ie node is interior)
     * @return BSTNode copy of this node and its child nodes
     */

    public BSTNode copy() {
	// Make a copy of ourself
	BSTNode newNode = new BSTNode(data);

	// If our current left is null, ignore it, keep it
	// null (as Tolstoy put it in Anna Karenina,
	// "All nulls are alike; every non-null object exists in its own way."
	// Otherwise, recurse into the left node and make copies
	if (left != null) {
		newNode.left = left.copy();
	}

	// Do the same to the right as we did with the left
	if (right != null) {
	    newNode.right = right.copy();
	}
	return newNode;

    }
    

}
