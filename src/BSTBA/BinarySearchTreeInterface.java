package BSTBA;

public interface BinarySearchTreeInterface<T> {
    T minNode();
    T maxNode();
    boolean isFull();
    boolean isEmpty();
    int height();
    int size();
    boolean search(T data);
    boolean insert(T data);
    boolean remove(T data);
    void balance();
}
