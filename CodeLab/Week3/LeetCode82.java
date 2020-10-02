//https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/


public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){

            return null;
        }
        ListNode newList = new ListNode(-1);
        newList.next = head;
        ListNode previous = newList;
        ListNode current = head;
        ListNode next = head.next;
        while(next != null) {
            if(next.val == current.val) {
                while(next != null && next.val == current.val) {
                    next = next.next;
                }
                current = next;
                previous.next = current;
                if(next != null)
                    next = next.next;
            }
            else {
                previous = previous.next;
                current = current.next;
                next = next.next;
            }
        }
        return newList.next;
    }



    public class ListNode {
   int val;
    ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
