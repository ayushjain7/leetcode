//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || inorder.length==0)
            return null;
        int size = inorder.length;
        return buildTree(inorder, 0, size-1, postorder, 0, size-1);
    }
    
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inEnd < inStart || postEnd < postStart)
            return null;
        if(inEnd == inStart)
            return new TreeNode(inorder[inStart]);
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = findIndex(inorder, postorder[postEnd]);
        root.left = buildTree(inorder, inStart, inIndex-1, postorder, postStart, postStart+inIndex-1-inStart);
        root.right = buildTree(inorder, inIndex+1, inEnd, postorder, postStart+inIndex-inStart, postEnd-1);
        return root;
    }
    
    public int findIndex(int[] array, int element){
        for(int i=0; i<array.length; i++){
            if (array[i] == element)
                return i;
        }
        return -1;
    }
}
