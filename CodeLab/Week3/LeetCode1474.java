
//https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/

public class LeetCode1474 {


        public ListNode deleteNodes(ListNode head, int m, int n) {

            ListNode temp = new ListNode();
            temp.next = head;
            ListNode current = temp;
            while(current != null){
                int mCopy = m;
                int nCopy = n;
                while(mCopy-- >0 && current != null){
                    current = current.next;
                }
                while(nCopy-- >0 && current != null && current.next != null){
                    current.next = current.next.next;
                }
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
