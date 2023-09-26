// Top Interview 150 Binary Tree General Q13
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
    boolean exist(int t, int d, TreeNode r) {
        int upper = (int)Math.pow(2, d);
        t += upper;
        int curr = 1;
        TreeNode root = r;
        for (int i = 1; i <= d && root != null; i++) {
            upper /= 2;
            int p = upper * (2 * curr + 1);
            if (t < p) {
                root = root.left;
                curr = curr * 2;
            } else {
                root = root.right;
                curr = curr * 2 + 1;
            }
        }
        return root != null;
    }
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }
        int d = 0;
        TreeNode curr = root;
        while (curr.left != null) {
            d++;
            curr = curr.left;
        }
        int upper = (int)Math.pow(2, d);
        int l = 0, r = upper - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (exist(mid, d, root)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return upper + l;
    }
}
// [Editorial]
//  1. calc depth of the tree. 
//  2. last level has [1, 2*d] node. binary search to find last one. 
//  3. use a method to check a node if exist on last level. 
//      (mine is not good. but think of a method is more important.)
