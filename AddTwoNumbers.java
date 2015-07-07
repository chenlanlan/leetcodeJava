/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        int num1 = 0, num2 = 0, sum = 0, re = 0;
        while (l1 != null || l2 != null){
            if (l1 == null) {
                num1 = 0;
            }else{
                num1 = l1.val;
            }
            if (l2 == null){
                num2 = 0;
            }else{
                num2 = l2.val;
            }
            sum = num1 + num2 + re;
            p.next = new ListNode(sum % 10);
            re = sum / 10;
            p = p.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (re > 0){
            p.next = new ListNode(re);
        }
        return res.next;
    }
    
}