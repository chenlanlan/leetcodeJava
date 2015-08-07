/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode res = merge(lists, 0, lists.length - 1);
        return res;
    }
    
    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = (left + right) / 2;
        ListNode list1 = merge(lists, left, mid);
        ListNode list2 = merge(lists, mid + 1, right);
        return merge2Lists(list1, list2);
    }
    
    public ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode root = res;
        while (list1 != null || list2 != null) {
            if (list2 == null || list1 != null && list1.val < list2.val) {
                res.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                res.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            res = res.next;
        }
        return root.next;
    }
}