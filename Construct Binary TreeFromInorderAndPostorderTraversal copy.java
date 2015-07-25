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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode build(int[] inorder, int isi, int iei, int[] postorder, int psi, int pei) {
        if (iei < isi || iei - isi != pei - psi) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pei]);
        int riii = -1;
        int i = isi;
        while (i <= iei) {
            if (inorder[i] == root.val) {
                riii = i;
                break;
            }
            i++;
        }
        if (riii == -1) return root;
        int nodeLen = riii - isi;
        root.left = build(inorder, isi, riii - 1, postorder, psi, psi + nodeLen - 1);
        root.right = build(inorder, riii + 1, iei, postorder, psi + nodeLen, pei - 1);
        return root;
    }
}