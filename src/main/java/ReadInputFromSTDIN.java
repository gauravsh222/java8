import java.util.Scanner;

public class ReadInputFromSTDIN {

    public static void main(String[] args) {
        int [] arr = new int[5];
        Scanner sc = new Scanner(System.in);

        for (int i=0; i<5; i++) {
            System.out.println("Enter next");
            System.out.println( sc.nextInt());
        }

        for (int i=0; i<2; i++) {
            System.out.println("Enter next line");
            System.out.println( sc.nextLine());
        }

        for (int i=0; i<2; i++) {
            System.out.println("Enter next");
            System.out.println( sc.next());
        }

    }
}
