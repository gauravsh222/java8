package ds.linkedlist;

import lombok.ToString;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

@ToString
class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

@ToString
public class LinkedList<T> {

    private Node<T> head = null;

    public Node<T> getHeadElement() {
        return head;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data, null);
        //creating first node if list is empty
        if(head == null) {
            head = node;
        }
        else {
            Node<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(node);
        }
    }

    public void addAtIndex(T data, int index) {

        //This method is not taking care of adding at 0'th index
        Node<T> curr = head;
        for (int i=0; i < index-1; i++){
            curr = curr.getNext();
        }
        if(curr != null) {
            Node<T> temp = curr.getNext();
            curr.setNext(new Node<>(data, temp));
        }
    }


    public Node<T> remove(T data) {
        if(head == null) {
            throw new NoSuchElementException();
        }
        Node<T> curr = head;
        while (curr.getNext() != null && curr.getNext().getData() != data) {
            curr = curr.getNext();
        }
        if(curr.getNext() != null) {
            Node<T> removedElement = curr.getNext();
            curr.setNext(curr.getNext().getNext());
            return removedElement;
        } else {
            System.err.println("No element found to remove");
            return null;
        }
    }


    public Node<T> removeAtIndex(int index) {
        if(head == null) {
            throw new NoSuchElementException();
        }
        // This method is not taking care of removing from 0'th index
        Node<T> curr = head;
        for (int i=0; i<index-1; i++) {
            curr = curr.getNext();
        }
        if(curr != null) {
            Node<T> removedElement = curr.getNext();
            curr.setNext(curr.getNext().getNext());
            return removedElement;
        } else {
            System.err.println("No element found to remove");
            return null;
        }
    }

    public int length() {
        int count=0;
        Node<T> curr = head;
        while (curr != null) {
            count++;
            curr = curr.getNext();
        }
        return count;
    }


    public String printAllElements() {
        StringJoiner joiner = new StringJoiner("-->");
        Node<T> curr = head;
        while (curr != null) {
            joiner.add(String.valueOf(curr.getData()));
            curr = curr.getNext();
        }
        return joiner.toString();
    }

    public String printAllElements(Node<T> head) {
        StringJoiner joiner = new StringJoiner("-->");
        Node<T> curr = head;
        while (curr != null) {
            joiner.add(String.valueOf(curr.getData()));
            curr = curr.getNext();
        }
        return joiner.toString();
    }

    public void reverse() {
        Node<T> curr=head, prev=null, next=null;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev=curr;
            curr=next;
        }
        head = prev;
    }

    public void printForwardAndReverseUsingRecursion(Node<T> head) {
        if(head == null) {
            return;
        }
        System.out.print(head.getData() + " ");

        printForwardAndReverseUsingRecursion(head.getNext());

        System.out.print(head.getData() + " ");
    }

    public  Node<T> reverseBetween(Node<T> head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;
        Node<T> curr = null;
        Node<T> start = head;
        int count=1;
        while (start != null && count < left) {
            curr = start;
            start = start.next;
            count++;
        }
        if (start != null) {
            head = reversePartialList(start, right-left+1);
            if (curr != null) {
                curr.next = head;
            } else {
                this.head = head;
            }
        }
        return this.head;
    }

    private Node<T> reversePartialList(Node<T> curr, int right) {
        if (curr != null) {
            Node<T> tail = curr;
            Node<T> prev = null;
            Node<T> next;
            int count = 1;
            while(curr != null && count <= right) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            tail.next = curr;
            return prev;
        }
        return null;
    }

   public Node<T> findMiddle()
    {
        Node<T> slow_ptr = head;
        Node<T> fast_ptr = head;

        while (fast_ptr != null && fast_ptr.next != null)
        {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        return slow_ptr;
    }

}
