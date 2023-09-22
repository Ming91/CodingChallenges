// Top Interview 150 Binary Tree General Q5
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
    int p;
    int i;
    TreeNode build(int[] preorder, int[] inorder, int rootVal) {
        if (p == preorder.length) {
            return null;
        }
        if (inorder[i] == rootVal) {
            i++;
            return null;
        }
        int curr = preorder[p++];
        TreeNode root = new TreeNode(curr);
        root.left = build(preorder, inorder, curr);
        root.right = build(preorder, inorder, rootVal);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i = 0;
        p = 0;
        return build(preorder, inorder, 3_001);
    }
}
// [Beat 99%]
//  use two pointers to point the position in two array.
//  smart but abstract. 

// [Editorial] Use map rather than linear search inorder each time for the root position. 
// class Solution {
//     Map<Integer, Integer> rootInInorder;
//     // int n;
//     TreeNode build(int[] preorder, int i, int j, int n) {
//         if (n == 0) {
//             return null;
//         }
//         int curr = preorder[i];
//         int position = rootInInorder.get(curr);
//         TreeNode root = new TreeNode(curr);
//         root.left = build(preorder, i + 1, j, position - j);
//         root.right = build(preorder, i + position - j + 1, position + 1, n - position + j - 1);
//         return root;

//     }
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         int n = preorder.length;
//         rootInInorder = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             rootInInorder.put(inorder[i], i);
//         }
//         return build(preorder, 0, 0, n);
//     }
// }

// [Ming] Impl after hint in the comments.

// ** preorder shows the root of each branch. 
//  And the place of root in the inorder shows the size of left and right branch.

// class Solution {
//     private TreeNode build(int[] preorder, int preStart, int[] inorder, int inStart, int n) {
//         if (n == 0) {
//             return null;
//         }
//         int curr = preorder[preStart];
//         int i = 0;
//         for (; i < n; i++) {
//             if (inorder[i + inStart] == curr) {
//                 break;
//             }
//         }
//         TreeNode root = new TreeNode(curr);
//         root.left = build(preorder, preStart + 1, inorder, inStart, i);
//         root.right = build(preorder, preStart + i + 1, inorder, inStart + i + 1, n - i - 1);
//         return root;   
//     }
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         int n = preorder.length;
//         return build(preorder, 0, inorder, 0, n);
//     }
// }
