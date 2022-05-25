package ds.linkedlist;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        l1.add(7);
        System.out.println(l1.printAllElements());

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(2);
        l2.add(3);
        l2.add(5);
        System.out.println(l2.printAllElements());

        // both lists have some elements
//        Node<Integer> merged = mergeTwoLists(l1.getHeadElement(), l2. getHeadElement());

        // one of the list is null
        Node<Integer> merged = mergeTwoLists(l1.getHeadElement(), null);


        String elements = new LinkedList<Integer>().printAllElements(merged);
        System.out.println(elements);



    }
    public static Node<Integer> mergeTwoLists(Node<Integer> f, Node<Integer> s) {
        Node<Integer> head = null;
        Node<Integer> tail = null;

        if(f == null || s == null) {
            head = f == null ? s : f;
            return head;
        }

        while(f != null && s != null) {
//            System.out.println(f.getData() + ", " + s.getData());
            if(head == null) {
                if(f.getData() < s.getData()) {
                    head = f;
                    f = f.getNext();
                } else {
                    head = s;
                    s = s.getNext();
                }
                tail = head;
            } else {
                if(f.getData() < s.getData()) {
                    tail.setNext(f);
                    tail = f;
                    f = f.getNext();
                } else {
                    tail.setNext(s);
                    tail = s;
                    s = s.getNext();
                }
            }
        }

        if(f != null) {
            tail.setNext(f);
        } else {
            tail.setNext(s);
        }
        return head;
    }
}

