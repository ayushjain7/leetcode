// https://leetcode.com/problems/binary-tree-preorder-traversal/

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> stack = new ArrayList<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode element = stack.remove(stack.size()-1);
            if(element != null){
                result.add(element.val);
                stack.add(element.right);
                stack.add(element.left);
            }
        }
        return result;
    }

}
