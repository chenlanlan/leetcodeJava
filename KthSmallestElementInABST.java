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
    //inorder recursive
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorderSearch(root, list, k);
        return list.get(k - 1);
    }

    public void inorderSearch(TreeNode node, ArrayList<Integer> list, int k) {
        if (list.size() >= k) return;
        if (node.left != null) inorderSearch(node.left, list, k);
        list.add(node.val);
        if (node.right != null) inorderSearch(node.right, list, k);
    }

    //binary search
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) return kthSmallest(root.left, k);
        else if (k > count + 1) return kthSmallest(root.right, k - count - 1);
        return root.val;
    }

    public int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}