/**
 * https://leetcode.com/problems/partition-list/
 */
class LeetCode86 {
    public ListNode partition(ListNode head, int x) {

        ListNode smallerHead=new ListNode();
        ListNode smallerList = smallerHead;
        ListNode greaterHead=new ListNode();
        ListNode greaterList = greaterHead;

        ListNode temp=head;

        while(temp!=null){

            if(temp.val<x){
                smallerList.next = temp;
                smallerList = smallerList.next;
            }
            else{
                greaterList.next = temp;
                greaterList = greaterList.next;
            }
            temp = temp.next;
        }


        greaterList.next = null;
        smallerList.next = greaterHead.next;
        return smallerHead.next;


    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}