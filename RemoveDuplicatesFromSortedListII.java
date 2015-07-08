/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newList = new ListNode(0);
        newList.next = head;
        ListNode p = newList, q = head;
        while (p.next != null){
            while (q.next != null && q.next.val == p.next.val){
                q = q.next;
            }
            if (q == p.next){
                p = p.next;
                q = q.next;
            }else{
                p.next = q.next;
            }
        }
        return newList.next;
    }
    
}
