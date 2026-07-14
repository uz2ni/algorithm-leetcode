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
    public boolean hasCycle(ListNode head) {
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
}