/*Q1
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

public class AddStrings_1 {

    public String addStrings(String num1, String num2){
        String ans = "";
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry = 0;
        while(i>=0 || j>=0){
            int sum=0;
            if(i>=0)
                sum = sum + num1.charAt(i--) - '0';
            if(j>=0)
                sum = sum + num2.charAt(j--) - '0';
            sum = sum +carry;
            carry =sum/10;
            int currentDigit = sum%10;
            ans = currentDigit +ans;
        }
        if(carry>0)
            ans = carry + ans;
        return ans;
    }

}
