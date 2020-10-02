//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

import java.util.*;

public class LeetCode921 {
    public int minAddToMakeValid(String S) {

        Stack<Character> stack=new Stack<Character>();
        int count = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==')'){
                if (stack.isEmpty()) {
                    count++;
                } else {
                    stack.pop();
                }
            } else{
                stack.push('(');
            }
        }
        return count+stack.size();
    }

}
