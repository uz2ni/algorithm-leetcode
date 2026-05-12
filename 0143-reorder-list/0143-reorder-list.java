/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;

        // 1. middle 찾기
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 뒤 절반 reverse
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;

        while(second != null) {

            ListNode next = second.next;

            second.next = prev;

            prev = second;
            second = next;
        }

        // reverse된 뒤 절반의 head
        ListNode secondHalf = prev;

        // 3. merge
        ListNode first = head;

        while(secondHalf != null) {

            ListNode tmp1 = first.next;
            ListNode tmp2 = secondHalf.next;

            first.next = secondHalf;
            secondHalf.next = tmp1;

            first = tmp1;
            secondHalf = tmp2;
        }
    }
}