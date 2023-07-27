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
// daily challenge 07/23/2023

class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        TreeNode[][] dp = new TreeNode[n + 1][];
        if ((n & 1) == 0) {
            return ans;
        }
        if (n == 1) {
            return Arrays.asList(new TreeNode(0));
        }
        dp[1] = new TreeNode[1];
        dp[1][0] = new TreeNode(0);
        dp[3] = new TreeNode[1];
        dp[3][0] = new TreeNode(0, dp[1][0], dp[1][0]);
        for (int count = 5; count < n + 1; count += 2) {
            int treeNum = 0;
            for (int i = 1; i < count; i += 2) {
                treeNum += dp[i].length * dp[count - i - 1].length;
            }
            dp[count] = new TreeNode[treeNum];
            int idx = 0;
            for (int i = 1; i < count; i += 2) {
                TreeNode[] leftList = dp[i];
                TreeNode[] rightList = dp[count - 1 - i];
                for (TreeNode l : leftList) {
                    for (TreeNode r : rightList) {
                        dp[count][idx++] = new TreeNode(0, l, r);
                    }
                }
            }
            
        }
        return Arrays.asList(dp[n]);
    }
}
// beat 99% idea:
//  use array instead of list;
//  initialize with 1 and 3, not just 3

// class Solution {
//     public List<TreeNode> allPossibleFBT(int n) {
//         List<TreeNode> ans = new ArrayList<>();
//         List<TreeNode>[] dp = new ArrayList[n + 1];
//         if ((n & 1) == 0) {
//             return ans;
//         }
//         if (n == 1) {
//             return Arrays.asList(new TreeNode(0));
//         }
//         for (int i = 1; i < n + 1; i += 2) {
//             dp[i] = new ArrayList<>();
//         }
//         dp[1].add(new TreeNode(0));
//         dp[3].add(new TreeNode(0, dp[1].get(0), dp[1].get(0)));
//         for (int count = 5; count < n + 1; count += 2) {
//             for (int i = 1; i < count; i += 2) {
//                 List<TreeNode> leftList = dp[i];
//                 List<TreeNode> rightList = dp[count - 1 - i];
//                 for (TreeNode l : leftList) {
//                     for (TreeNode r : rightList) {
//                         dp[count].add(new TreeNode(0, l, r));
//                     }
//                 }
//             }
            
//         }
//         return dp[n];
//     }
// }

// 没有想法的题目，看官解之后知道要构造，从小的构造大的，
// 自己想的是用n个的构造n+2的，加叶子节点，好像不太方便
// 提供的思路是要构造n的，左子树从1到n-2，右子树从n-2到1，挨个组合构造
