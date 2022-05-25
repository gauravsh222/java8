package ds.tree;

public class TestTree {

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(15);
        tree.add(10);
        tree.add(20);
        tree.add(8);
        tree.add(12);
        tree.add(17);
        tree.add(25);
        tree.add(9);

        System.out.println(tree.findMin());
        System.out.println(tree.findMinRecursively(tree.getRootNode()));
        System.out.println(tree.findMax());
        System.out.println(tree.findMaxRecursively(tree.getRootNode()));

        System.out.println(tree.findHeight());

        // Print tree in Level Order Traversal
        System.out.println("Level Order Print : " + tree.levelOrderTraversal());
    }
}
