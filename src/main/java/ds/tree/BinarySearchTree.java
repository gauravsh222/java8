package ds.tree;

import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * Binary Search Tree is the tree which has at most two children and left side element must be smaller than current node
 * and right side element must be greater than current node
 */

@ToString
class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    Queue<Node<T>> queue = new LinkedList<>();

    public Node<T> getRootNode() {
        return root;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data, null, null);
        if (root == null) {
            root = node;
        } else {
            Node<T> curr = root;
            while (true) {
                int compare = curr.data.compareTo(data);
                if (compare == 0) {
                    throw new UnsupportedOperationException("Duplicates are not allowed");
                } else if (compare > 0) {
                    // add element to the left side of node
                    if(curr.left == null) {
                       curr.left = node;
                       break;
                    }
                    curr = curr.left;
                } else {
                    // add element to the right side of node
                    if(curr.right == null) {
                        curr.right = node;
                        break;
                    }
                    curr = curr.right;
                }
            }
        }
    }

    public T findMinRecursively(Node<T> root) {
        if(root.left == null) {
            return root.data;
        }
        return findMinRecursively(root.left);
    }

    public T findMin() {
        Node<T> curr = root;
        T min = null;
        while (curr != null) {
            min = curr.data;
            curr = curr.left;
        }
        return min;
    }

    public T findMaxRecursively(Node<T> root) {
        if(root.right == null) {
            return root.data;
        }
        return findMaxRecursively(root.right);
    }

    public T findMax() {
        Node<T> curr = root;
        T max = null;
        while (curr != null) {
            max = curr.data;
            curr = curr.right;
        }
        return max;
    }

    public int findHeight() {
        findLeftHeightOfRoot();
        return 0;
    }

    private int findLeftHeightOfRoot() {
       /* while () {

        }*/
        return 0;
    }


    /**
     * Level order traversal is also called Breadth first traversal
     */
    public String levelOrderTraversal(){
        queue.add(root);
        StringJoiner joiner = new StringJoiner(",");
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            joiner.add(String.valueOf(node.data));
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return joiner.toString();
    }

}
