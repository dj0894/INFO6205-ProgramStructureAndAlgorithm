//https://leetcode.com/problems/remove-outermost-parentheses/

import java.util.*;

public class LeetCode1021 {
    public String removeOuterParentheses(String S) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int j =0;
        for(int i =0;i<S.length();i++) {
            if (S.charAt(i)=='(') {
                stack.push(i);
            } else {
                j = stack.pop();
            }

            //System.out.println(stack);

            if (stack.isEmpty())
                sb.append(S.substring(j+1,i));
        }

        return sb.toString();
    }

}
