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
    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root != null && isFather(root, p) && isFather(root, q)) {
            ans = root;
            lowestCommonAncestor(root.left, p, q);
            lowestCommonAncestor(root.right, p, q);
        }
        return ans;
    }

    public Boolean isFather(TreeNode n1, TreeNode n2) {
        if (n1 == null) return false;
        else if (n1 == n2) return true;
        else return isFather(n1.left, n2) || isFather(n1.right, n2);
    }
}