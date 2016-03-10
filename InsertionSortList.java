// https://leetcode.com/problems/insertion-sort-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;
        ListNode prevNode = head;
        ListNode curNode = head.next;
        while(curNode!=null){
            ListNode posNode = head;
            if(posNode.val > curNode.val){
                prevNode.next = curNode.next;
                curNode.next = posNode;
                head = curNode;
                curNode = prevNode.next;
                continue;
            }
            while(posNode.next != curNode && posNode.next.val < curNode.val){
                posNode = posNode.next;
            }
            if(posNode.next!=curNode){
                prevNode.next = curNode.next;
                curNode.next = posNode.next;
                posNode.next = curNode;
                curNode = prevNode;
            }
            
            prevNode = curNode;
            curNode = curNode.next;
        }
        return head;
    }
}
