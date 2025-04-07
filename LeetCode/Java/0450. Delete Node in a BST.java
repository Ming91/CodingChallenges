// LeetCode 75 Binary Search Tree Q2
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
    TreeNode successor(TreeNode curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 找左子树
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        // 找右子树
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        
        // 找到了
        // 没有孩子, 直接删
        if (root.left == null && root.right == null) {
            return null;
        }
        // 没有左子树, 右子树直接接上去
        if (root.left == null) {
            return root.right;
        }
        // 没有右子树, 左子树直接接上去
        if (root.right == null) {
            return root.left;
        }

        // 左右都有, 用右边最小替代, 即从右子开始,找没左子的那个节点
        TreeNode temp = successor(root.right);
        root.val = temp.val;

        // 以下代码错误, 从root.right 到temp的路径没有跟踪
        // root.right = deleteNode(temp, temp.val);
        //这样做又好像重复遍历了root到temp的过程
        root.right = deleteNode(root.right, root.val);
        return root;
    }
}
// editorial: 结构更清晰, 但是好像有overlap
// 自己比较naive的想法
// class Solution {
//     TreeNode delete(TreeNode root, int key) {
//         if (root == null) {
//             return null;
//         }
//         // 找左子树
//         if (key > root.val) {
//             root.right = deleteNode(root.right, key);
//             return root;
//         }
//         // 找右子树
//         if (key < root.val) {
//             root.left = deleteNode(root.left, key);
//             return root;
//         }
        
//         // 找到了
//         // 没有孩子, 直接删
//         if (root.left == null && root.right == null) {
//             return null;
//         }
//         // 没有左子树, 右子树直接接上去
//         if (root.left == null) {
//             return root.right;
//         }
//         // 没有右子树, 左子树直接接上去
//         if (root.right == null) {
//             return root.left;
//         }

//         // 左右都有, 用右边最小替代, 即从右子开始,找没左子的那个节点

//         // 情况1: 右子就是目标, 直接跳过右子
//         if (root.right.left == null) {
//             root.val = root.right.val;
//             root.right = root.right.right;
//             return root;
//         }
//         // 情况2: 目标在更底层, 要记录目标的父亲, 目标的右子替代自己成为父亲的左子
//         // 当前要删除的替换为目标的值即可
//         TreeNode curr = root.right;
//         TreeNode prev = root;
//         while (curr.left != null) {
//             prev = curr;
//             curr = curr.left;
//         }
//         prev.left = curr.right;
//         root.val = curr.val;
//         return root;
//     }
//     public TreeNode deleteNode(TreeNode root, int key) {
//         return delete(root, key);
//     }
// }
