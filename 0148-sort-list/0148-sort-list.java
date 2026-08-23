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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode mid = findMiddleAndSplit2(head);

        // 첫노드~mid 왼쪽노드 분할
        ListNode left = sortList(head);
        // mid~마지막노드 분할
        ListNode right = sortList(mid);

        // 병합
        return merge(left, right);
    }

    // 중앙값 찾기1 : 노드 길이 카운팅 후 중간까지 재탐색, O(2N)
    public ListNode findMiddleAndSplit(ListNode head) {
        // 노드 길이 카운팅
        ListNode cur = head;
        int cnt = 0;
        while(cur != null) {
            cnt++;
            cur = cur.next;
        }

        // 앞쪽 절반의 마지막 노드까지 이동
        ListNode prev = head;
        for(int i=0; i<cnt/2-1; i++) {
            prev = prev.next;
        }

        ListNode mid = prev.next;
        prev.next = null; // 앞쪽 절반의 꼬리는 null        
        return mid;
    }

    // 중앙값 찾기2 : 투포인터 slow/fast, O(N)
    public ListNode findMiddleAndSplit2(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public ListNode merge(ListNode left, ListNode right) {
        if(left == null) return right;
        if(right == null) return left;
        
        ListNode start = new ListNode(-1);
        ListNode tail = start;

        // left, right 옮기면서 tail.next에 다음 값 연결
        while(left != null && right != null) {
            if(left.val > right.val) {
                tail.next = right;
                right = right.next;
            }else {
                tail.next = left;
                left = left.next;
            }
                tail = tail.next;            
        }

        tail.next = (left != null) ? left : right;
        
        return start.next;
    }
}