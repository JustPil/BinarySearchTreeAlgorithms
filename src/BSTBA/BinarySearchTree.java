package BSTBA;

import java.util.HashMap;
import java.util.HashSet;

public class BinarySearchTree
{
    private Node root;
    private int nodeCount = 0;
    private int[] array;
    private StringBuilder sb;

    /**
     * Constructor creates a new BinarySearchTree and sets the root node to null.
     */
    public BinarySearchTree()
    {
        root = null;
    }

    /**
     * inOrder Performs an inorder traversal algorithm.
     * @return A StringBuilder containing the inorder contents of the BST nodes.
     */
    public StringBuilder inOrder()
    {
        sb = new StringBuilder();
        array = new int[nodeCount];
        if(root == null)
        {
            return sb;
        }
        int index = 0;
        StackInterface<Node> stack = new StackArrayList<>();
        Node node = root;
        while(true)
        {
            if(node != null)
            {
                stack.push(node);
                node = node.getLeft();
            }
            else
            {
                if(stack.isEmpty())
                {
                    break;
                }
                node = stack.peek();
                stack.pop();
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
    public StringBuilder preOrder()
    {
        int index = 0;
        sb = new StringBuilder();
        array = new int[nodeCount];
        if(root == null)
        {
            return sb;
        }
        StackInterface<Node> stack = new StackArrayList<>();
        Node node = root;
        stack.push(node);
        while(!stack.isEmpty())
        {
            node = stack.peek();
            stack.pop();
            sb.append(node.getData());
            array[index++] = node.getData();
            if(node.getRight() != null)
            {
                stack.push(node.getRight());
            }
            if(node.getLeft() != null)
            {
                stack.push(node.getLeft());
            }
        }
        return sb;
    }

    /**
     * postOrder Performs a postorder traversal algorithm.
     * @return A StringBuilder containing the postorder contents of the BST nodes.
     */
    public StringBuilder postOrder()
    {
        sb = new StringBuilder();
        if(root == null)
        {
            return sb;
        }
        int index = 0;
        array = new int[nodeCount];
        StackInterface<Node> stack1 = new StackArrayList<>();
        StackInterface<Node> stack2 = new StackArrayList<>();
        Node node = root;
        stack1.push(node);
        while(!stack1.isEmpty())
        {
            node = stack1.peek();
            stack2.push(stack1.peek());
            stack1.pop();
            if(node.getLeft() != null)
            {
                stack1.push(node.getLeft());
            }
            if(node.getRight() != null)
            {
                stack1.push(node.getRight());
            }
        }
        while(!stack2.isEmpty())
        {
            node = stack2.peek();
            stack2.pop();
            sb.append(node.getData());
            array[index++] = node.getData();
        }
        return sb;
    }

    /**
     * levelOrder Performs a levelorder traversal algorithm.
     * @return A StringBuilder containing the levelorder contents of the BST nodes.
     */
    public StringBuilder levelOrder()
    {
        int index = 0;
        sb = new StringBuilder();
        if(root == null)
        {
            return sb;
        }
        array = new int[nodeCount];
        QueueInterface<Node> queue = new ArrayListQueue<>();
        Node node = root;
        queue.enqueue(node);
        while(!queue.isEmpty())
        {
            node = queue.dequeue();
            sb.append(node.getData());
            array[index++] = node.getData();
            if(node.getLeft() != null)
            {
                queue.enqueue(node.getLeft());
            }
            if(node.getRight() != null)
            {
                queue.enqueue(node.getRight());
            }
        }
        return sb;
    }

    /**
     * boundaryOrder A traversal algorithm following the outside border of the BST in counterclockwise order. Calls
     * separate helper methods for certain boundaries.
     * @return A StringBuilder containing the boundary order contents of the BST.
     */
    public StringBuilder boundaryOrder()
    {
        sb = new StringBuilder();
        if(root == null)
        {
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
    public void leftBoundTraversal(StringBuilder sb)
    {
        if(root.getLeft() == null)
        {
            return;
        }
        Node node = root.getLeft();
        while(node != null)
        {
            if(node.getLeft() != null && node.getRight() != null)
            {
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
    public void leafTraversal(StringBuilder sb)
    {
        StackArrayList<Node> stack = new StackArrayList<>();
        Node node = root;
        while(true)
        {
            if(node != null && node.getLeft() == null && node.getRight() == null)
            {
                sb.append(node.getData());
            }
            if(node != null)
            {
                stack.push(node);
                node = node.getLeft();
            }
            else
            {
                if(stack.isEmpty())
                {
                    break;
                }
                node = stack.peek();
                stack.pop();
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
    public void rightBoundTraversal(StringBuilder sb)
    {
        if(root.getRight() == null)
        {
            return;
        }
        Node node = root.getRight();
        StackArrayList<Node> stack = new StackArrayList<>();
        while(node != null)
        {
            if(node.getRight() != null && node.getLeft() != null)
            {
                stack.push(node);
            }
            node = node.getRight() != null ? node.getRight() : node.getLeft();
        }
        while(!stack.isEmpty())
        {
            sb.append(stack.peek().getData());
            stack.pop();
        }
    }

    /**
     * minNode Finds the node holding the smallest data.
     * @return The data held by the node.
     */
    public int minNode()
    {
        if(isEmpty())
        {
            return 0;
        }
        else
        {
            Node node = root;
            while(node.getLeft() != null)
            {
                node = node.getLeft();
            }
            return node.getData();
        }
    }

    /**
     * maxNode Finds the node holding the largest data.
     * @return The data held by the node.
     */
    public int maxNode()
    {
        if(isEmpty())
        {
            return 0;
        }
        else
        {
            Node node = root;
            while(node.getRight() != null)
            {
                node = node.getRight();
            }
            return node.getData();
        }
    }

    /**
     * isEmpty Reports if the BST is empty.
     * @return Whether the root node is null or not null.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * isFull Reports if the BST is full.
     * @return False, a BST has no set limit.
     */
    public boolean isFull()
    {
        return false;
    }

    /**
     * leafCounter Counts the number of leaf nodes in the BST.
     * @return The sum of leaf Nodes in the BST.
     */
    public int leafCounter()
    {
        int counter = 0;
        if(root == null)
        {
            return counter;
        }
        QueueInterface<Node> queue = new ArrayListQueue<>();
        queue.enqueue(root);
        while(!queue.isEmpty())
        {
            Node node = queue.dequeue();
            if(node.getLeft() == null && node.getRight() == null)
            {
                counter++;
            }
            if(node.getLeft() != null)
            {
                queue.enqueue(node.getLeft());
            }
            if(node.getRight() != null)
            {
                queue.enqueue(node.getRight());
            }
        }
        return counter;
    }

    /**
     * onlyChild Counts the number of nodes that do not have a sibling to a parent node.
     * @return The sum of the nodes that have no sibling.
     */
    public int onlyChild()
    {
        int counter = 0;
        QueueInterface<Node> queue = new ArrayListQueue<>();
        if(root == null)
        {
            return counter;
        }
        queue.enqueue(root);
        while(!queue.isEmpty())
        {
            Node node = queue.dequeue();
            if((node.getLeft() == null && node.getRight() != null) || (node.getLeft() != null && node.getRight() == null))
            {
                counter++;
            }
            if(node.getLeft() == null && node.getRight() != null)
            {
                queue.enqueue(node.getRight());
            }
            if(node.getLeft() != null && node.getRight() == null)
            {
                queue.enqueue(node.getLeft());
            }
            if(node.getRight() != null && node.getLeft() != null)
            {
                queue.enqueue(node.getLeft());
                queue.enqueue(node.getRight());
            }
        }
        return counter;
    }

    /**
     * height Reports the height of the BST.
     * @return The height of the BST.
     */
    public int height()
    {
        int height = 0;
        if(root == null)
        {
            return height;
        }
        QueueInterface<Node> queue = new ArrayListQueue<>();
        Node node = root;
        queue.enqueue(node);
        while(!queue.isEmpty())
        {
            int elemsInQueue = queue.size();
            while(elemsInQueue > 0)
            {
                node = queue.dequeue();
                elemsInQueue--;
                if(node.getLeft() != null)
                {
                    queue.enqueue(node.getLeft());
                }
                if(node.getRight() != null)
                {
                    queue.enqueue(node.getRight());
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
    public int size()
    {
        return nodeCount;
    }

    /**
     * search Searches the BST for a node holding a chosen data value.
     * @param data The data to search for.
     * @return True if the data was found, false otherwise.
     */
    public boolean search(int data)
    {
        QueueInterface<Node> queue = new ArrayListQueue<>();
        queue.enqueue(root);
        while(!queue.isEmpty())
        {
            Node node = queue.dequeue();
            if(node.getData() == data)
            {
                return true;
            }
            else if(node.getLeft() != null && node.getRight() != null)
            {
                queue.enqueue(node.getLeft());
                queue.enqueue(node.getRight());
            }
            else if(node.getLeft() == null && node.getRight() != null)
            {
                queue.enqueue(node.getRight());
            }
            else if(node.getLeft() != null && node.getRight() == null)
            {
                queue.enqueue(node.getLeft());
            }
        }
        return false;
    }

    /**
     * insert Inserts a new node into the BST.
     * @param data The data for the new node to hold.
     * @return True if the insertion was successful, false otherwise.
     */
    public boolean insert(int data)
    {
        if(root == null)
        {
            Node node = new Node(data);
            root = node;
            nodeCount++;
            return true;
        }
        else
        {
            Node node = root;
            while(true)
            {
                if(data <= node.getData() && node.getLeft() != null)
                {
                    node = node.getLeft();
                }
                else if(data > node.getData() && node.getRight() != null)
                {
                    node = node.getRight();
                }
                else if(data <= node.getData() && node.getLeft() == null)
                {
                    node.setLeft(new Node(data));
                    nodeCount++;
                    return true;
                }
                else if(data > node.getData() && node.getRight() == null)
                {
                    node.setRight(new Node(data));
                    nodeCount++;
                    return true;
                }
            }
        }
    }

    /**
     * remove Removes a node from the BST.
     * @param data The data held by the node targeted for removal.
     * @return True if the removal was successful, false otherwise.
     */
    public boolean remove(int data)
    {
        if(isEmpty())
        {
            return false;
        }
        Node node1 = root;
        Node node2 = node1;
        if(root.getData() == data)
        {
            if(root.getLeft() != null)
            {
                node1 = node1.getLeft();
                while (node1.getRight() != null)
                {
                    node2 = node1;
                    node1 = node1.getRight();
                }
                root.setData(node1.getData());
                node2.setRight(null);
                nodeCount--;
                return true;
            }
            else if(root.getRight() != null)
            {
                setRoot(root.getRight());
                nodeCount--;
                return true;
            }
            else
            {
                root = null;
                nodeCount--;
                return true;
            }
        }
        while(true)
        {
            if(node1.getData() > data)
            {
                node2 = node1;
                node1 = node1.getLeft();
            }
            else if(node1.getData() < data)
            {
                node2 = node1;
                node1 = node1.getRight();
            }
            else
            {
                if(node1.getRight() == null && node1.getLeft() == null && node2.getRight() == node1)
                {
                    node2.setRight(null);
                }
                else if(node1.getRight() == null && node1.getLeft() == null && node2.getLeft() == node1)
                {
                    node2.setLeft(null);
                }
                else if(node1.getRight() == null && node1.getLeft() != null && node2.getRight() == node1)
                {
                    node2.setRight(node1.getLeft());
                }
                else if(node1.getRight() == null && node1.getLeft() != null && node2.getLeft() == node1)
                {
                    node2.setLeft(node1.getLeft());
                }
                else if(node1.getRight() != null && node1.getLeft() == null && node2.getRight() == node1)
                {
                    node2.setRight(node1.getRight());
                }
                else if(node1.getRight() != null && node1.getLeft() == null && node2.getLeft() == node1)
                {
                    node2.setLeft(node1.getRight());
                }
                else
                {
                    Node replace = replacement(node1);
                    node1.setData(replace.getData());
                }
                nodeCount--;
                return true;
            }
        }
    }

    /**
     * replacement Finds the replacement node to replace a node targeted for removal. The replacement node is copied for
     * a return value and removed from the BST.
     * @param n The node intended for removal.
     * @return The replacement node.
     */
    private Node replacement(Node n)
    {
        Node replace = n;
        Node deleter = replace;
        if(n.getLeft() != null)
        {
            deleter = replace;
            replace = replace.getLeft();
        }
        while(replace.getRight() != null)
        {
            deleter = replace;
            replace = replace.getRight();
        }
        Node copy = replace;
        deleter.setRight(null);
        return copy;
    }

    /**
     * balance Balances the BST using a recursive balancing algorithm. An array containing the inorder values of the
     * nodes is used to continually insert the middle index as a parent node through recursion and manipulation of the
     * start and end indexes until all elements have been inserted.
     * @param start The start index of the array.
     * @param end The end index of the array.
     * @return The node of the new BST to assign to the root node.
     */
    public Node balance(int start, int end)
    {
        if(start > end)
        {
            return null;
        }
        inOrder();
        int mid = (start + end) / 2;
        Node node = new Node(array[mid]);
        node.setLeft(balance(start, mid - 1));
        node.setRight(balance(mid + 1, end));
        return node;
    }

    /**
     * setRoot sets the root node to a new BST node.
     * @param n The new BST node for root to access.
     */
    public void setRoot(Node n)
    {
        root = n;
    }

    /**
     *  fullnessRatio Calculates the ratio between the BST's minimum, or balanced, height and the BST's current height.
     * @return The ratio between the minimum and current height of the BST.
     */
    public double fullnessRatio()
    {
        double fullness = 0.0;
        if(root == null)
        {
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
    public int optimalHeight()
    {
        Node storage = root;
        root = balance(0, size() - 1);
        int optimalHeight = height();
        root = storage;
        return optimalHeight;
    }
}
