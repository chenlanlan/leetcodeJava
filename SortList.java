/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode right = null;
        if (mid != null){
            right = mid.next;
            mid.next = null;
        }
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(right);
        ListNode SortedList = mergeLists(l1, l2);
        return SortedList;
    }
    public ListNode getMid(ListNode head){
        if (head == null || head.next == null)return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode mergeLists(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l1 != null || l2 != null){
            if (l2 == null || l1 != null && l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        return res.next;
    }
}