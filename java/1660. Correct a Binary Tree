// Weekly Premium Oct 2023, W4
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
// class Solution {
//     Set<Integer> visited = new HashSet<>();
//     public TreeNode correctBinaryTree(TreeNode root) {
//         if (root == null) {
//             return null;
//         }
//         if (root.right != null && visited.contains(root.right.val)) {
//             return null;
//         }
//         visited.add(root.val);
//         // Order Matters!!!
//         // root.left = correctBinaryTree(root.left);
//         // root.right = correctBinaryTree(root.right);
        
//         //
//         root.right = correctBinaryTree(root.right);
//         root.left = correctBinaryTree(root.left);
//         return root;
//     }
// }
// [Editorial]
//  Recursion version. 
//  Problem constraint: toNode is to the right of fromNode, which leaves not much fun to solve. 
//  dfs from right can solve this. 

// [Ming] Level traversal. The full version can solve any direction combinations of from and to. 
class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {
        Map<Integer, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        parent.put(root.val, null);
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    // if (parent.containsKey(curr.left.val)) {
                    //     TreeNode father = parent.get(curr.val);
                    //     if (father == null) {
                    //         return null;
                    //     }
                    //     if (father.left != null && father.left.val == curr.val) {
                    //         father.left = null;
                    //     } else {
                    //         father.right = null;
                    //     }
                    //     return root;
                    // } else {
                        parent.put(curr.left.val, curr);
                        q.add(curr.left);
                    // }
                }
                if (curr.right != null) {
                    if (parent.containsKey(curr.right.val)) {
                        TreeNode father = parent.get(curr.val);
                        if (father == null) {
                            return null;
                        }
                        if (father.left != null && father.left.val == curr.val) {
                            father.left = null;
                        } else {
                            father.right = null;
                        }
                        return root;
                    } else {
                        parent.put(curr.right.val, curr);
                        q.add(curr.right);
                    }
                }
            }
        }
        return root;
    }
}
