// LeetCode 75 Binary Tree - BFS Q1
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
class Solution {
    void dfs(List<Integer> ans, TreeNode curr, int len) {
        if (curr == null) {
            return ;
        }
        if (ans.size() == len) {
            ans.add(curr.val);
        }
        dfs(ans, curr.right, len + 1);
        dfs(ans, curr.left, len + 1);
        return ;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, root, 0);
        return ans;
    }
}
// class Solution {
    
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if (root == null) {
//             return ans;
//         }
//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);
//         while (!q.isEmpty()) {
//             int size = q.size();
//             ans.add(q.peek().val);
//             for (int i = 0; i < size; i++) {
//                 TreeNode curr = q.poll();
//                 if (curr.right != null) {
//                     q.offer(curr.right);
//                 }
//                 if (curr.left != null) {
//                     q.offer(curr.left);
//                 }
//             }
//         }
//         return ans;
//     }
// }
