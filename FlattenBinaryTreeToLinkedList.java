// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode resultHead = new TreeNode(root.val);
        TreeNode resultCurNode = resultHead;
        Stack<TreeNode> preorder = new Stack<>();
        if(root.right!=null)
            preorder.push(root.right);
        if(root.left!=null)
            preorder.push(root.left);
        while (!preorder.isEmpty()){
            TreeNode node = preorder.pop();
            if(node.right!=null)
                preorder.push(node.right);
            if(node.left!=null)
                preorder.push(node.left);
            resultCurNode.left = null;
            resultCurNode.right = new TreeNode(node.val);
            resultCurNode = resultCurNode.right;
        }
        root.val = resultHead.val;
        root.left = resultHead.left;
        root.right = resultHead.right;
    }
}
