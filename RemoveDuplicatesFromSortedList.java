/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode p = head, q = head.next;
        while (q != null) {
            if (q.val == p.val) {
                p.next = q.next;
            } else {
                p = p.next;
            }
            q = q.next;
        }
        return head;
    }

}
