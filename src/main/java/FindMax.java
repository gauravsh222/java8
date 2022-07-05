import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FindMax {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,2,5,3,10,7,9);
        OptionalInt max = list.stream().mapToInt(i -> i).max();
        System.out.println(max.orElse(0));

        String str = "ABA";
        char[] array = str.toCharArray();
        for (int i = 0, j=array.length-1; i < j; i++,j--) {
            char c = array[i];
            array[i] = array[j];
            array[j]=c;
        }
        String reversed = String.valueOf(array);
        System.out.println(str.equalsIgnoreCase(reversed));
    }
}
