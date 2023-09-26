// Top Interview 150 Binary Tree General Q12
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    // Stack<TreeNode> stack;
    Deque<TreeNode> stack;
    void dfs(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    public BSTIterator(TreeNode root) {
        // stack = new Stack<>();
        stack = new ArrayDeque<>();
        dfs(root);
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        if (curr.right != null) {
            dfs(curr.right);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
// [Editorial] 
//  Basic idea is processing inorder tranversal iteratively. 
//  The approach is using stack. 
//      1. push node to stack, go to its left. 
//      2. if no left child, pop out, process and go to its right. 
//      while (!stack.isEmpty() || curr != null)
//  [Practice More] 
//  Sometimese just consider recursively method since its simpler and faster. 
//  But always need to understand the iterative method. Some problem only works this way. 

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
