/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode mistake1, mistake2;
    TreeNode pre;
    
    public void recursiveTraversal(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            recursiveTraversal(root.left);
        }
        if(pre != null && root.val < pre.val) {
            if (mistake1 == null) {
            mistake1 = pre;
            mistake2 = root;
            } else {
                mistake2 = root;
            }
        }
        pre = root;
        if (root.right != null){
            recursiveTraversal(root.right);
        }
    }
    public void recoverTree(TreeNode root) {
        recursiveTraversal(root);
        if(mistake1 != null && mistake2 != null) {
            int temp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = temp;
        }
    }
}