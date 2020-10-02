//https://leetcode.com/problems/valid-parentheses/



public class LeetCode20 {

    public boolean isValid(String s) {

        int i = 0;
        int len = s.length() / 2;
        while (!s.isEmpty() && i < len) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            i++;
        }
        return s.isEmpty();
    }

}
