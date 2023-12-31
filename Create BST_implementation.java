public class binaryst {

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}

	Node root;

	binaryst() { root = null; }

	binaryst(int value) { root = new Node(value); }

	void insert(int key) { root = insertRec(root, key); }

	Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		} else if (key < root.key)
			root.left = insertRec(root.left, key);
		else if (key > root.key)
			root.right = insertRec(root.right, key);

		return root;
	}
    Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        if (root.key > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }

        if (root.left == null) {
            Node temp = root.right;
            return temp;
        } else if (root.right == null) {
            Node temp = root.left;
            return temp;
        } else {
            Node succParent = root;
            Node succ = root.right;

            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }

            if (succParent != root)
                succParent.left = succ.right;
            else
                succParent.right = succ.right;

            root.key = succ.key;
            return root;
        }
    }

	void inorder() { inorderRec(root); }

	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.key + " ");
			inorderRec(root.right);
		}
	}

	public static void main(String[] args) {
		binaryst tree = new binaryst();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
        tree.inorder();
        tree.root = tree.deleteNode(tree.root, 20);
        tree.root = tree.deleteNode(tree.root, 70);
        tree.root = tree.deleteNode(tree.root, 80);
		tree.inorder();
	}
}
