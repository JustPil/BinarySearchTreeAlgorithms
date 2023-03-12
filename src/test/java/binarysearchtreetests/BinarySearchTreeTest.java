package binarysearchtreetests;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import trees.BinarySearchTree;

public class BinarySearchTreeTest {
    private final BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    @Test
    public void addInitialElement() {
        bst.insert(1);
        var result = bst.search(1) && !bst.isEmpty() && bst.size() == 1;
        Assertions.assertTrue(result);
    }

    @Test
    public void removeElementResultingInEmptyTree() {
        bst.insert(1);
        bst.remove(1);
        var result = !bst.search(1) && bst.isEmpty() && bst.size() == 0;
        Assertions.assertTrue(result);
    }

    @Test
    public void removeLeafNodeInSkewedRightTree() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.remove(3);
        var result = bst.size() == 2 && !bst.search(3) && bst.search(1) && bst.search(2);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeRootNodeInSkewedRightTree() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.remove(1);
        var result = bst.size() == 2 && !bst.search(1) && bst.search(2) && bst.search(3);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeMiddleNodeInSkewedRightTree() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.remove(2);
        var result = bst.size() == 2 && !bst.search(2) && bst.search(1) && bst.search(3);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeLeafNodeInSkewedLeftTree() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.remove(1);
        var result = bst.size() == 2 && !bst.search(1) && bst.search(3) && bst.search(2);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeRootNodeInSkewedLeftTree() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.remove(3);
        var result = bst.size() == 2 && !bst.search(3) && bst.search(2) && bst.search(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeMiddleNodeInSkewedLeftTree() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        bst.remove(2);
        var result = bst.size() == 2 && !bst.search(2) && bst.search(1) && bst.search(3);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeLeafNodeInTreeBalancedByInsertion() {
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.remove(2);
        var result = bst.size() == 2 && bst.search(1) && bst.search(3) && !bst.search(2);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeRootNodeInTreeBalancedByInsertion() {
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.remove(2);
        var result = bst.size() == 2 && bst.search(1) && bst.search(3) && !bst.search(2);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeMiddleNodeInTreeBalancedByInsertion() {
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(0);
        bst.remove(1);
        var result = bst.size() == 3 && bst.search(0) && bst.search(3) && bst.search(2) &&
                !bst.search(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeLeafNodeInTreeBalancedByAlgorithm() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.balance();
        bst.remove(1);
        var result = bst.size() == 4 && !bst.search(1) && bst.search(2) && bst.search(3) &&
                bst.search(4) && bst.search(5);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeRootNodeInTreeBalancedByAlgorithm() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.balance();
        bst.remove(3);
        var result = bst.size() == 4 && !bst.search(3) && bst.search(1) && bst.search(2) &&
                bst.search(4) && bst.search(5);
        Assertions.assertTrue(result);
    }

    @Test
    public void removeMiddleNodeInTreeBalancedByAlgorithm() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.balance();
        bst.remove(2);
        var result = bst.size() == 4 && !bst.search(2);
        Assertions.assertTrue(result);
    }

    @Test
    public void getMinimumNodeInTreeSkewedLeft() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        var result = bst.minNode();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getMinimumNodeInTreeSkewedRight() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        var result = bst.minNode();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getMinimumNodeInBalancedTree() {
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        var result = bst.minNode();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getMinimumNodeEmptyTree() {
        var result = bst.minNode();
        Assertions.assertNull(result);
    }

    @Test
    public void getMaximumNodeInTreeSkewedLeft() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        var result = bst.maxNode();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void getMaximumNodeInTreeSkewedRight() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        var result = bst.maxNode();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void getMaximumNodeInBalancedTree() {
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        var result = bst.maxNode();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void getMaximumNodeEmptyTree() {
        var result = bst.maxNode();
        Assertions.assertNull(result);
    }

    @Test
    public void searchForInteriorNode() {
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(2);
        var result = bst.search(3);
        Assertions.assertTrue(result);
    }

    @Test
    public void searchForLeafNode() {
        bst.insert(2);
        bst.insert(1);
        var result = bst.search(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void searchForRootNode() {
        bst.insert(1);
        var result = bst.search(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void searchForInvalidNode() {
        var result = bst.search(1);
        Assertions.assertFalse(result);
    }

    @Test
    public void getSizeAfterAdditions() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        var result = bst.size();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void getSizeAfterDeletions() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.remove(1);
        bst.remove(3);
        var result = bst.size();
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getInOrderTraversalEmptyTree() {
        var result = bst.inOrder().toString();
        Assertions.assertEquals("[]", result);
    }

    @Test
    public void getInOrderTraversalInSkewedLeftTree() {
        bst.insert(5);
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        var result = bst.inOrder().toString();
        Assertions.assertEquals("[1 2 3 4 5]", result);
    }

    @Test
    public void getInOrderTraversalInSkewedRightTree() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        var result = bst.inOrder().toString();
        Assertions.assertEquals("[1 2 3 4 5]" , result);
    }

    @Test
    public void getInOrderTraversalInTreeBalancedByInsertion() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        var result = bst.inOrder().toString();
        Assertions.assertEquals("[1 2 3 4 5]" , result);
    }

    @Test
    public void getInOrderTraversalInTreeBalancedByAlgorithm() {
        bst.insert(1);
        bst.insert(5);
        bst.insert(2);
        bst.insert(4);
        bst.insert(3);
        bst.balance();
        var result = bst.inOrder().toString();
        Assertions.assertEquals("[1 2 3 4 5]" , result);
    }

    @Test
    public void getPreOrderTraversalEmptyTree() {
        var result = bst.preOrder().toString();
        Assertions.assertEquals("[]", result);
    }

    @Test
    public void getPreOrderTraversalInSkewedLeftTree() {
        bst.insert(5);
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        var result = bst.preOrder().toString();
        Assertions.assertEquals("[5 4 3 2 1]", result);
    }

    @Test
    public void getPreOrderTraversalInSkewedRightTree() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        var result = bst.preOrder().toString();
        Assertions.assertEquals("[1 2 3 4 5]" , result);
    }

    @Test
    public void getPreOrderTraversalInTreeBalancedByInsertion() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        var result = bst.preOrder().toString();
        Assertions.assertEquals("[3 2 1 4 5]" , result);
    }

    @Test
    public void getPreOrderTraversalInTreeBalancedByAlgorithm() {
        bst.insert(1);
        bst.insert(5);
        bst.insert(2);
        bst.insert(4);
        bst.insert(3);
        bst.balance();
        var result = bst.preOrder().toString();
        Assertions.assertEquals("[3 1 2 4 5]" , result);
    }

    @Test
    public void getPostOrderTraversalEmptyTree() {
        var result = bst.postOrder().toString();
        Assertions.assertEquals("[]", result);
    }

    @Test
    public void getPostOrderTraversalInSkewedLeftTree() {
        bst.insert(5);
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        var result = bst.postOrder().toString();
        Assertions.assertEquals("[1 2 3 4 5]", result);
    }

    @Test
    public void getPostOrderTraversalInSkewedRightTree() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        var result = bst.postOrder().toString();
        Assertions.assertEquals("[5 4 3 2 1]" , result);
    }

    @Test
    public void getPostOrderTraversalInTreeBalancedByInsertion() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        var result = bst.postOrder().toString();
        Assertions.assertEquals("[1 2 5 4 3]" , result);
    }

    @Test
    public void getPostOrderTraversalInTreeBalancedByAlgorithm() {
        bst.insert(1);
        bst.insert(5);
        bst.insert(2);
        bst.insert(4);
        bst.insert(3);
        bst.balance();
        var result = bst.postOrder().toString();
        Assertions.assertEquals("[2 1 5 4 3]" , result);
    }

    @Test
    public void getLevelOrderTraversalEmptyTree() {
        var result = bst.levelOrder().toString();
        Assertions.assertEquals("[]", result);
    }

    @Test
    public void getLevelOrderTraversalInSkewedLeftTree() {
        bst.insert(5);
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        var result = bst.levelOrder().toString();
        Assertions.assertEquals("[5 4 3 2 1]", result);
    }

    @Test
    public void getLevelOrderTraversalInSkewedRightTree() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        var result = bst.levelOrder().toString();
        Assertions.assertEquals("[1 2 3 4 5]" , result);
    }

    @Test
    public void getLevelOrderTraversalInTreeBalancedByInsertion() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        var result = bst.levelOrder().toString();
        Assertions.assertEquals("[3 2 4 1 5]" , result);
    }

    @Test
    public void getLevelOrderTraversalInTreeBalancedByAlgorithm() {
        bst.insert(1);
        bst.insert(5);
        bst.insert(2);
        bst.insert(4);
        bst.insert(3);
        bst.balance();
        var result = bst.levelOrder().toString();
        Assertions.assertEquals("[3 1 4 2 5]" , result);
    }

    @Test
    public void getNumberOfLeafNodes() {
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        var result = bst.leafCounter();
        Assertions.assertEquals(2, result);
    }

    @Test
    public void getNumberOfLeafNodesEmptyTree() {
        var result = bst.leafCounter();
        Assertions.assertEquals(0, result);
    }

    @Test
    public void getNumberOfNodesWithOneSibling() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        var result = bst.onlyChild();
        Assertions.assertEquals(2, result);
    }

    @Test
    public void getHeightOfTreeBalancedByInsertion() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        var result = bst.height();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void getHeightOfTreeBalancedByAlgorithm() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        bst.balance();
        var result = bst.height();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void getHeightOfSkewedLeftTree() {
        bst.insert(5);
        bst.insert(4);
        bst.insert(3);
        bst.insert(2);
        bst.insert(1);
        var result = bst.height();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void getHeightOfSkewedRightTree() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        var result = bst.height();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void getFullnessRatioOfBalancedTree() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        bst.balance();
        var result = bst.fullnessRatio();
        Assertions.assertEquals(1.0, result);
    }

    @Test
    public void getFullnessRatioOfSkewedTree() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        var result = bst.fullnessRatio();
        Assertions.assertEquals(1.6666666666666667, result);
    }

    @Test
    public void getFullnessRatioOfEmptyTree() {
        var result = bst.fullnessRatio();
        Assertions.assertEquals(0.0, result);
    }

    @Test
    public void getOptimalHeightOfValidTree() {
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(1);
        bst.insert(5);
        var result = bst.optimalHeight();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void getOptimalHeightOfEmptyTree() {
        var result = bst.optimalHeight();
        Assertions.assertEquals(0, result);
    }
}
