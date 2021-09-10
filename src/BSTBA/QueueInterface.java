package BSTBA;

public interface QueueInterface<T>
{
    void enqueue(T element);
    T dequeue() throws EmptyQueueDequeue;
    boolean isFull();
    boolean isEmpty();
    int size();
}
