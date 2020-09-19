/**
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/solution/
 */
class LeetCode708 {
    public Node insert(Node head, int insertVal) {
        Node insertNode= new Node(insertVal);
        if(head == null){
            insertNode.next = insertNode;
            return insertNode;
        }
        Node temp = head;
        while(temp.next != head
                && !((temp.val <= insertVal && insertVal <= temp.next.val)
                || (temp.val > temp.next.val && (temp.next.val > insertVal || temp.val < insertVal)))){
            temp = temp.next;
        }

        insertNode.next = temp.next;
        temp.next = insertNode;
        return head;

    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

}