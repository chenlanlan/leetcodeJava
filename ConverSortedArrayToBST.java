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
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }
    
    public TreeNode convert(int[] nums, int left, int right){
        if (left >right) return null;
        int mid = (left + right) / 2;
        TreeNode leftTree = convert(nums, left, mid - 1);
        TreeNode rightTree = convert(nums, mid + 1, right);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}