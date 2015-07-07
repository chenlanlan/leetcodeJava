
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeList = new ListNode(0);
        ListNode p = mergeList;
        while (l1 != null || l2 != null){
            if (l2 == null || l1 != null && l1.val <= l2.val){
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
        return mergeList.next;
    }
}