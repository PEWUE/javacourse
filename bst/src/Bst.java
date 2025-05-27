public class Bst {
    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    public Node insertRecursive(Node node, int value) {
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
}
