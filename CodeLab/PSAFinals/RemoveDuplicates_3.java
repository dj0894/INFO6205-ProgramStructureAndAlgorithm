/*Q3
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and
removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

Example:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
*/

import java.util.Stack;

public class RemoveDuplicates_3 {
    public String removeDuplicates(String s, int k) {

        Stack<Character> stack = new Stack();
        Stack<Integer> count = new Stack();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && !count.isEmpty() && stack.peek() == c && count.peek() == k - 1) {

                while (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }
                count.pop();
            } else {

                int temp = 1;

                if (!count.isEmpty() && stack.peek() == c) {
                    temp += count.pop();
                }
                stack.push(c);
                count.push(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}

