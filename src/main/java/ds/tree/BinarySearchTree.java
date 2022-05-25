package ds.tree;

import lombok.ToString;

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

        return 0;
    }

}
