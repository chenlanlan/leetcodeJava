
 // Definition for singly-linked list.

 
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) return head;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode preStart = node, p = head;
        for (int i = 0; i < m - 1; i++){
            preStart = preStart.next;
            p = p.next;
        }
        ListNode pre = p, cur = p.next, next = p, Start = p;
        for (int i = m + 1; i <= n; i++){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        Start.next = cur;
        preStart.next = pre;
        return node.next;
    }
}