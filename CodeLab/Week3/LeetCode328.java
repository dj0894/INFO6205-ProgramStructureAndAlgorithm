
//https://leetcode.com/problems/odd-even-linked-list/


public class LeetCode328 {

    public ListNode oddEvenList(ListNode head) {

        if (head == null){
            return null;
        }
        ListNode odd_pointer = head;
        ListNode even_pointer = head.next;
        ListNode evenHead = head.next;

        while (even_pointer != null && even_pointer.next != null) {
            odd_pointer.next = even_pointer.next;
            odd_pointer = odd_pointer.next;
            even_pointer.next = odd_pointer.next;
            even_pointer = even_pointer.next;
        }
        odd_pointer.next = evenHead;
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
