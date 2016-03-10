// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return fetchNode(nums, 0, n-1);
    }

    public TreeNode fetchNode(int[] nums, int start, int end){
        if (start<=end) {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = fetchNode(nums, start, mid-1);
            node.right = fetchNode(nums, mid+1, end);
            return node;
        }
        return null;
    }
}
