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
    // 통과 - 개선 필요
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;

        ListNode head = null; // 반환용
        ListNode tail = null; // 꼬리, 노드 늘리는용

        // 첫노드 결정

        if(p1 == null) return p2;
        if(p2 == null) return p1;

        if(p1.val <= p2.val) {
            head = p1;
            p1 = p1.next;
        }else {
            head = p2;
            p2 = p2.next;
        }
        tail = head;

        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;
            }else {
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;        
            }   
        }

        // 남은 노드 잇기
        ListNode remains = (p1 != null) ? p1 : p2;
        while(remains != null) {
            tail.next = remains;
            remains = remains.next;
        }

        return head;
    }

    // 통과
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;        
            }   
            tail = tail.next;
        }

        // 남은 노드 잇기
        if(list1 != null) {
            tail.next = list1;
        }else {
            tail.next = list2;
        }

        return head.next;
    }    
}