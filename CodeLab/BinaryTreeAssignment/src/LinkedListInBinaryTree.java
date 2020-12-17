//https://leetcode.com/problems/linked-list-in-binary-tree/


import java.util.ArrayList;
import java.util.List;

public class LinkedListInBinaryTree {
        public boolean isSubPath(ListNode head, TreeNode root) {
            List<Integer> v = new ArrayList<>();
            while (head != null) {
                v.add(head.val);
                head = head.next;
            }
            int i = 1, pre = 0, n = v.size();
            int[] idx = new int[n];
            while (i < n) {
                if (v.get(i) == v.get(pre)) idx[i++] = ++pre;
                else if (pre != 0) pre = idx[pre - 1];
                else idx[i++] = 0;
            }
            return dfs(root, v, idx, 0);
        }

        private boolean dfs(TreeNode t, List<Integer> v, int[] idx, int i) {
            if (i == idx.length) return true;
            if (t == null) return false;
            if (t.val == v.get(i)) return dfs(t.left, v, idx, i + 1) || dfs(t.right, v, idx, i + 1);
            else if (i != 0) return dfs(t, v, idx, idx[i - 1]);
            else return dfs(t.left, v, idx, 0) || dfs(t.right, v, idx, 0);

        }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
