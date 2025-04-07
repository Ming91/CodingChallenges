// Daily Question 11/01/2023
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
    int maxCount = 1;
    int currCount = 0;
    int currNum = 0;
    List<Integer> ans = new ArrayList<>();
    void add(int val) {
        if (val == currNum) {
            currCount++;
        } else {
            if (currCount == maxCount) {
                ans.add(currNum);
            }
            if (currCount > maxCount) {
                ans.clear();
                ans.add(currNum);
                maxCount = currCount;
            }
            currNum = val;
            currCount = 1;
        }
    }
    public int[] findMode(TreeNode root) {
        TreeNode curr = root;
        TreeNode rightMost = null;
        // TreeNode left = null;
        while (curr != null) {
            if (curr.left != null) {
                rightMost = curr.left;

                // [Morris]
                //  Break version, break parent->left
                // while (rightMost.right != null) {
                //     rightMost = rightMost.right;
                // }
                // rightMost.right = curr;
                // left = curr.left;
                // curr.left = null;
                // curr = left;
                // continue;

                // [Morris]
                //  No break version,
                while (rightMost.right != null && rightMost.right != curr) {
                    rightMost = rightMost.right;
                }
                if (rightMost.right == null) {
                    // first time visit rightMost, assign rightMost.right = curr
                    //  then go left.
                    rightMost.right = curr;
                    curr = curr.left;
                } else {
                    //  second time visit rightMost, break the link
                    rightMost.right = null;
                    add(curr.val);
                    curr = curr.right;
                }
                continue;
            }
            add(curr.val);
            curr = curr.right;
        }
        if (currCount == maxCount) {
            ans.add(currNum);
        }
        if (currCount > maxCount) {
            ans.clear();
            ans.add(currNum);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();

    }
}
// [Editorial][True Morris]
 
// [Editorial][Morris]
//  No rebuild. 
//  rightmost = curr.left;
//  rightmost = rightmost.right....right
//  left = curr.left;
//  curr.left = null;
//  curr = left;
// class Solution {
//     public int[] findMode(TreeNode root) {
//         int maxCount = 1;
//         int currCount = 0;
//         int currNum = 0;
//         List<Integer> ans = new ArrayList<>();
//         TreeNode curr = root;
//         TreeNode rightMost = null;
//         TreeNode left = null;
//         while (curr != null) {
//             if (curr.left != null) {
//                 rightMost = curr.left;
//                 while (rightMost.right != null) {
//                     rightMost = rightMost.right;
//                 }
//                 rightMost.right = curr;
//                 left = curr.left;
//                 curr.left = null;
//                 curr = left;
//                 continue;
//             }
//             if (curr.val == currNum) {
//                 currCount++;
//             } else {
//                 if (currCount == maxCount) {
//                     ans.add(currNum);
//                 }
//                 if (currCount > maxCount) {
//                     ans.clear();
//                     ans.add(currNum);
//                     maxCount = currCount;
//                 }
//                 currNum = curr.val;
//                 currCount = 1;
//             }
//             curr = curr.right;
//         }
//         if (currCount == maxCount) {
//             ans.add(currNum);
//         }
//         if (currCount > maxCount) {
//             ans.clear();
//             ans.add(currNum);
//         }
//         return ans.stream().mapToInt(Integer::intValue).toArray();

//     }
// }

// [Editorial] Inorder traversal is ordered array. 
// class Solution {
//     int currNum;
//     int currCount;
//     int max;
//     void dfs(TreeNode root, List<Integer> ans) {
//         if (root == null) {
//             return;
//         }
//         dfs(root.left, ans);
//         if (currNum == root.val) {
//             currCount++;
//         } else {
//             if (currCount == max) {
//                 ans.add(currNum);
//             }
//             if (currCount > max) {
//                 max = currCount;
//                 ans.clear();
//                 ans.add(currNum);
//             }
//             currNum = root.val;
//             currCount = 1;
//         }
//         dfs(root.right, ans);
//     }
//     public int[] findMode(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         currNum = root.val;
//         currCount = 0;
//         max = 0;
//         dfs(root, ans);
//         if (currCount == max) {
//             ans.add(currNum);
//         }
//         if (currCount > max) {
//             ans.clear();
//             ans.add(currNum);
//         }
//         return ans.stream().mapToInt(Integer::intValue).toArray();
//     }
// }
// [Ming] map count
// class Solution {
//     Map<Integer, Integer> count;
//     void dfs(TreeNode root) {
//         if (root == null) {
//             return;
//         }
//         count.merge(root.val, 1, Integer::sum);
//         dfs(root.left);
//         dfs(root.right);
//     }
//     public int[] findMode(TreeNode root) {
//         count = new HashMap<>();
//         dfs(root);
//         List<Integer> ans = new ArrayList<>();
//         int max = 0;
//         for (Integer v : count.values()) {
//             max = Math.max(max, v);
//         }
//         for (Map.Entry<Integer, Integer> e : count.entrySet()) {
//             if (e.getValue() == max) {
//                 ans.add(e.getKey());
//             }
//         }
//         return ans.stream().mapToInt(Integer::intValue).toArray();
//     }
// }
