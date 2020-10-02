//https://leetcode.com/problems/daily-temperatures/

import java.util.*;

public class LeetCode739 {

    public int[] dailyTemperatures(int[] T) {

        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;

    }
}
