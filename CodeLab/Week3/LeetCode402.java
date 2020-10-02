//https://leetcode.com/problems/remove-k-digits/

import java.util.*;

public class LeetCode402 {

    public String removeKdigits(String num, int k) {

        Stack<Character> stack=new Stack<Character>();
        stack.push(num.charAt(0));
        int i=1;
        while(i< num.length()) {
            if(k==0){
                break;
            }
            if (!stack.isEmpty()) {
                if(stack.peek()<=num.charAt(i)){
                    stack.push(num.charAt(i));
                    i++;
                } else{
                    stack.pop();
                    k--;
                }
            } else {
                stack.push(num.charAt(i));
                i++;
            }
        }
        while (k!=0) {
            stack.pop();
            k--;
        }

        String intermediateOutput="";
        String output="";

        while(!stack.isEmpty()){

            intermediateOutput=intermediateOutput+stack.pop();

        }
        System.out.println("intermediate"+intermediateOutput);

        for(int j=intermediateOutput.length()-1;j>=0;j--){

            output=output+intermediateOutput.charAt(j);
        }

        while(i<=num.length()-1){
            output=output+num.charAt(i);
            i++;
        }

        System.out.println("output"+output);

        output=output.replaceAll("^0+","");
        if(output.equals("")){
            return "0";
        }
        return output;
    }

}
