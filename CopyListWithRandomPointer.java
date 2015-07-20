/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 * int label;
 * RandomListNode next, random;
 * RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode result = null, pOld = head, pNew = result, pOldNext = pOld.next;
        while (pOld != null) {
            pOldNext = pOld.next;
            pNew = new RandomListNode(pOld.label);
            pOld.next = pNew;
            pNew.next = pOldNext;
            if (result == null) {
                result = pNew;
            }
            pOld = pOldNext;
        }
        pOld = head;
        while (pOld != null) {
            if (pOld.random != null) {
                pOld.next.random = pOld.random.next;
            }
            pOld = pOld.next.next;
        }
        pOld = head;
        pNew = result;
        while (pNew.next != null) {
            pOld.next = pNew.next;
            pOld = pOld.next;
            pNew.next = pOld.next;
            pNew = pNew.next;
        }
        pOld.next = null;
        pNew.next = null;
        return result;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode newHead = new RandomListNode(head.label);
        addNextAndRandom(head, newHead);
        RandomListNode p = newHead.next;
        head = head.next;
        while (head != null) {
            addNextAndRandom(head, p);
            p = p.next;
            head = head.next;
        }
        return newHead;

    }

    public void addNextAndRandom(RandomListNode oldNode, RandomListNode newNode) {
        newNode.next = (oldNode.next == null) ? null : new RandomListNode(oldNode.next.label);
        newNode.random = (oldNode.random == null) ? null : new RandomListNode(oldNode.random.label);
    }
}