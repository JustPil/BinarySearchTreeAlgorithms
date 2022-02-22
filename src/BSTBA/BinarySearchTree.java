package BSTBA;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T> implements BinarySearchTreeInterface<T> {
    private Node<T> root;
    private int nodeCount = 0;
    private T[] array;
    private StringBuilder sb;
    private Comparator<T> comp;

    /**
     * Constructor creates a new BinarySearchTree and sets the root node to null.
     */
    public BinarySearchTree() {
        root = null;
        comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
    }

    /**
     * inOrder Performs an inorder traversal algorithm.
     * @return A StringBuilder containing the inorder contents of the BST nodes.
     */
    public StringBuilder inOrder() {
        sb = new StringBuilder();
        array = (T[])new Object[nodeCount];
        if(root == null) {
            return sb;
        }
        int index = 0;
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node = root;
        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                if(stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                sb.append(node.getData());
                array[index++] = node.getData();
                node = node.getRight();
            }
        }
        return sb;
    }

    /**
     * preOrder Performs a preorder traversal algorithm.
     * @return A StringBuilder containing the preorder contents of the BST nodes.
     */
    public StringBuilder preOrder() {
        int index = 0;
        sb = new StringBuilder();
        array = (T[])new Object[nodeCount];
        if(root == null) {
            return sb;
        }
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node = root;
        stack.push(node);
        while(!stack.isEmpty()) {
            node = stack.pop();
            sb.append(node.getData());
            array[index++] = node.getData();
            if(node.getRight() != null) {
                stack.push(node.getRight());
            }
            if(node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
        return sb;
    }

    /**
     * postOrder Performs a postorder traversal algorithm.
     * @return A StringBuilder containing the postorder contents of the BST nodes.
     */
    public StringBuilder postOrder() {
        sb = new StringBuilder();
        if(root == null) {
            return sb;
        }
        int index = 0;
        array = (T[])new Object[nodeCount];
        Stack<Node<T>> stack1 = new Stack<>();
        Stack<Node<T>> stack2 = new Stack<>();
        Node<T> node = root;
        stack1.push(node);
        while(!stack1.isEmpty()) {
            node = stack1.peek();
            stack2.push(stack1.pop());
            if(node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if(node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }
        while(!stack2.isEmpty()) {
            node = stack2.pop();
            sb.append(node.getData());
            array[index++] = node.getData();
        }
        return sb;
    }

    /**
     * levelOrder Performs a levelorder traversal algorithm.
     * @return A StringBuilder containing the levelorder contents of the BST nodes.
     */
    public StringBuilder levelOrder() {
        int index = 0;
        sb = new StringBuilder();
        if(root == null) {
            return sb;
        }
        array = (T[])new Object[nodeCount];
        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> node = root;
        queue.add(node);
        while(!queue.isEmpty()) {
            node = queue.remove();
            sb.append(node.getData());
            array[index++] = node.getData();
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return sb;
    }

    /**
     * boundaryOrder A traversal algorithm following the outside border of the BST in counterclockwise order. Calls
     * separate helper methods for certain boundaries.
     * @return A StringBuilder containing the boundary order contents of the BST.
     */
    public StringBuilder boundaryOrder() {
        sb = new StringBuilder();
        if(root == null) {
            return sb;
        }
        sb.append(root.getData());
        leftBoundTraversal(sb);
        leafTraversal(sb);
        rightBoundTraversal(sb);
        return sb;
    }

    /**
     * leftBoundaryTraversal Traverses the left boundary of the BST starting at the node left of root and ending before
     * the first leaf node of the leftmost path.
     * @param sb A StringBuilder containing the left boundary contents of the BST.
     */
    private void leftBoundTraversal(StringBuilder sb) {
        if(root.getLeft() == null) {
            return;
        }
        Node<T> node = root.getLeft();
        while(node != null) {
            if(node.getLeft() != null && node.getRight() != null) {
                sb.append(node.getData());
            }
            node = node.getLeft() != null ? node.getLeft() : node.getRight();
        }
    }

    /**
     * leafTraversal Traverses the BST from left to right for the purposes of recording all leaf nodes in order, the
     * 'bottom boundary' of the BST.
     * @param sb A StringBuilder containing the leaf boundary contents of the BST.
     */
    private void leafTraversal(StringBuilder sb)
    {
        Stack<Node<T>> stack = new Stack<>();
        Node<T> node = root;
        while(true) {
            if(node != null && node.getLeft() == null && node.getRight() == null) {
                sb.append(node.getData());
            }
            if(node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                if(stack.isEmpty()) {
                    break;
                }
                node = stack.pop();
                node = node.getRight();
            }
        }
    }

    /**
     * rightBoundTraversal Traverses the right boundary of the BST starting at the node right of root and ending before
     * the first leaf node of the rightmost path. To keep the ordering counterclockwise a Stack is used to reverse the
     * traversal ordering when appending to the StringBuilder.
     * @param sb A StringBuilder containing the right boundary contents of the BST.
     */
    private void rightBoundTraversal(StringBuilder sb) {
        if(root.getRight() == null) {
            return;
        }
        Node<T> node = root.getRight();
        Stack<Node<T>> stack = new Stack<>();
        while(node != null) {
            if(node.getRight() != null && node.getLeft() != null) {
                stack.push(node);
            }
            node = node.getRight() != null ? node.getRight() : node.getLeft();
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop().getData());
        }
    }

    /**
     * minNode Finds the node holding the smallest data.
     * @return The data held by the node.
     */
    public T minNode() {
        if(isEmpty()) {
            return null;
        } else {
            Node<T> node = root;
            while(node.getLeft() != null) {
                node = node.getLeft();
            }
            return node.getData();
        }
    }

    /**
     * maxNode Finds the node holding the largest data.
     * @return The data held by the node.
     */
    public T maxNode() {
        if(isEmpty()) {
            return null;
        } else {
            Node<T> node = root;
            while(node.getRight() != null) {
                node = node.getRight();
            }
            return node.getData();
        }
    }

    /**
     * isEmpty Reports if the BST is empty.
     * @return Whether the root node is null or not null.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * isFull Reports if the BST is full.
     * @return False, a BST has no set limit.
     */
    public boolean isFull() {
        return false;
    }

    /**
     * leafCounter Counts the number of leaf nodes in the BST.
     * @return The sum of leaf Nodes in the BST.
     */
    public int leafCounter() {
        int counter = 0;
        if(root == null) {
            return counter;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node<T> node = queue.remove();
            if(node.getLeft() == null && node.getRight() == null) {
                counter++;
            }
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return counter;
    }

    /**
     * onlyChild Counts the number of nodes that do not have a sibling to a parent node.
     * @return The sum of the nodes that have no sibling.
     */
    public int onlyChild() {
        int counter = 0;
        Queue<Node<T>> queue = new LinkedList<>();
        if(root == null) {
            return counter;
        }
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node<T> node = queue.remove();
            if((node.getLeft() == null && node.getRight() != null) || (node.getLeft() != null &&
                    node.getRight() == null)) {
                counter++;
            }
            if(node.getLeft() == null && node.getRight() != null) {
                queue.add(node.getRight());
            }
            if(node.getLeft() != null && node.getRight() == null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null && node.getLeft() != null) {
                queue.add(node.getLeft());
                queue.add(node.getRight());
            }
        }
        return counter;
    }

    /**
     * height Reports the height of the BST.
     * @return The height of the BST.
     */
    public int height() {
        int height = 0;
        if(root == null) {
            return height;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> node = root;
        queue.add(node);
        while(!queue.isEmpty()) {
            int elemsInQueue = queue.size();
            while(elemsInQueue > 0) {
                node = queue.remove();
                elemsInQueue--;
                if(node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if(node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            height++;
        }
        return height;
    }

    /**
     * size Reports the total nodes in the BST.
     * @return The count of all nodes in the BST.
     */
    public int size() {
        return nodeCount;
    }

    /**
     * search Searches the BST for a node holding a chosen data value.
     * @param data The data to search for.
     * @return True if the data was found, false otherwise.
     */
    public boolean search(T data) {
        if(root == null) {
            return false;
        }
        Node<T> node = root;
        while(node != null) {
            if(comp.compare(data, node.getData()) == 0) {
                return true;
            } else if(comp.compare(data, node.getData()) < 0) {
                node = node.getLeft();
            } else if(comp.compare(data, node.getData()) > 0) {
                node = node.getRight();
            }
        }
        return false;
    }

    /**
     * insert Inserts a new node into the BST.
     * @param data The data for the new node to hold.
     * @return True if the insertion was successful, false otherwise.
     */
    public boolean insert(T data) {
        if(root == null) {
            Node<T> node = new Node<>(data);
            root = node;
            nodeCount++;
            return true;
        }
        Node<T> node = root;
        while(true) {
            if(comp.compare(data, node.getData()) <= 0 && node.getLeft() != null) {
                node = node.getLeft();
            } else if(comp.compare(data, node.getData()) > 0 && node.getRight() != null) {
                node = node.getRight();
            } else if(comp.compare(data, node.getData()) <= 0 && node.getLeft() == null) {
                node.setLeft(new Node<>(data));
                nodeCount++;
                return true;
            } else if(comp.compare(data, node.getData()) > 0 && node.getRight() == null) {
                node.setRight(new Node<>(data));
                nodeCount++;
                return true;
            }
        }
    }

    /**
     * remove Removes a node from the BST.
     * @param data The data held by the node targeted for removal.
     * @return True if the removal was successful, false otherwise.
     */
    public boolean remove(T data) {
        if(isEmpty()) {
            return false;
        }
        Node<T> node1 = root;
        Node<T> node2 = node1;
        if(root.getData().equals(data)) {
            if(root.getLeft() != null && root.getRight() == null) {
                root = root.getLeft();
                nodeCount--;
                return true;
            }
            else if(root.getLeft() != null) {
                node1 = node1.getLeft();
                while (node1.getRight() != null) {
                    node2 = node1;
                    node1 = node1.getRight();
                }
                root.setData(node1.getData());
                node2.setRight(null);
                nodeCount--;
                return true;
            } else if(root.getRight() != null) {
                root = root.getRight();
                nodeCount--;
                return true;
            } else {
                root = null;
                nodeCount--;
                return true;
            }
        }
        while(true) {
            if(comp.compare(node1.getData(), data) > 0) {
                node2 = node1;
                node1 = node1.getLeft();
            } else if(comp.compare(node1.getData(), data) < 0) {
                node2 = node1;
                node1 = node1.getRight();
            } else if(comp.compare(node1.getData(), data) == 0) {
                if(node1.getRight() == null && node1.getLeft() == null && node2.getRight() == node1) {
                    node2.setRight(null);
                } else if(node1.getRight() == null && node1.getLeft() == null && node2.getLeft() == node1) {
                    node2.setLeft(null);
                } else if(node1.getRight() == null && node1.getLeft() != null && node2.getRight() == node1) {
                    node2.setRight(node1.getLeft());
                } else if(node1.getRight() == null && node1.getLeft() != null && node2.getLeft() == node1) {
                    node2.setLeft(node1.getLeft());
                } else if(node1.getRight() != null && node1.getLeft() == null && node2.getRight() == node1) {
                    node2.setRight(node1.getRight());
                } else if(node1.getRight() != null && node1.getLeft() == null && node2.getLeft() == node1) {
                    node2.setLeft(node1.getRight());
                } else {
                    Node<T> replace = replacement(node1);
                    node1.setData(replace.getData());
                }
                nodeCount--;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * replacement Finds the replacement node to replace a node targeted for removal. The replacement node is copied for
     * a return value and removed from the BST.
     * @param n The node intended for removal.
     * @return The replacement node.
     */
    private Node<T> replacement(Node<T> n) {
        Node<T> replace = n;
        Node<T> deleter = replace;
        if(n.getLeft() != null) {
            deleter = replace;
            replace = replace.getLeft();
        }
        while(replace.getRight() != null) {
            deleter = replace;
            replace = replace.getRight();
        }
        Node<T> copy = replace;
        deleter.setRight(null);
        return copy;
    }

    /**
     * balance Balances the BST using an iterative balancing algorithm requiring a Stack for nodes and a Stack for the
     * start and end array indices with respect to the node's middle position in the array. The start and end indices
     * change as the new BST is built.
     */
    public void balance() {
        if(nodeCount <= 1) {
            return;
        }
        inOrder();
        Stack<Node<T>> nodeStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push((array.length) - 1);
        indexStack.push(0);
        Node<T> balancedRoot = new Node<>(null);
        nodeStack.push(balancedRoot);
        while(!nodeStack.isEmpty()) {
            Node<T> parsingNode = nodeStack.pop();
            int start = indexStack.pop();
            int end = indexStack.pop();
            int mid = start + (end - start) / 2;
            parsingNode.setData(array[mid]);
            if(start < mid) {
                Node<T> node = new Node<>(array[start]);
                parsingNode.setLeft(node);
                nodeStack.push(node);
                indexStack.push(mid - 1);
                indexStack.push(start);
            }
            if(end > mid) {
                Node<T> node = new Node<>(array[end]);
                parsingNode.setRight(node);
                nodeStack.push(node);
                indexStack.push(end);
                indexStack.push(mid + 1);
            }
        }
        root = balancedRoot;
    }

    /**
     *  fullnessRatio Calculates the ratio between the BST's minimum, or balanced, height and the BST's current height.
     * @return The ratio between the minimum and current height of the BST.
     */
    public double fullnessRatio() {
        double fullness = 0.0;
        if(root == null) {
            return fullness;
        }
        double initialHeight = height();
        double balanceHeight = optimalHeight();
        return initialHeight / balanceHeight;
    }

    /**
     * optimalHeight Calculates the optimal, or balanced, height of the BST.
     * @return The optimal height of the BST.
     */
    public int optimalHeight() {
        Node<T> storage = root;
        balance();
        int optimalHeight = height();
        root = storage;
        return optimalHeight;
    }
}
