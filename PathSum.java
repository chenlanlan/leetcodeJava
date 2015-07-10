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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return PathSum(root, sum, 0);
    }
    public boolean PathSum(TreeNode root, int sum, int temp){
        if (root == null) return false;
        temp += root.val;
        if (root.right == null && root.left == null){
            if (temp == sum) return true;
            else return false;
        }
        return PathSum(root.left, sum, temp) || PathSum(root.right, sum, temp);
    }
}