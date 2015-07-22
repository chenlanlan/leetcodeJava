/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        // reverse
        p = head.next;
        ListNode pre = head, next = head;
        head.next = null;
        for (int i = 0; i < len / 2 - 1; i++) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        // compare
        if (len % 2 == 1) p = p.next;
        for (int i = 0; i < len / 2; i++) {
            if (pre.val != p.val) return false;
            pre = pre.next;
            p = p.next;
        }
        return true;
    }
}