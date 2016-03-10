//https://leetcode.com/problems/binary-search-tree-iterator/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> nodes = new Stack<>();

    public BSTIterator(TreeNode root) {
        enqueueLeftTree(root);        
    }
    
    private void enqueueLeftTree(TreeNode curNode){
        while(curNode!=null){
            nodes.push(curNode);
            curNode = curNode.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curNode = nodes.pop();
        int toRet = curNode.val;
        if(curNode.right != null){
            curNode = curNode.right;
            nodes.push(curNode);
            enqueueLeftTree(curNode.left);
        }
        return toRet;
    }
}
