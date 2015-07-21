/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        int countA = 0, countB = 0;
        while (l1 != null) {
            countA++;
            l1 = l1.next;
        }
        while (l2 != null) {
            countB++;
            l2 = l2.next;
        }
        l1 = headA;
        l2 = headB;
        if (countB > countA) {
            int count = countB - countA;
            while (count > 0) {
                l2 = l2.next;
                count--;
            }
        } else {
            int count = countA - countB;
            while (count > 0) {
                l1 = l1.next;
                count--;
            }
        }
        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                return l1;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        return null;
    }

}