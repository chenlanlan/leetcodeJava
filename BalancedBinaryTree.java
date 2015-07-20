/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return true;
        if (Math.abs(Depth(root.left) - Depth(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }

    public int Depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(Depth(root.left), Depth(root.right)) + 1;
    }
}