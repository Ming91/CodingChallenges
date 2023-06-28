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
    public int maxLevelSum(TreeNode root) {
        int x = 1;
        int currentLevel = 0;
        int max = root.val;
        int queueSize = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            currentLevel += 1;
            int sum = 0;
            int childSize = 0;
            //childQueue.clear();
            for (int i = 0; i < queueSize; i++) {
                TreeNode n = q.remove();
                //System.out.println(n.val);
                sum += n.val;
                if (n.left != null) {
                    childSize += 1;
                    q.add(n.left);
                }
                if (n.right != null) {
                    childSize += 1;
                    q.add(n.right);
                }
            }
            queueSize = childSize;
            //System.out.println("level, sum: " + currentLevel + "," + sum);
            if (sum > max) {
                x = currentLevel;
                max = sum;
            }
        }
        return x;
    }
}
