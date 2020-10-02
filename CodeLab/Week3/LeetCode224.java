
//https://leetcode.com/problems/basic-calculator/

import java.util.*;

public class LeetCode224 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0, symbol = 1;
        for (int i = 0; i < s.length(); i++) {

            Character ch = s.charAt(i);

            if (ch == ' '){
                continue;
            }
            if (Character.isDigit(ch)) {
                int number = Character.getNumericValue(ch);
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    number = number * 10 + Character.getNumericValue(s.charAt(i + 1));
                    i++;
                }
                result += symbol * number;
            }
            else if (ch == '+') symbol = 1;
            else if (ch == '-') symbol = -1;
            else if (ch == '(') {
                stack.push(result);
                stack.push(symbol);
                result = 0;
                symbol = 1;
            } else if (ch == ')') {
                int prevSymbol = stack.pop();
                int prevResult = stack.pop();
                result = prevSymbol * result + prevResult;
            }
        }

        return result;
    }


}
