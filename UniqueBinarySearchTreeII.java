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
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }
    
    public List<TreeNode> generate(int start, int end) {
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for(int rootValue = start; rootValue <= end; rootValue++) {
            List<TreeNode> leftSubTrees = generate(start, rootValue - 1);
            List<TreeNode> rightSubTrees = generate(rootValue + 1, end);
            for (TreeNode leftSubTree : leftSubTrees) {
                for (TreeNode rightSubTree : rightSubTrees) {
                    TreeNode root = new TreeNode(rootValue);
                    root.left = leftSubTree;
                    root.right = rightSubTree;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}