package ds.linkedlist;

public class LinkedListTester {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
//        ll.remove(4);
        ll.add(1);
        ll.add(2);
        ll.add(4);
        ll.add(6);
        System.out.println(ll.length() + ", " + ll.printAllElements());
        ll.remove(4);
        System.out.println(ll.length() + ", " + ll.printAllElements());
        ll.add(4);
        System.out.println(ll.length() + ", " + ll.printAllElements());
        // Trying to remove value which is not present
        ll.remove(0);
        System.out.println(ll.length() + ", " + ll.printAllElements());
        ll.addAtIndex(7, 2);
        System.out.println(ll.length() + ", " + ll.printAllElements());

        ll.removeAtIndex(2);
        System.out.println(ll.length() + ", " + ll.printAllElements());

//        ll.reverse();
//        System.out.println(ll.length() + ", " + ll.printAllElements());

//        ll.printForwardAndReverseUsingRecursion(ll.getHeadElement());


    }




}
