/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
class LeetCode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast;
        ListNode slow;
        fast=head;
        slow=head;

        if(head ==null || head.next==null){// if there is 0 or 1 node in linkedList
            head=null;
            return head;
        }

        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        while(fast!=null&&fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        if (fast==null) { // n is equal to number of elements
            head = head.next;
            return head;
        }

        slow.next=slow.next.next;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}