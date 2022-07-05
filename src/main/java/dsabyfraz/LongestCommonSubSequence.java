package dsabyfraz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//We have 2 solutions other than brute force approach for this problem,

/**

 1. Space Complexity O(1) , Time Complexity (N log n)-:
 ------------------------------------------------------

 a). Sort the array.
 b). Iterate over the array, while iterating, at each element check,
    --If next element is next consecutive number, then increase the length.
    --If next element is duplicate then just ignore it by "continue" statement.
    --If not consecutive number, reinitialize length with 1 again.
 Hold current length in "max" in each iteration.
 */


/**
 2. Space Complexity O(N), Time Complexity O(N)-:
 ------------------------------------------------
 a). Add all elements in hashSet
 b). Iterate over all elements in array and for each element check,
    --If next consecutive elements are present till we find.
    --If element does not present then reinitialize length with 0.
 Imp Note-: To avoid inner loop for all elements we need to check if previous consecutive element present in set,
            If yes then we will skip current element for its consecutive checks,
            Because current element will be the part of previous consecutive element,
            And obviously that element will make longer subsequence than current element.
 Hold current length in "max" in each iteration.
 */

public class LongestCommonSubSequence {

    public static int longestConsecutiveWithLinearComplexity(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        //Sorting array
        Arrays.sort(arr);

        int max = 1;
        int len = 1;
        // Iterate over each element
        for (int i = 0; i < arr.length-1; i++) {
            int n = arr[i];
            // Check if next element is consecutive of current element, then increase length
            if (arr[i+1] == n+1) {
                len++;
            } else if (arr[i+1] == n) {
                continue;
            } else {
                len = 1;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    public static void main(String[] args) {
//        int [] arr = new int[] {100, 4, 200, 1, 3, 2};
//        int [] arr = new int[] {1,2,0,1};
        int [] arr = new int[] {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveWithHashSet(arr));
        System.out.println(longestConsecutiveWithLinearComplexity(arr));
    }

    private static int longestConsecutiveWithHashSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int len=0;
        int max=1;

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            int start = arr[i];
            if(set.contains(start-1)) {
                continue;
            }
            while (set.contains(start)) {
                len++;
                start++;
            }
            max = Math.max(max, len);
            len = 0;
        }
        return max;
    }
}
