//Construct Binary Tree from Preorder and Inorder Traversal

import java.util.HashMap;

public class ConstructBinaryTree {

    class Solution {

        HashMap<Integer,Integer> map=new HashMap();

        public TreeNode buildTree(int[] pre, int[] in) {

            for(int i=0;i<in.length;i++){
                map.put(in[i],i);
            }

            return help(pre,in,0,pre.length-1);
        }
        int idx=0;

        public TreeNode help(int[] pre,int[] in,int si,int ei){
            if(si>ei)
                return null;
            int i=map.get(pre[idx]);
            // we got i
            TreeNode node=new TreeNode(pre[idx]);

            idx++;
            node.left=help(pre,in,si,i-1);
            node.right=help(pre,in,i+1,ei);

            return node;

        }
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
