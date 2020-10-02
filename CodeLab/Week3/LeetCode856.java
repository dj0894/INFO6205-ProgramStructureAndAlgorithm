//https://leetcode.com/problems/score-of-parentheses/

import java.util.*;

public class LeetCode856 {
    public int scoreOfParentheses(String S) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0); // The score of the current frame
        char ch[]=S.toCharArray();

        for (int i=0;i<S.length();i++) {
            if ( ch[i]== '(')
                stack.push(0);
            else {
                int top = stack.pop();
                int second = stack.pop();
                stack.push(second + Math.max(2 * top, 1));
            }
        }

        return stack.pop();

    }

}
