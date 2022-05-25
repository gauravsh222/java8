package ds.stack;

public class StackTester {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.print());
        System.out.println("Popped Element : " + stack.pop());
        System.out.println(stack.print());
        System.out.println("Popped Element : " + stack.pop());
        System.out.println(stack.print());
        System.out.println("Popped Element : " + stack.pop());
        System.out.println(stack.print());
        System.out.println("Popped Element : " + stack.pop());
        System.out.println(stack.print());
        System.out.println("Popped Element : " + stack.pop());
        System.out.println(stack.print());
        System.out.println("Popped Element : " + stack.pop());
        System.out.println(stack.print());

    }
}
