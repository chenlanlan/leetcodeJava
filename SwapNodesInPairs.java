/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        ListNode fast = head.next, slow = head, next = head;
        while (fast != null){
            next = fast.next;
            fast.next = slow;
            slow.next = next;
            pre.next = fast;
            pre = slow;
            if (next != null){
                fast = next.next;
                slow = next;
            }else{
                break;
            }
        }
        return res.next;
    }
}