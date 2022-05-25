package com.interviewBit;

public class SubStringsOfString {
    public static void main(String args[])
    {
        String str="abbc";
        System.out.println("Length : "+ getLengthOfString(str));
        System.out.println("All substring of abbc are:");
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length(); j++) {
                System.out.print(str.substring(i,j) + ", ");

            }
        }
    }

    public static int getLengthOfString(String str)
    {
        int i=0;
        try{
            for(i=0;;i++)
            {
                str.charAt(i);
            }

        }
        catch(Exception e)
        {

        }
        return i;
    }
}
