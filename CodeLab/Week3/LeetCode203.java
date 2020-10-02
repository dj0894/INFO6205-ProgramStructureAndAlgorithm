//https://leetcode.com/problems/remove-linked-list-elements/

public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;
        ListNode prev = head;
        ListNode temp = prev.next;
        while(temp != null){
            if(temp.val == val)
                temp = temp.next;
            else{
                prev.next = temp;
                prev = temp;
                temp = prev.next;
            }

        }
        prev.next = null;

        return head.val == val? head.next : head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
