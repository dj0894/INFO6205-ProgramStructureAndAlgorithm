/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */

class LeetCode1290 {
    public int getDecimalValue(ListNode head) {

        int power = 1;
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        for(int i=0;i<len-1;i++) {
            power = power*2;
        }
        temp = head;
        int value = 0;
        while (temp != null) {
            value += (power * temp.val);
            power = power/2;
            temp = temp.next;
        }
        return value;

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}