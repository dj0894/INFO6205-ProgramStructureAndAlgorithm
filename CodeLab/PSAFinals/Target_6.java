import java.util.ArrayList;
import java.util.List;

public class Target_6 {
    public boolean findTarget(TreeNode root, int k) {
        boolean res = false;
        if (root != null) {
            List<Integer> inOrder = new ArrayList<>();
            getInOrder(root, inOrder);

            int s = 0, e = inOrder.size()-1;
            while (s<e) {
                int currSum = inOrder.get(s) + inOrder.get(e);
                if (currSum == k) {
                    res = true;
                    break;
                } else if (currSum > k) {
                    e--;
                } else {
                    s++;
                }
            }
        }
        return res;
    }

    public void getInOrder(TreeNode root, List<Integer> inOrder) {
        if (root == null) return;
        getInOrder(root.left, inOrder);
        inOrder.add(root.val);
        getInOrder(root.right, inOrder);
    }

    class TreeNode {
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
