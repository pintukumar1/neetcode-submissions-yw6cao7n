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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(l1 != null || l2 != null) {

            int total = ((l1 != null && l1.val > 0) ? l1.val : 0) +  
                ((l2 !=null && l2.val > 0) ? l2.val : 0) + carry;
            
            int value = total % 10;
            carry = total/10;

            current.next = new ListNode(value);
            current = current.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if(carry>0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
