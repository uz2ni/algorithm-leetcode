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
    public boolean hasCycle(ListNode head) {
        ListNode now = head;
        Set<ListNode> visited = new HashSet<>();
        while(true) {
            if(now == null) {
              return false;  
            }else if(visited.contains(now)){
                return true;
            }else {
                visited.add(now);
                now = now.next;
            }
        }
    }
}
