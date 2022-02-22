package BSTBA;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        testDriver(scn, bst);
        scn.close();
    }

    /**
     * menu A manu of choices for interacting with the BST.
     */
    public static void menu() {
        System.out.print("Methods for Binary Search Tree (BST)\n1 - INSERT - Inserts a node into the BST\n2 - " +
                "REMOVE - Removes a node from the BST\n3 - SEARCH - Searches the BST for a value\n4 - IS FULL - " +
                "Checks if the BST is full\n5 - IS EMPTY - Checks if the BST is empty\n6 - SIZE - Returns the " +
                "number of nodes in the BST\n7 - HEIGHT - Returns the height of the BST\n8 - MIN NODE - Returns " +
                "the data held by the smallest node in the BST\n9 - MAX NODE - Returns the data held by the " +
                "largest node in the BST\n10 - LEAF COUNTER - Counts the number of leaf nodes in the BST\n11 - " +
                "ONLY CHILD - Counts the number of nodes that have no sibling node\n12 - INORDER - Performs" +
                " an inorder traversal of the BST\n13 - PREORDER - Performs a preorder traversal of the BST\n14 -" +
                " POSTORDER - Performs a postorder traversal of the BST\n15 - LEVELORDER - Performs  levelorder " +
                "traversal of the BST\n16 - BALANCE - Balances the BST\n17 - FULLNESS RATIO - Returns the ratio " +
                "between the BST's minimum height and it's current height\n18 - BOUNDARY TRAVERSAL - Performs " +
                "boundar traversal of the BST\nX - Terminate\n\nEnter choice: ");
    }

    /**
     * testDriver A test driver for interacting with a BinarySearchTree object.
     * @param scn A Scanner object for user input.
     * @param bst A BinarySearchTree object.
     */
    public static void testDriver(Scanner scn, BinarySearchTree<Integer> bst) {
        String choice = "";
        while(!choice.equalsIgnoreCase("X")) {
            menu();
            choice = scn.nextLine();
            if (choice.equals("1")) {
                System.out.print("Input an integer to insert into the BST: ");
                int input = scn.nextInt();
                scn.nextLine();
                System.out.println("Added: " + bst.insert(input));
            } else if (choice.equals("2")) {
                System.out.print("Input an integer to remove from the BST: ");
                int input = scn.nextInt();
                scn.nextLine();
                System.out.println("Removed: " + bst.remove(input));
            } else if (choice.equals("3")) {
                System.out.print("Input an integer to search for in the BST: ");
                int input = scn.nextInt();
                scn.nextLine();
                System.out.println("Found: " + bst.search(input));
            } else if (choice.equals("4")) {
                System.out.println("Full tree: " + bst.isFull());
            } else if (choice.equals("5")) {
                System.out.println("Empty tree: " + bst.isEmpty());
            } else if (choice.equals("6")) {
                System.out.println("Size: " + bst.size());
            } else if (choice.equals("7")) {
                System.out.println("Height: " + bst.height());
            } else if (choice.equals("8")) {
                System.out.println("Smallest node: " + bst.minNode());
            } else if (choice.equals("9")) {
                System.out.println("Largest node: " + bst.maxNode());
            } else if (choice.equals("10")) {
                System.out.println("Number of leaf nodes: " + bst.leafCounter());
            } else if (choice.equals("11")) {
                System.out.println("Number of only child nodes: " + bst.onlyChild());
            } else if (choice.equals("12")) {
                System.out.println("Inorder traversal: " + bst.inOrder());
            } else if (choice.equals("13")) {
                System.out.println("Preorder traversal: " + bst.preOrder());
            } else if (choice.equals("14")) {
                System.out.println("Postorder traversal: " + bst.postOrder());
            } else if (choice.equals("15")) {
                System.out.println("Levelorder traversal: " + bst.levelOrder());
            } else if (choice.equals("16")) {
                bst.balance();
                System.out.println("The tree has been balanced");
            } else if (choice.equals("17")) {
                System.out.println("Fullness ratio is " + bst.fullnessRatio());
            } else if (choice.equals("18")) {
                System.out.println("Boundary traversal: " + bst.boundaryOrder());
            } else if (choice.equalsIgnoreCase("X")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
