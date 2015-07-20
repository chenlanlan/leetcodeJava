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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        inorder(root.left, res);
        inorder(root.right, res);
    }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        HashSet<TreeNode> hs = new HashSet<TreeNode>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            if (hs.contains(temp)) {
                res.add(temp.val);
                continue;
            }
            hs.add(temp);
            if (temp.right != null) {
                st.push(temp.right);
            }
            st.push(temp);
            if (temp.left != null) {
                st.push(temp.left);
            }
        }
        return res;
    }
}