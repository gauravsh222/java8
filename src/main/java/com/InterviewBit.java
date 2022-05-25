package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewBit {
    public static int solve(int[] A, int B) {
        int r = A.length-1;
        int l = 0;
        int sum = 0;
        int count = 0;
        while(l != r && count != B) {
            count++;
            if(A[l] > A[r]) {
                sum += A[l];
                l++;
            }
            else {
                sum += A[r];
                r--;
            }
        }
        return sum;
    }

    public static int solve2(List<Integer> A, int B) {
        int size = A.size();
        int maxSum = 0;
        for(int i=0; i<B; i++) {
            maxSum += A.get(i);
        }
        if(B == size) {
            return maxSum;
        }

        int localSum = maxSum;
        int startPointer = B - 1;
        int endPointer = size - 1;

        for(int i=startPointer; i>=0; i--) {
            localSum -= A.get(i);
            localSum += A.get(endPointer);
            System.out.println("localSum : " + localSum);
            System.out.println("maxSum Before : " + maxSum);
            maxSum = Math.max(localSum, maxSum);
            System.out.println("maxSum After : " + maxSum);
            System.out.println("------------------------------------");
            endPointer--;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = new int [] {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705,
                                -855, 281, -173, 961, -509, -5, 942, -173, 436, -609,
                                -396, 902, -847, -708, -618, 421, -284, 718, 895, 447,
                                726, -229, 538, 869, 912, 667, -701, 35, 894, -297,
                                811, 322, -667, 673, -336, 141, 711, -747, -132, 547,
                                644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
        int solve = solve(arr, 48);
//        System.out.println(Arrays.stream(arr).sum());
//        System.out.println(solve);
//        System.out.println(solve2(Arrays.stream(arr).boxed().collect(Collectors.toList()), 48));
        System.out.println("------"+solve2(Arrays.asList(-2,5,7,8,1,2,3), 3));
    }
}
