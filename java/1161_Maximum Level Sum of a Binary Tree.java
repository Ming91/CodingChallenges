// LeetCode 75 Binary Tree - BFS Q2
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
    int len;
    // List<Integer> arr;
    long[] sum;
    void dfs(TreeNode curr, int level) {
        if (curr == null) {
            return ;
        }
        if (len < level) {
            // arr.add(0);
            len++;
        }
        // arr.set(level - 1, arr.get(level - 1) + curr.val);
        sum[level] += curr.val;
        dfs(curr.left, level + 1);
        dfs(curr.right, level + 1);
        return ;
    }
    public int maxLevelSum(TreeNode root) {
        len = 0;
        // arr = new ArrayList<>();
        sum = new long[10_004];
        dfs(root, 1);
        long max = root.val;
        int idx = 1;
        for (int i = 1; i <= len; i++) {
            // if (max < arr.get(i - 1)) {
            //     max = arr.get(i - 1);
            //     idx = i;
            // }
            if (max < sum[i]) {
                max = sum[i];
                idx = i;
            }
        }
        return idx;
    }
}
// better idea:
//  queue太慢, 用array或者list存每一层的sum, 来dfs中求和
//  array会占较大空间, 有人探测出36层就行, 但是设置最大10_004层记录层高也足够快
//  list占空间小, 但是慢得多

// 用queue来bfs
// class Solution {
//     public int maxLevelSum(TreeNode root) {
//         int x = 1;
//         int currentLevel = 0;
//         int max = root.val;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while (!q.isEmpty()) {
//             currentLevel += 1;
//             int sum = 0;
//             int queueSize = q.size();
//             //childQueue.clear();
//             for (int i = 0; i < queueSize; i++) {
//                 TreeNode n = q.remove();
//                 //System.out.println(n.val);
//                 sum += n.val;
//                 if (n.left != null) {
//                     q.add(n.left);
//                 }
//                 if (n.right != null) {
//                     q.add(n.right);
//                 }
//             }
//             //System.out.println("level, sum: " + currentLevel + "," + sum);
//             if (sum > max) {
//                 x = currentLevel;
//                 max = sum;
//             }
//         }
//         return x;
//     }
// }
