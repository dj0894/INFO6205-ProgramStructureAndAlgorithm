
/*Q2
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/

public class MergeSortedLinkedList_2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode current1 = l1;
        ListNode current2 = l2;

        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (current1 != null && current2 != null) {
            if (current1.val <= current2.val) {
                cur.next = current1;
                current1 = current1.next;
            } else {
                cur.next = current2;
                current2 = current2.next;
            }

            cur = cur.next;
        }

        while (current1 != null) {
            cur.next = current1;
            current1 = current1.next;
            cur = cur.next;
        }

        while (current2 != null) {
            cur.next = current2;
            current2 = current2.next;
            cur = cur.next;
        }

        cur.next = null;

        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}




