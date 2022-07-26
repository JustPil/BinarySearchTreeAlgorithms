package trees;

public interface BinarySearchTreeInterface<T> {
    boolean search(T data);
    boolean insert(T data);
    boolean remove(T data);
    int size();
    boolean isFull();
    boolean isEmpty();
}
