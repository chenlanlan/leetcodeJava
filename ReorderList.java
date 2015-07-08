/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p = slow.next;
        slow.next = null;
        ListNode pPre = null;
        ListNode pNext = p.next;
        while (p != null){
            pNext = p.next;
            p.next = pPre;
            pPre = p;
            p = pNext;
        }
        ListNode l1 = head;
        ListNode l2 = pPre;
        while (l1 != null && l2 != null){
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;
            l1.next = l2;
            l2.next = l1Next;
            l1 = l1Next;
            l2 = l2Next;
        }
    }
}