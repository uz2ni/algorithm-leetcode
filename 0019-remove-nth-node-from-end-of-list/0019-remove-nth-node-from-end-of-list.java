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
        // head(첫노드) 앞에 둘 dummy 노드 초기화
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = dummy;
        
        // right을 n만큼 옮기기
        for(int i=0; i<n; i++) {
            right = right.next;
        }

        // left, right를 함께 right이 끝 노드 갈때까지 이동
        while(right.next != null) {
            left = left.next;
            right = right.next;
        }

        // 삭제 노드 건너뛰고 연결
        left.next = left.next.next;
        
        return dummy.next;
    }
}
