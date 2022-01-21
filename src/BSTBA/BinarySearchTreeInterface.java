package BSTBA;

public interface BinarySearchTreeInterface
{
    StringBuilder inOrder();
    StringBuilder preOrder();
    StringBuilder postOrder();
    StringBuilder levelOrder();
    int minNode();
    int maxNode();
    boolean isFull();
    boolean isEmpty();
    int leafCounter();
    int onlyChild();
    int height();
    int size();
    boolean search(int data);
    boolean insert(int data);
    boolean remove(int data);
    Node replacement(Node n);
    Node balance(int start, int end);
    void setRoot(Node n);
    double fullnessRatio();
    int optimalHeight();
}
