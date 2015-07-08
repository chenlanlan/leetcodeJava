/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode newList = new ListNode(0);
        newList.next = head;
        ListNode p = newList, q = head;
        while (q != null){
            if (q.val == val){
                p.next = q.next;
            }else{
                p = p.next;
            }
            q = q.next;
        }
        return newList.next;
    }
}