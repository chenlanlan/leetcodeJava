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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> array = new ArrayList<Integer>();
        if (root == null) return res;
        int curLevel = 1, nextLevel = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pop();
            array.add(cur.val);
            curLevel--;
            if (cur.left != null) {
                queue.add(cur.left);
                nextLevel++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                nextLevel++;
            }
            if (curLevel == 0) {
                res.add(new ArrayList(array));
                array.clear();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return res;
    }
    
}