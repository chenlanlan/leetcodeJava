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
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int max = Integer.MIN_VALUE;
        pathSum(root, max);
        return max;
    }
    
    public int pathSum(TreeNode root, int max) {
        if (root == null) return 0;
        int sum = root.val;
        int leftSum = pathSum(root.left, max);
        int rightSum = pathSum(root.right, max);
        if (leftSum > 0) {
            sum += leftSum;
        }
        if (rightSum > 0) {
            sum += rightSum;
        }
        max = Math.max(max, sum);
        sum = Math.max(leftSum, rightSum);
        if (sum > 0) {
            return root.val + sum;
        } else {
            return root.val;
        }
    }
}