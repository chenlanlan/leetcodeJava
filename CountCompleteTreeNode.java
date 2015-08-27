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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.right == null) return 2;
        int leftNodes = countLeft(root.left);
        int rightNodes = countRight(root.right);
        if (leftNodes == rightNodes) return (1 << leftNodes) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    public int countLeft(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
    
    public int countRight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}