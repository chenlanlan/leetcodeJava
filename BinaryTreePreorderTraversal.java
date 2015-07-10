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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }
    private void preorder(TreeNode root, List<Integer> res){
        if (root == null) return;
        preorder(root.left, res);
        res.add(root.val);
        preorder(root.right, res);
    }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while (!st.isEmpty()){
            TreeNode temp = st.pop();
            res.add(temp.val);
            if (temp.right != null){
                st.push(temp.right);
            }
            if (temp.left != null){
                st.push(temp.left);
            }
        }
        return res;
    }
}