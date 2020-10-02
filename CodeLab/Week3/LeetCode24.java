//https://leetcode.com/problems/swap-nodes-in-pairs/

public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
            int curr = temp.val;
            temp.val = temp.next.val;
            temp.next.val = curr;
            temp = temp.next.next;
        }
        return head;
    }

    public class ListNode {
    int val;
    ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
