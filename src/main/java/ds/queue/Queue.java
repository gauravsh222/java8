package ds.queue;

import lombok.ToString;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

@ToString
class Node<T> {
    private T data;
    private Node<T> next;

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


public class Queue<T> {
    private Node<T> head; 
    private Node<T> tail;

    public void enqueue(T data) {
        Node<T> node = new Node<>(data, null);
        //creating first node if list is empty
        if(head == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public T dequeue() {
        T removedData;
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            removedData = head.getData();
            head = head.getNext();
        }
        return removedData;
    }


    public T peek() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            return head.getData();
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
    
}
