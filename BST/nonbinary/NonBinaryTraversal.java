import java.lang.Math;
import java.util.ArrayList;

public class NonBinaryTraversal {

    /**
     * Given a , traverse in the following
     * manners:
     *   1. Pre-Order
     *   2. Post-Order
     * @param b A s
     */
    
    public static void traverseDemo(SimpleNTree b) {
	System.out.println("Pre-order:");
	b.preOrderTraverse();
	System.out.println("Post-order:");
	b.postOrderTraverse();
    }
    
    /**
     * Program execution starts here
     * Go through several N-trees and traverse in two
     * different ways: pre-order, post-order
     * @param command-line arguments (ignored)
     */
    
    public static void main(String[] args) {

	// Create an N-tree with one node, and traverse
	// Tree:         5
	SimpleNTree b1 = new SimpleNTree();
	b1.setRoot(new NTreeNode(5));

	System.out.println("\n\nb1:");
	traverseDemo(b1);
	
	// Create an N-Tree with two child nodes, and traverse.
	// Tree:                   5
	//                        / \
	//                       3   9
	SimpleNTree b2 = new SimpleNTree();
	b2.setRoot(new NTreeNode(5));
	b2.root.addChild(new NTreeNode(3));
	b2.root.addChild(new NTreeNode(9));

	System.out.println("\n\nb2:");
	traverseDemo(b2);

	// Create a degenerate N-Tree, with the same number of nodes
	// as before, but not a full tree, all left child nodes.
	// N-Tree:                   5
	//                          / 
	//                         3
	//                        /
	//                       1
	SimpleNTree b3 = new SimpleNTree();
	b3.setRoot(new NTreeNode(5));
	b3.root.addChild(new NTreeNode(3));
	b3.root.getChild(0).addChild(new NTreeNode(1));

	System.out.println("\n\nvb3:");
	traverseDemo(b3);
	
	// Create one root node with lots of children
	// N-Tree:                   +---5---+
	//                          /|\     /|\
	//                         3 6 7   8 4 1
	SimpleNTree b4 = new SimpleNTree();
	b4.setRoot(new NTreeNode(5));
	b4.root.addChild(new NTreeNode(3));
	b4.root.addChild(new NTreeNode(6));
	b4.root.addChild(new NTreeNode(7));
	b4.root.addChild(new NTreeNode(8));
	b4.root.addChild(new NTreeNode(4));
	b4.root.addChild(new NTreeNode(1));
	
	System.out.println("\n\nb4:");
	traverseDemo(b4);

	// Create a complex N-tree
	// N-Tree:                   +---5---+
	//                          /|\     /|\
	//                         3 6 7   8 4 1
	//                        /|           |
	//                       2 9_          12
	//                        /| \
	//                       0 10 11
	SimpleNTree b5 = new SimpleNTree();
	b5.setRoot(new NTreeNode(5));
	b5.root.addChild(new NTreeNode(3));
	b5.root.addChild(new NTreeNode(6));
	b5.root.addChild(new NTreeNode(7));
	b5.root.addChild(new NTreeNode(8));
	b5.root.addChild(new NTreeNode(4));
	b5.root.addChild(new NTreeNode(1));
	b5.root.getChild(0).addChild(new NTreeNode(2));
	b5.root.getChild(0).addChild(new NTreeNode(9));
	b5.root.getChild(0).getChild(1).addChild(new NTreeNode(0));
	b5.root.getChild(0).getChild(1).addChild(new NTreeNode(10));
	b5.root.getChild(0).getChild(1).addChild(new NTreeNode(11));
	b5.root.getChild(5).addChild(new NTreeNode(12));
	
	
	System.out.println("\n\nb5:");
	traverseDemo(b5);
	
	
    }
    
}

/**
 * A simple int N-child tree
 * Note that search parts aren't actually implemented here,
 * nor are any restrictions, for simplicity.
 */

class SimpleNTree {

    /**
     * The root of this tree
     */
    
    public NTreeNode root = null;

    /**
     * Return a copy of this tree.
     * Simply involves making a copy of the root node!
     * Recursion takes care of the rest
     * @return SimpleNTree - copy of this N-Tree
     */

    public SimpleNTree copy() {
	
	// If null, just return null
	// Otherwise, get a copy of the root node
	// That will also get copies of all its children
	
	if (root == null) {
	    return null;
	} else {
	    // Create a new tree and a copy of the root
	    // node, then set the root node of the new
	    // tree to be the copy of the original root node

	    SimpleNTree toReturn = new SimpleNTree();
	    NTreeNode newRoot = root.copy();
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
     * Traverse this tree using POST-ORDER TRAVERSAL
     */

    public void postOrderTraverse() {
	root.postOrder();
    }

    
    /**
     * Set the root of this tree
     * @param newRoot - the new root of this tree
     */
    
    public void setRoot(NTreeNode newRoot) {
	root = newRoot;
    }

}

/**
 * A single node in the N-Tree
 * Consists of data and references to children
 * nodes (null if nonexistent)
 */

class NTreeNode {

    /**
     * Data stored in this node
     */
    
    public int data;

    public ArrayList<NTreeNode> children = new ArrayList<NTreeNode>();
    
    /**
     * Constructor.  A new NTreeNode MUST have data in it.
     * @param int data for this node
     */

    public NTreeNode(int newData) {
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
     * Base case: no child exists (this is a leaf node)
     * Recursive cases: some child exists (this is an interior node)
     * SIDE EFFECT: Prints out data to console
     */

    public void preOrder() {
	// FIRST print out data
	System.out.println(data);
	// THEN traverse child nodes
	for (NTreeNode node : children) {
	    node.preOrder();
	}
    }

    /**
     * Traverse tree in post-order
     * NOTE: Recursive method
     * Base case: no child exists (this is a leaf node)
     * Recursive cases: some child exists (this is an interior node)
     * SIDE EFFECT: Prints out data to console
     */
    
    public void postOrder() {
	// FIRST traverse child nodes
	// THEN print out data
	for (NTreeNode node : children) {
	    node.preOrder();
	}

	System.out.println(data);

    }

    /**
     * Add child node to this node.
     * @param NTreeNode - child node to add
     */
    
    public void addChild(NTreeNode node) {
	children.add(node);
    }

    /**
     * Get child #n from this node
     * n is indexed starting at 0 (1st element = element 0)
     * @param n index of child node
     * @return NTreeNode - child node at that index
     */

    public NTreeNode getChild(int n) {
	return children.get(n);
    }

    
    /**
     * Create a copy of this tree/subtree
     * Note this is recursive!
     * Base case - all children are null (ie node is a leaf)
     * Recursive case - some child node exists (ie node is interior)
     * @return NTreeNode copy of this node and its child nodes
     */

    public NTreeNode copy() {
	// Make a copy of ourself
	NTreeNode newNode = new NTreeNode(data);

	for (NTreeNode node : children) {
	    newNode.addChild(node.copy());
	}
	
	return newNode;

    }
    

}
