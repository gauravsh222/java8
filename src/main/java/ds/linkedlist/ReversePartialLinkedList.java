package ds.linkedlist;

public class ReversePartialLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        System.out.println("Mid : " + l1.findMiddle().getData());
        Node<Integer> head = l1.reverseBetween(l1.getHeadElement(), 2, 4);
        System.out.println(l1.printAllElements());

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(3);
        l2.add(5);
        System.out.println("Mid : " + l2.findMiddle().getData());
        head = l2.reverseBetween(l2.getHeadElement(), 1, 2);
        System.out.println(l2.printAllElements());
    }



}
