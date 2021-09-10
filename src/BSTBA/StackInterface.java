package BSTBA;

public interface StackInterface<T>
{
    boolean isEmpty();
    boolean isFull();
    void pop();
    void push(T t);
    T peek();
    void clear();
    String toString();
    void swapStart();
}
