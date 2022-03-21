public class BST {
	private Node root; // The root node of the tree.

	public BST() {
		root = null;
	}

	/**
		Inserts a time, along with the req_id. The tree is keyed on time, while req_id provides a pointer to the request.
		This is a public wrapper function that calls the recursive insert method.
		Note that the insert method should return the root node of the subtree in which we insert the key (and its value).
	**/
	public void insert(int time, int req_index) {
		// TODO: Code for insert here.
		root = insert(root, time, req_index);
	}

	private Node insert(Node T, int time, int req_index) {

		if (T == null) {
			return new Node (time, req_index);
		}
		if (time < T.getTime()) {
			T.setLeft(insert(T.getRight(), time, req_index));
		}
		else {
			T.setRight(insert(T.getRight(), time, req_index));
		}
		return T;
	}

	/**
		Returns a pointer to the Node that is the predecessor of time. The predecessor element is the largest
		element within the tree that is smaller or equal to time. This is the deepest ancestor with this property.
		Please return the predecessor element. You may return null if time does not have a predecessor.
	**/
	public Node pred(int time) {
		// TODO: code for pred here.
		
		Node r = root;
		Node x = null;
		while(r != null) {
			int rx = r.getTime();
			if (rx <= time) {
				x = r;
				r = r.getRight();
			}
			else {
				r = r.getLeft();
			}
		}
		return x; // Replace this line with returning the actual predecessor.
	}

	/**
		Returns a pointer to the Node that is the successor of time. The successor element is the largest
		element within the tree that is larger or equal to time. This is the deepest ancestor with this property.
		Please return the successor element. You may return null if time does not have a successor.
	**/
	public Node succ(int time) {
		// TODO: code for succ here.
		Node r = root;
		Node x = null;
		while(r != null) {
			int rx = r.getTime();
			if (rx >= time) {
				x = r;
				r = r.getLeft();
			}
			else {
				r = r.getRight();
			}
		}
		return x; // Replace this line with returning the actual successor.
	}

	/**
		Returns the minimum element in the binary search tree or null if the tree is empty.
	**/
	public Node min() {
		// TODO: Code for min here.
		Node r = root;
		
		if (r == null) {
			return null;
		}
		while (r.getLeft() != null) {
			r = r.getLeft();
		}
		return r; // Replace this line with returning the actual minimum.
	}

	/**
		Returns the maximum element in the binary search tree or null if the tree is empty.
	**/
	public Node max() {
		// TODO: Code for max here.
		Node r = root;
		
		if (r == null) {
			return null;
		}
		while (r.getRight() != null) {
			r = r.getRight();
		}
		return r; // Replace this line with returning the actual maximum.
	}

	/**
		Remove the node that contains this time. If this time is not present in the structure, this method does nothing.
	**/
	public void delete(int time) {
		// TODO: Code for delete here.
		root = delete(root, time);
	}

	private Node delete(Node x, int time) {
		if (x == null) return null;

		if (x.getTime() == time) {
			if (x.getLeft() == null && x.getRight() == null) {
				return null;
			}
			if (x.getLeft() == null || x.getRight() == null) {
				return (x.getLeft() == null) ? x.getRight() : x.getLeft();
			}
			
			Node s = succ(x.getTime());
			x.setTime(s.getTime());
			x.setReq_index(s.getReq_index());
			x.setRight(delete(x.getRight(), s.getTime()));
			
			return x;
		}
		if (time < x.getTime()) {
			x.setLeft(delete(x.getLeft(), time));
		}
		else {
			x.setRight(delete(x.getRight(), time));
		}
		return x;
	}
	
	/**
		Prints the contents of the tree in sorted order.
	**/
	public void print() {
		// TODO: Code for print here.
		print(root);
	}

	private void print(Node x) {
		if (x == null) {
			return;
		}	
		print(x.getLeft());
		System.out.println(x);
		print(x.getRight());
	}
}
