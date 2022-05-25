package com.interviewBit;

import java.util.List;

public class BalanceArray {
    public static void main(String[] args) {

    }

    public int solve1(int[] A) {

        int n = A.length;
        int result = 0;
        int even = 0;
        int odd =0;

        for(int i = 0 ; i < A.length ; i++){
            if(i%2 == 0)
                even += A[i];
            else
                odd += A[i];
        }

        int keven = 0;
        int kodd =0;

        for(int i = 0 ; i < A.length ; i++){
            if(i%2 == 0){
                if((even - (A[i]+keven) + kodd) == ((odd-kodd) + keven))
                    result += 1;
                keven += A[i];
            }
            else{
                if((odd - (A[i]+kodd) + keven) == (kodd + (even-keven)))
                    result += 1;
                kodd += A[i];
            }
        }

        return result;

    }

    public int solve(List<Integer> A) {
        int n = A.size();
        int osum=0;
        int esum=0;
        int count=0;
        for(int i=0;i<n;i+=2)
            esum+=A.get(i);
        for(int i=1;i<n;i+=2)
            osum+=A.get(i);
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                esum-=A.get(i);
                if(esum==osum)count++;
            }
            else
            {
                osum-=A.get(i);
                if(osum==esum)
                    count++;
            }
        }
        return count;
    }

    public int solve(int[] A) {
        long es = 0, os = 0;
        long sum[] = new long[A.length];

        for(int i = 0 ; i < A.length ; i++){
            if(i%2 == 0)
                es += A[i];
            else
                os += A[i];
        }

        long lefte = 0, lefto = 0;
        int count = 0 ;

        for(int i = 0 ; i < A.length ; i++){
            if(i%2 == 0){
                if(os + lefte == lefto + es - A[i])
                    count++;
                es -= A[i];
                lefte += A[i];
            }else{
                if(es + lefto == lefte + os - A[i])
                    count++;
                os -= A[i];
                lefto += A[i];
            }
        }

        return count++;
    }
}
