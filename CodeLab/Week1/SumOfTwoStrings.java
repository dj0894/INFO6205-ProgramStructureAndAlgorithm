import java.math.BigInteger;
import java.util.*;

public class SumOfTwoStrings {

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);

        String number1=sc.nextLine();
        String number2=sc.nextLine();
        BigInteger num1=new BigInteger(number1);
        BigInteger num2=new BigInteger(number2);

        System.out.println("sum="+ num1.add(num2));
    }



}
