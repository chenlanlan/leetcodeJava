/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        int n = 1;
        while (p.next != null) {
            p = p.next;
            n++;
        }
        if (k % n == 0) return head;
        ListNode q = head;
        int q_step = 1;
        while (q_step < n - k % n) {
            q = q.next;
            q_step++;
        }
        ListNode start = q.next;
        q.next = null;
        p.next = head;
        return start;
    }

}