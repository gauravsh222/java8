package com.interviewBit;

import java.util.*;
import java.util.stream.Collectors;

public class MaxPossibleSumInGivenArray {

    private static List<Integer> elements = new ArrayList<>();

    public static int wrongLogic(int[] A, int B) {
        int r = A.length-1;
        int l = 0;
        int sum = 0;
        int count = 0;
        System.err.println("initial elements : " + Arrays.toString(A) + ", sum : " + sum);
        while(l != r && count != B) {
            count++;
            if(A[l] > A[r]) {
                sum += A[l];
                elements.add(A[l]);
                System.err.println("updated elements : " + elements + ", sum : " + sum);
                l++;
            }
            else {
                sum += A[r];
                elements.add(A[r]);
                System.err.println("updated elements : " + elements + ", sum : " + sum);
                r--;
            }
        }
        return sum;
    }

    public static int solutionArrayList(List<Integer> list, int B) {
        int size = list.size();
        int maxSum = 0;
        for (int i = 0; i < B; i++) {
            maxSum += list.get(i);
        }
        if (B == size) {
            return maxSum;
        }

        int localSum = maxSum;
        int startPointer = B - 1;
        int endPointer = size - 1;

        for (int i = startPointer; i >= 0; i--) {
            localSum -= list.get(i);
            localSum += list.get(endPointer);

            maxSum = Math.max(localSum, maxSum);
            endPointer--;
        }
        return maxSum;
    }


    public int Solution2(int[] A, int B) {
        int sum1 = 0, sum2 = 0, min1;
        for(int i = 0; i<A.length;i++) {
            sum1 += A[i];
        }
        int i = 0, j = A.length - B - 1;

        for(int k=i;k<=j;k++)
        {
            sum2 += A[k];
        }
        min1 = sum2; i++; j++;
        while(j<A.length)
        {
            sum2 += (A[j]-A[i-1]);
            if(sum2<min1){min1=sum2;}
            i++;j++;
        }
        return sum1-min1;
    }


    public static int solutionArrays(int[] arr, int B) {
        int length = arr.length;
        System.out.println("Original Array : " + Arrays.toString(arr));
        //sum of last B elements
        int sum = add_last(arr, B, length);
        int max_sum = sum;
        System.err.println("initial elements : " + elements + ", sum : " + sum + ", max_sum : " + max_sum);
        //sliding the subarray
        for (int i = B; i > 0; i--) {
            //subtracting first element from the subarray and adding next element
            sum = sum - arr[length-i] + arr[(length-i+B)%length];
            if (sum > max_sum) max_sum = sum;

            // print for watch
            int indexOfRemovedElement = elements.indexOf(arr[length - i]);
            elements.remove(Integer.valueOf(arr[length-i]));
            elements.add(indexOfRemovedElement, arr[(length-i+B)%length]);
            System.err.println("updated elements : " + elements + ", sum : " + sum + ", max_sum : " + max_sum);
        }
        return max_sum;
    }

    private static int add_last(int[] arr, int B, int length) {
        int sum=0;
        for (int i = length-B; i < length; i++) {
            sum += arr[i];
            elements.add(arr[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{-533, -666, -500, 169, 724, 478, 358, -38, -536, 705,
                -855, 281, -173, 961, -509, -5, 942, -173, 436, -609,
                -396, 902, -847, -708, -618, 421, -284, 718, 895, 447,
                726, -229, 538, 869, 912, 667, -701, 35, 894, -297,
                811, 322, -667, 673, -336, 141, 711, -747, -132, 547,
                644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
//        System.out.println(solutionArrays(arr, 48));
//        System.out.println(solutionArrayList(Arrays.stream(arr).boxed().collect(Collectors.toList()), 48));
//        System.out.println("------"+solutionArrayList(Arrays.asList(-2,5,7,8,1,2,3), 3));
//        System.out.println(solutionArrays(new int[]{-2,5,7,8,1,2,3}, 3));
        System.out.println(wrongLogic(new int[]{-2,5,7,8,1,2,3}, 3));

    }
}
