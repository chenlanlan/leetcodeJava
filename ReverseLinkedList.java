/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = new ListNode(0);
        ListNode pPre = null, pNext = head.next, p = head;
        while (p != null){
            pNext = p.next;
            p.next = pPre;
            pPre = p;
            p = pNext;
        }
        node.next = pPre;
        return node.next;
    }
}