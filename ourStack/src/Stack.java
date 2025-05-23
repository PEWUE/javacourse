public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public T pop() {
        if (top == null) {
            System.err.println("Stos jest pusty");
            return null;
        }
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean contains(T value) {
        Node<T> current = top;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean remove(T value) {
        if (top == null) {
            return false;
        }

        if (top.getValue().equals(value)) {
            top = top.getNext();
            size--;
            return true;
        }

        Node<T> current = top;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                current.setNext(current.getNext().getNext());
                size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);

        if (top == null) {
            top = newNode;
        } else {
            Node<T> current = top;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }
}
