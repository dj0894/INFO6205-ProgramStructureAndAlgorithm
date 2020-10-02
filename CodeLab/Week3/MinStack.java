//https://leetcode.com/problems/min-stack/

public class MinStack {

    /** initialize your data structure here. */
    private static class Node {
        int val;
        int minVal;
        Node next;

        Node (int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public void setMinVal(int minVal) {
            this.minVal = minVal;
        }

        public int getMinVal() {
            return this.minVal;
        }

    }

    private Node top;

    public MinStack() {
        top = null;
    }

    public void push(int x) {
        Node newNode = new Node(x, null);
        if(top == null || getMin() > x) {
            newNode.setMinVal(x);
        }else {
            newNode.setMinVal(getMin());
        }
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.getMinVal();
    }

}
