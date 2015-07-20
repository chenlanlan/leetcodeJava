/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

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
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }
        return convert(head, 0, count - 1);
    }

    public TreeNode convert(ListNode head, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        ListNode p = head;
        for (int i = left; i < mid; i++) {
            p = p.next;
        }
        TreeNode leftTree = convert(head, left, mid - 1);
        TreeNode rightTree = convert(p.next, mid + 1, right);
        TreeNode root = new TreeNode(p.val);
        root.left = leftTree;
        root.right = rightTree;
        return root;

    }
}