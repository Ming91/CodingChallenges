// LeetCode 75 Binary Tree - DFS Q5
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
    int max = 0;
    void dfs(TreeNode curr, char dir, int len) {
        if (curr == null) {
            return ;
        }
        switch (dir) {
            // 要从curr到curr.left
            case 'L' :
                while (true) {
                    // 从curr的father开始不可行, 但是从curr->curr.right可行
                    // if (curr.right != null) {
                        dfs(curr.right, 'L', 1);
                    // }
                    curr = curr.left;
                    if (curr == null) {
                        break;
                    }
                    len++;
                    // if (curr.left != null) {
                        dfs(curr.left, 'R', 1);
                    // }
                    curr = curr.right;
                    if (curr == null) {
                        break;
                    }
                    len++;
                }
                break;
            case 'R' :
                while (true) {
                    // if (curr.right != null) {
                        dfs(curr.left, 'R', 1);
                    // }
                    curr = curr.right;
                    if (curr == null) {
                        break;
                    }
                    len++;
                    // if (curr.left != null) {
                        dfs(curr.right, 'L', 1);
                    // }
                    curr = curr.left;
                    if (curr == null) {
                        break;
                    }
                    len++;
                }
                break;
        }
        max = Math.max(max, len);
        return ;
    }
    public int longestZigZag(TreeNode root) {
        dfs(root, 'L', 0);
        return max;
    }
}
// impl the beat 100% solution
// idea:
//  对当前可行的用循环来计算长度, 每个可行的分支重新计数.

// less duplicate but structure not that clear
// one-time dfs
// class Solution {
//     int max;
//     int dir;
//     int dfs(TreeNode curr) {
//         if (curr == null) {
//             return 0;
//         }
//         int ans = 0;
//         int d = dir;
//         dir = 0;
//         int l = dfs(curr.left);
//         dir = 1;
//         int r = dfs(curr.right);
//         // 深刻理解一下: 即使当前最长不能和父亲相连, 但是仍然可以和自己连起来用来更新最优
//         switch (d) {
//             case 0:
//                 ans = 1 + r;
//                 max = Math.max(max, l + 1);
//                 break;
//             case 1:
//                 ans = 1 + l;
//                 max = Math.max(max, r + 1);
//                 break;
//             default:
//                 ans = 1 + Math.max(r, l);
//         }
//         // dir = d;
//         // System.out.println(d + "," + curr.val + ":" + ans);
//         max = Math.max(max, ans);
//         return ans;
//     }
//     public int longestZigZag(TreeNode root) {
//         dir = -1;
//         int temp = dfs(root);
//         return max - 1;
//     }
// }

// clear structure, but dfs twice
// class Solution {
//     int max = 0;
//     void dfs(TreeNode curr, boolean left, int len) {
//         if (curr == null) {
//             return ;
//         }
//         if (left) {
//             dfs(curr.left, !left, len + 1);
//             dfs(curr.right, left, 1);
//         } else {
//             dfs(curr.right, !left, len + 1);
//             dfs(curr.left, left, 1);
//         }
//         max = Math.max(max, len);
//     }
//     public int longestZigZag(TreeNode root) {
//         dfs(root, true, 0);
//         dfs(root, false, 0);
//         return max;
//     }
// }

// dumb dfs, Excessive repetitive ops
// class Solution {
//     static final int LEFT = 0;
//     static final int RIGHT = 1;
//     int max;
//     int dfs(TreeNode curr, int dir) {
//         if (curr == null) {
//             return 0;
//         }
//         int ans = 0;
//         int lr = dfs(curr.left, RIGHT);
//         max = max < lr ? lr : max;
//         int ll = dfs(curr.left, LEFT);
//         max = max < ll ? ll : max;
        
//         int rl = dfs(curr.right, LEFT);
//         max = max < rl ? rl : max;
//         int rr = dfs(curr.right, RIGHT);
//         max = max < rr ? rr : max;
//         switch (dir) {
//             case LEFT:
//                 ans = 1 + lr;
//                 break;
//             case RIGHT:
//                 ans = 1 + rl;
//                 break;
//         }
        
//         max = max < ans ? ans : max;
//         // System.out.printf("%d:%d%n", curr.val, ans);
//         return ans;
//     }
//     public int longestZigZag(TreeNode root) {
//         max = 0;
//         int temp = dfs(root, LEFT);
//         temp = dfs(root, RIGHT);
//         return max - 1;
//     }
// }
