// LeetCode 75 Binary Tree - DFS Q2
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
    void dfs1(TreeNode root, List<Integer> list) {
        if (root == null) {
            return ;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return ;
        }
        dfs1(root.left, list);
        dfs1(root.right, list);
        return ;
        
    }
    boolean dfs2(TreeNode root, List<Integer> l1, List<Integer> l2) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            if (l1.size() == l2.size() || l1.get(l2.size()) != root.val) {
                return false;
            }
            l2.add(root.val);
            return true;
        }
        
        boolean fl = dfs2(root.left, l1, l2);
        if (!fl) return false;

        boolean fr = dfs2(root.right, l1, l2);
        return fr;
        
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs1(root1, l1);
        boolean f = dfs2(root2, l1, l2);
        if (f) {
            return l1.size() == l2.size();
        }
        return f;

    }
}
// 没用两个一样的算列表，第二次dfs直接跟第一个list比较，但是要比较长度
