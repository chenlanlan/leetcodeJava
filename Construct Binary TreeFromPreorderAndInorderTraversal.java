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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode build(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (iei < isi || iei - isi != pei - psi) return null;
        TreeNode root = new TreeNode(preorder[psi]);
        int riii = -1;
        int i = isi;
        while (i <= iei) {
            if (inorder[i] == root.val) {
                riii = i;
                break;
            }
            i++;
        }
        if (riii == -1) {
            return root;
        }
        int nodeLen = riii - isi;
        root.left = build(preorder, psi + 1, psi + nodeLen, inorder, isi, riii - 1);
        root.right = build(preorder, psi + nodeLen + 1, pei, inorder, riii + 1, iei);
        return root;
    }
}