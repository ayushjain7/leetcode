//https://leetcode.com/problems/different-ways-to-add-parentheses/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode node = head;
        int size = 0;
        while(node!=null){
            size++;
            node = node.next;
        }
        node = head;
        int[] list = new int[size];
        for(int i=0; i<size; i++){
            list[i] = node.val;
            node = node.next;
        }
        return makeTree(list, 0, size-1);
    }
    
    public TreeNode makeTree(int[] list, int start, int end){
        if(end<start)
            return null;
        int mid = (start+end)/2;
        TreeNode head = new TreeNode(list[mid]);
        head.left = makeTree(list, start, mid-1);
        head.right = makeTree(list, mid+1, end);
        return head;
    }
}
