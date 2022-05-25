package ds.stack;

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

@ToString
public class Stack<T> {

    private Node<T> head;

    public T pop() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        T poppedElement = head.getData();
        head = head.getNext();
        return poppedElement;
    }

    public void push(T data) {
        if (head == null) {
            head = new Node<>(data, null);
        } else {
            head = new Node<>(data, head);
        }
    }

    public String print() {
        StringJoiner joiner = new StringJoiner("\n-----\n");
        if (head != null) {
            Node<T> curr = head;
            while (curr != null) {
                joiner.add(String.valueOf(curr.getData()));
                curr = curr.getNext();
            }
        }
        return joiner.toString();
    }

}
