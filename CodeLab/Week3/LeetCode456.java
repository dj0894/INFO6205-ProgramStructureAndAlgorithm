
//https://leetcode.com/problems/132-pattern/

import java.util.*;

public class LeetCode456 {

    public boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<Integer>();
        int middle = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < middle) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                middle = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
