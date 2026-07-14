/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // 순환 구조 있는지 true/false 판단
    public boolean hasCycle2(ListNode head) {
        ListNode pointer = head;
        // hashset 에 노드 주소값을 담아두고 판단
        Set<ListNode> set = new HashSet<>();
        while(pointer != null) {
            // set에 존재하면 순환 있다고 판단, 리턴 true
            if(set.contains(pointer)) {
                return true;
            }
            set.add(pointer);
            pointer = pointer.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next; // 1칸씩 이동
            fast = fast.next.next; // 2칸씩 이동

            // 언젠간 겹치게 될 때 return true
            if(slow == fast) {
                return true;
            }
        }

        return false;
    }    
}