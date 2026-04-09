/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        int count = 0;
        while(count < n) {
            p2 = p2.next;
            count++;
        }

        if (p2 == null) {
            return head.next;
        }

        while(p2!= null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode next = p1.next.next;
        p1.next = next;

        return head;
    }
}
