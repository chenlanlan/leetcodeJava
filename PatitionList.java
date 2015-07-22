/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class PatitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode p = new ListNode(0), q = new ListNode(0);
        ListNode pStart = p, qStart = q;
        while (head != null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = qStart.next;
        return pStart.next;
    }
}
