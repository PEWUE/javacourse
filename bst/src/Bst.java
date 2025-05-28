public class Bst {
    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.getValue()) {
            node.setLeft(insertRecursive(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insertRecursive(node.getRight(), value));
        }
        return node;
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node node, int value) {
        if (node == null) {
            return false;
        }

        if (node.getValue() == value) {
            return true;
        }

        return value < node.getValue() ?
                containsRecursive(node.getLeft(), value) :
                containsRecursive(node.getRight(), value);
    }

    public void traversal() {
        traversalRecursive(root);
    }

    private void traversalRecursive(Node node) {
        if (node != null) {
            traversalRecursive(node.getLeft());
            System.out.print(node.getValue() + " ");
            traversalRecursive(node.getRight());
        }
    }
}
