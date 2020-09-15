

import java.util.*;

/**
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other
 */
class StringPermutation {

    static boolean isPermutation(String str1, String str2)
    {

        int n1 = str1.length();
        int n2 = str2.length();
        if (n1 != n2)
            return false;
        char ch1[] = str1.toCharArray();
        char ch2[] = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < n1; i++)
            if (ch1[i] != ch2[i])
                return false;

        return true;
    }


    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the First String");
        String str1=sc.next();
        System.out.println("Enter the Second String");
        String str2=sc.next();

        if (isPermutation(str1, str2))
            System.out.println("Strings are permutation of each");
        else
            System.out.println("Strings are not permutation of each other");
    }
}