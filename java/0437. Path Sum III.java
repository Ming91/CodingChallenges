// LeetCode 75 Binary Tree - DFS Q4
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

    // use global var to simplify the parameters
    Map<Long, MyInt> map;
    int target;
    long sum;

    // use object to speed up map.put;
    class MyInt {
        long val;
        MyInt(long val) {
            this.val = val;
        }
    }

    int dfs(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int ans = 0;
        MyInt count = new MyInt(0);
        
        sum += curr.val;

        // if any diff between curr sum and prefix sum is target, ans++;
        ans += map.getOrDefault(sum - target, new MyInt(0)).val;

        // update curr sum in map
        if (map.containsKey(sum)) {
            count = map.get(sum);
        } else {
            map.put(sum, count);
        }
        count.val++;

        // go deeper
        ans += dfs(curr.left);
        ans += dfs(curr.right);
        
        // restore map and count back to visit this node before
        count.val--;
        sum -= curr.val;

        return ans;

    }
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        target = targetSum;
        sum = 0;
        map.put(0L, new MyInt(1));
        return dfs(root);
        
    }
}
// use stored prefix sum to solve this
