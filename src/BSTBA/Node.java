package BSTBA;

public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    /**
     * Constructor sets a node's data to the value passed in, and the right left references to null.
     * @param d The data for the node to hold.
     */
    public Node(T d) {
        data = d;
        left = right = null;
    }

    /**
     * setData Sets the node's data to the value passed in.
     * @param d the data to be held by the node.
     */
    public void setData(T d) {
        data = d;
    }

    /**
     * getData Returns the data held by the node.
     * @return The data held by the node.
     */
    public T getData() {
        return data;
    }

    /**
     * setLeft Sets the left node reference to the node passed in.
     * @param l The node to be set as the left reference.
     */
    public void setLeft(Node<T> l) {
        left = l;
    }

    /**
     * setRight Sets the right node reference to the node passed in.
     * @param r The node to be set as the right reference.
     */
    public void setRight(Node<T> r) {
        right = r;
    }

    /**
     * getLeft Returns the left node reference.
     * @return The left node referenced.
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * getRight Returns the right node reference.
     * @return The right node referenced.
     */
    public Node<T> getRight() {
        return right;
    }
}
