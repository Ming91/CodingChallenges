// Top Interview 150 Binary Tree General Q14
// LeetCode 75 Binary Tree - DFS Q6
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Top Interview 09/26/2023 Impl
class Solution {
    TreeNode p, q;
    TreeNode dfs(TreeNode root) {
        TreeNode left = root.left == null ? null : dfs(root.left);
        TreeNode right = root.right == null ? null : dfs(root.right);
        if (root == p || root == q || (left == p && right == q) || (left == q && right == p)) {
            return root;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        return dfs(root);
        
    }
}

// 08/05/2023 impl
// class Solution {
//     TreeNode p, q;
//     TreeNode dfs(TreeNode curr) {
//         if (curr == null || curr == p || curr == q) {
//             return curr;
//         }
//         TreeNode l = dfs(curr.left);
//         TreeNode r = dfs(curr.right);
//         if (l == null) {
//             return r;
//         }
//         if (r == null) {
//             return l;
//         }
//         return curr;
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode pp, TreeNode qq) {
//         p = pp;
//         q = qq;
//         return dfs(root);
//     }
// }

// class Solution {
//     TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null) {
//             return null;
//         }
//         if (root == p || root == q) {
//             return root;
//         }
//         TreeNode lt = dfs(root.left, p, q);
//         TreeNode rt = dfs(root.right, p, q);
//         if (lt == null || rt == null) {
//             return lt == null ? rt : lt;
//         }
//         return root;
//         // if (lt != null && rt != null) {
//         //     return root;
//         // }
//         // return lt == null ? rt : lt;
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         return dfs(root, p, q);
//     }
// }

// beat 99%的方法：
// 把不是pq的子树从下到上逐渐删除，若为pq则向上返回pq，如果两子树分别为pq即为答案，返回root，
// 这样结果再往上返回的也还是答案root

// class Solution {
//     static final int BOTH_PENDING = 2;
//     static final int LEFT_DONE = 1;
//     static final int BOTH_DONE = 0;
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         Stack<TreeNode> parentStack = new Stack<>();
//         Stack<Integer> statusStack = new Stack<>();
//         TreeNode LCA_index = null;
//         parentStack.push(root);
//         statusStack.push(BOTH_PENDING);
//         while (!parentStack.isEmpty()) {
//             TreeNode current = parentStack.pop();
//             int status = statusStack.pop();
//             int v = current.val;
//             // 比较过的值返回再比较,直接满足,此处不对!
//             // 只有第一次到才比较,放到both_pending里
//             // if (current.val == p.val || current.val == q.val) {
//             //     if (LCA_index == null) {
//             //         LCA_index = current;
//             //     } else {
//             //         return LCA_index;
//             //     }
//             // }
//             switch (status) {
//                 case BOTH_PENDING:
//                     if (current.val == p.val || current.val == q.val) {
//                         if (LCA_index == null) {
//                             LCA_index = current;
//                         } else {
//                             return LCA_index;
//                         }
//                     }
//                     parentStack.push(current);
//                     statusStack.push(LEFT_DONE);
//                     if (current.left != null) {
                        
//                         parentStack.push(current.left);
//                         statusStack.push(BOTH_PENDING);
//                     } //else {
//                     //     if (current.right != null) {
                            
//                     //         parentStack.push(current);
//                     //         statusStack.push(BOTH_DONE);
                            
//                     //         parentStack.push(current.right);
//                     //         statusStack.push(BOTH_PENDING);
//                     //     } else {
//                     //         LCA_index = LCA_index == null ? null : parentStack.peek();
//                     //     }
//                     // }
//                     break;
//                 case LEFT_DONE:
//                     parentStack.push(current);
//                     statusStack.push(BOTH_DONE);
//                     if (current.right != null) {
                        
//                         parentStack.push(current.right);
//                         statusStack.push(BOTH_PENDING);
//                     } //else {
//                     //     LCA_index = LCA_index == null ? null : parentStack.peek();
//                     // }
//                     break;
//                 case BOTH_DONE:
//                     LCA_index = LCA_index == current ? parentStack.peek() : LCA_index;

//             }
//         }
//         return LCA_index;
//     }
// }
// use stack implement the editorial
// 出错,问题是,如果像testcase3一样,lca_indx总是指向顶部,
// 尝试解决:不要一次处理,反复压进去----已验证,错误
// 正确方案:比较lca与当前pop的比较,
//          如果相等,将lca更新为下一个,
//          如果不等,说明lca在更下面,不用更新



// dfs with early stop 'need'
// if we only need one more to find, we dont need to find 2

// class Solution {
//     TreeNode ans;
//     int DFS(TreeNode root, int p, int q, int need) {
//         if (ans != null) {
//             return 2;
//         }
//         if (root == null || need == 0) {
//             return 0;
//         }
//         int count = 0;
//         count += root.val == p || root.val == q ? 1 : 0;
//         if (need == count) {
//             return count;
//         }
//         count += DFS(root.left, p, q, need - count);
//         if (ans != null) {
//             return 2;
//         }
//         if (count == 2) {
//             ans = root;
//             return 2;
//         }
//         count += DFS(root.right, p, q, need - count);
//         if (ans != null) {
//             return 2;
//         }
//         if (count == 2) {
//             ans = root;
//             return 2;
//         }
//         return count;

//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         ans = null;
//         int flag = DFS(root, p.val, q.val, 2);
//         return ans;
//     }
// }
// intuition dfs
// class Solution {
//     TreeNode ans;
//     int DFS(TreeNode root, int p, int q) {
//         if (ans != null) {
//             return 2;
//         }
//         if (root == null) {
//             return 0;
//         }
//         int count = 0;
//         count += root.val == p || root.val == q ? 1 : 0;
//         count += DFS(root.left, p, q);
//         if (ans != null) {
//             return 2;
//         }
//         if (count == 2) {
//             ans = root;
//             return 2;
//         }
//         count += DFS(root.right, p, q);
//         if (ans != null) {
//             return 2;
//         }
//         if (count == 2) {
//             ans = root;
//             return 2;
//         }
//         return count;

//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         ans = null;
//         int flag = DFS(root, p.val, q.val);
//         return ans;
//     }
// }
