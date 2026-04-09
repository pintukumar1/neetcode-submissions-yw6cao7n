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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevGroupTail = null;
        ListNode newHead = null; 
        ListNode current = head;

        while(current != null) {
            int count = 1;

            ListNode groupHead = current;
            while(current != null && count < k) {
                current = current.next;
                count++;
            }

            if(current == null) {
                if(prevGroupTail != null) {
                    prevGroupTail.next = groupHead;
                }
                break;
            }

            ListNode nextGroup = current.next;
            current.next = null;

            ListNode prev = null;
            ListNode node = groupHead;

            while(node != null) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            if(newHead == null) {
                newHead = prev;
            }

            if(prevGroupTail != null) {
                prevGroupTail.next = prev;
            }

            prevGroupTail = groupHead;
            current = nextGroup;
        }

        if(newHead != null) {
            return newHead;
        } else { 
            return head;
        }
    }
}
