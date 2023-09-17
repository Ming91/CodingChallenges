/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 236 early stop dfs 8ms
// 好像还能再改进,把early stop的need变成全局
// 236 dfs 9ms

class Solution {
    TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode lt = dfs(root.left, p, q);
        TreeNode rt = dfs(root.right, p, q);
        if (lt == null || rt == null) {
            return lt == null ? rt : lt;
        }
        return root;
        // if (lt != null && rt != null) {
        //     return root;
        // }
        // return lt == null ? rt : lt;
    }
    boolean isFound(TreeNode node, TreeNode target) {
        if (node == target) {
            return true;
        }
        if (node == null) {
            return false;
        }
        return isFound(node.left, target) || isFound(node.right, target);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans = dfs(root, p, q);
        if (ans == p) {
            if (isFound(p, q)) {
                return p;
            } else {
                return null;
            }
        }
        if (ans == q) {
            if (isFound(q, p)) {
                return q;
            } else {
                return null;
            }
        }
        return ans;
    }
}

// 236 删树方法照搬不行,因为最后的root如果返回的是pq中的一个, 不知道是另一个没找到
//     还是pq一个是另一个的子树节点
//     
//     还是没更好理解这个方法,这个方法里node == p or q直接return,说明pq在另一子树里是包含的
//     需要修改为:如果返回的是pq之一,去其下面找另一个,找不到则返回null
//     修改后,8ms,因为之前找到pq就返回,所以没有额外开销.

// 另一改法:加一个全局flag,检查是不是都找到了,每次dfs里面都检查找到了几个记录在condition
// 例如left right不为null都+1,node为pq也+1

// 236 stack, 81ms, 最后需要修改,如果stack为空,要指向null
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
//                     if (LCA_index == current) {
//                         if (parentStack.isEmpty()) {
//                             LCA_index = null;
//                             return LCA_index;
//                         } else {
//                             LCA_index = parentStack.peek();
//                         }
//                     }

//             }
//         }
//         return LCA_index;
//     }
// }


//  intuition:
//  从1开始index,位置i的node的父亲是i>>1,用null填满树,
//  但是稀疏的情况好像不太可行

// class Solution {
//     int getFather(int min, int max) {
//         if (min == max) {
//             return min;
//         }
//         return min < (max >> 1) ? getFather(min, max >> 1) : getFather(max >> 1, min);
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (p.val == q.val) {
//             return p;
//         }

//         List<TreeNode> vList = new ArrayList<>();
//         Queue<TreeNode> que = new LinkedList<>();
//         int min = -1, max = -1;
//         int index = 0;
//         int lastNode = 0;
//         que.offer(root);
//         while (!que.isEmpty()) {
//             TreeNode current = que.poll();
//             index++;
//             if (current == null) {
//                 if (index >> 1 > lastNode) {
//                     return null;
//                 }
//                 vList.add(null);
//                 que.offer(null);
//                 que.offer(null);
//             } else {
//                 if (current.val == p.val || current.val == q.val) {
//                     if (min < 0) {
//                         min = index;
//                     } else {
//                         max = index;
//                         int ans = getFather(min, max);
//                         return vList.get(ans - 1);
//                     }
//                 }
//                 vList.add(current);
//                 lastNode = index;
//                 que.offer(current.left);
//                 que.offer(current.right);
//             }
//         }
//         return null;
//     }
// }
