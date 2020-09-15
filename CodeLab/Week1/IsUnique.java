import java.util.*;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters
 */
public class IsUnique {

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String s=sc.next();
        char ch[] = s.toCharArray();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<ch.length;i++)
        {
           set.add(ch[i]);
        }
        if(set.size()==ch.length) {
            System.out.println("String is unique");
        } else {
            System.out.println("String is not unique");
        }
    }
}
