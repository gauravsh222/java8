package com.interviewBit;

import java.util.Arrays;

public class MatrixRotatation {

    public static void main(String[] args) {

//        rotateSquareMatrix();
        rotateRectangleMatrix();
    }

    private static void rotateRectangleMatrix() {
        int[][] in = { {1,2,3},
                {4,5,6}
        };
        System.out.println(in.length);
        System.out.print(in[0].length + ",");
        System.out.println(in[1].length);
        int [][] op = new int[in[0].length][in.length];
        rotate(in, op);

    }

    private static void rotateSquareMatrix() {
        int[][] in = { {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(in.length);
        System.out.print(in[0].length + ",");
        System.out.println(in[1].length);
        int [][] op = new int[in[0].length][in.length];
        rotate(in, op);
    }

    private static void rotate(int[][] in, int[][] op) {

        for (int i=0; i<in.length; i++) {
            for(int j=0; j<in.length; j++) {
                int element = in[i][j];
                op[in.length-1-j][i] = element;
            }
        }
        printArrays(in, op);
    }

    private static void printArrays(int[][] in, int[][] op) {
        System.out.println(Arrays.deepToString(in));
        System.out.println(Arrays.deepToString(op));
    }


}
