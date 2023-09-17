// Daily Challenge 08/05/2023
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
// iterative, array, 1-d dp
// class Solution {
    
//     static List[] dp = new ArrayList[9];
//     static {
//         List<TreeNode> ans = new ArrayList<>();
//         ans.add(null);
//         dp[0] = ans;
//     }
//     TreeNode clone(TreeNode curr, int offset) {
//         if (offset == 0) {
//             return curr;
//         }
//         if (curr == null) {
//             return null;
//         }
//         TreeNode cloned = new TreeNode(curr.val + offset);
//         cloned.left = clone(curr.left, offset);
//         cloned.right = clone(curr.right, offset);
//         return cloned;
//     }

//     public List<TreeNode> generateTrees(int n) {
//         for (int nodesNum = 1; nodesNum <= n; nodesNum++) {
//             List<TreeNode> res = new ArrayList<>();
//             // 
//             for (int l = 0; l < nodesNum; l++) {
//                 int r = nodesNum - 1 - l;
//                 List<TreeNode> lefts = dp[l];
//                 List<TreeNode> rights = dp[r];
//                 for (TreeNode left : lefts) {
//                     for (TreeNode right : rights) {
//                         // 左边l个,右边r个, l + r + 1 = #nodes
//                         //  那1个就是root, 要比左边的都大, 比右边的都小
//                         TreeNode curr = new TreeNode(l + 1, left, clone(right, l + 1));
//                         res.add(curr);
//                     }
//                 }
//             }
//             dp[nodesNum] = res;
//         }
//         return dp[n];
//     }
// }

// 2. recursion, array

class Solution {
    
    static List[][] map = new ArrayList[9][9];
    static {
        
    }
    List<TreeNode> gen(List[][] map, int l, int r) {
        
        List<TreeNode> ans = new ArrayList<>();
        if (l > r) {
            // return a list contains null to make loop works properly
            ans.add(null);
            return ans;
        }
        if (map[l][r] != null) {
            return map[l][r];
        }
        
        for (int i = l; i <= r; i++) {
            // learn from beat 100% method, add final but no change
            final List<TreeNode> leftTrees = gen(map, l, i - 1);
            final List<TreeNode> rightTrees = gen(map, i + 1, r);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    final TreeNode curr = new TreeNode(i, left, right);
                    ans.add(curr);
                }
            }
        }
        map[l][r] = ans;
        return ans;
    }
    public List<TreeNode> generateTrees(int n) {
        return gen(map, 1, n);
    }
}

// 同时用recursive, array和1-d dp, 好像不是太合适
//  1-d dp 适合 iterative方法
// class Solution {
//     static List[] map = new ArrayList[8];
//     static {
//         List<TreeNode> ans = new ArrayList<>();
//         ans.add(new TreeNode(1));
//         map[0] = ans;
//     }
//     TreeNode clone(TreeNode curr, int offset) {
//         if (curr == null) {
//             return null;
//         }
//         TreeNode cloned = new TreeNode(curr.val + offset);
//         cloned.left = clone(curr.left, offset);
//         cloned.right = clone(curr.right, offset);
//         return cloned;
//     }

//     List<TreeNode> gen(List<TreeNode>[] map, int l, int r) {
        
//         List<TreeNode> ans = new ArrayList<>();
//         if (l > r) {
//             // return a list contains null to make loop works properly
//             ans.add(null);
//             return ans;
//         }
//         int size = r - l + 1;
//         if (map[size - 1] != null) {
//             if (l == 1) {
//                 return map[size - 1];
//             }
//             List<TreeNode> res = map[size - 1];
//             for (TreeNode tree : res) {
//                 ans.add(clone(tree, l - 1));
//             }
//             return ans;
//         }
//         // if (l == r) {
//         //     ans.add(new TreeNode(1));
//         //     map[0] = ans;
//         //     return ans;
//         // }
//         List<TreeNode> m = new ArrayList<>();
//         for (int i = 1; i <= r - l + 1; i++) {
//             List<TreeNode> leftTrees = gen(map, 1, i - 1);
//             List<TreeNode> rightTrees = gen(map, i + 1, r - l + 1);

//             for (TreeNode left : leftTrees) {
//                 for (TreeNode right : rightTrees) {
//                     TreeNode curr = new TreeNode(i, left, right);
//                     m.add(curr);
//                     ans.add(clone(curr, l - 1));
//                 }
//             }
//         }
//         map[size - 1] = m;
//         return ans;
//     }
//     public List<TreeNode> generateTrees(int n) {
        
//         return gen(map, 1, n);
//     }
// }

// 用map, recursion
// class Solution {
//     class MyPair {
//         int l;
//         int r;
//         MyPair(int l, int r) {
//             this.l = l;
//             this.r = r;
//         }
//         @Override
//         public boolean equals(Object o) {
//             if (this == o) return true;
//             if (o == null || getClass() != o.getClass()) return false;
//             MyPair myPair = (MyPair) o;
//             return (l == myPair.l) && (r == myPair.r);
//         }

//         @Override
//         public int hashCode() {
//             return Objects.hash(l, r);
//         }
//     }
//     List<TreeNode> gen(Map<MyPair, List<TreeNode>> map, int l, int r) {
        
//         List<TreeNode> ans = new ArrayList<>();
//         if (l > r) {
//             // return a list contains null to make loop works properly
//             ans.add(null);
//             return ans;
//         }
//         MyPair pair = new MyPair(l, r);
//         if (map.containsKey(pair)) {
//             return map.get(pair);
//         }
//         if (l == r) {
//             ans.add(new TreeNode(l));
//             map.put(pair, ans);
//             return ans;
//         }
//         for (int i = l; i <= r; i++) {
//             List<TreeNode> leftTrees = gen(map, l, i - 1);
//             List<TreeNode> rightTrees = gen(map, i + 1, r);

//             // if (leftTrees == null) {
//             //     for (TreeNode right : rightTrees) {
//             //         TreeNode curr = new TreeNode(i, null, right);
//             //         ans.add(curr);
//             //     }
//             //     continue;
//             // }
//             // if (rightTrees == null) {
//             //     for (TreeNode left : leftTrees) {
//             //         TreeNode curr = new TreeNode(i, left, null);
//             //         ans.add(curr);
//             //     }
//             //     continue;
//             // }

//             for (TreeNode left : leftTrees) {
//                 for (TreeNode right : rightTrees) {
//                     TreeNode curr = new TreeNode(i, left, right);
//                     ans.add(curr);
//                 }
//             }
//         }
//         map.put(pair, ans);
//         return ans;
//     }
//     public List<TreeNode> generateTrees(int n) {
//         Map<MyPair, List<TreeNode>> map = new HashMap<>();
//         return gen(map, 1, n);
//     }
// }
