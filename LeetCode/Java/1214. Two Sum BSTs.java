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

// Use HashSet
class Solution {
    private void traverseToSet(TreeNode root, Set<Integer> result) {
        if (root == null) {
            return;
        } 
        traverseToSet(root.left, result);
        result.add(root.val);
        traverseToSet(root.right, result);
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        traverseToSet(root1, set1);
        traverseToSet(root2, set2);

        for (Integer i : set1) {
            if (set2.contains(target - i)) {
                return true;
            }
        }

        return false;
        // if (arrList1.get(0) + arrList2.get(0) > target) {
        //     // target too small
        //     return false;
        // }

        // int n = arrList1.size();
        // int m = arrList2.size();
        // if (arrList.get(n - 1) + arrList2.get(m - 1) < target) {
        //     // tareget too large
        //     return false;
        // }


    }
}

// intuition idea
class Solution {
    private void traverseToList(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        } 
        traverseToList(root.left, result);
        result.add(root.val);
        traverseToList(root.right, result);
    }
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        // Set<Integer> set1 = new HashSet<>();
        // Set<Integer> set2 = new HashSet<>();
        List<Integer> arrList1 = new ArrayList<>();
        List<Integer> arrList2 = new ArrayList<>();
        traverseToList(root1, arrList1);
        traverseToList(root2, arrList2);

        // for (Integer i : set1) {
        //     if (set2.contains(target - i)) {
        //         return true;
        //     }
        // }
        
         if (arrList1.get(0) + arrList2.get(0) > target) {
             // target too small
             return false;
         }

        int n = arrList1.size();
        int m = arrList2.size();
        if (arrList1.get(n - 1) + arrList2.get(m - 1) < target) {
            // tareget too large
            return false;
        }

        int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {
            Integer l = arrList1.get(i);
            Integer r = arrList2.get(j);
            if (l + r == target) {
                return true;
            } else if (l + r < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}


// 把自己绕进去的想法，笔记找不到了，是不是此题也记不清了
// 想法很简单，两个排序数组，给一个sum，找符合的pair
// 俩指针，一个数组正向，一个负向
// 错过了怎么办？ 如果假设错过了，无法反证。绕进去的一点
// a[]... i ... * ...
// b[]... * ... j ...
// 假设a走到*了，如果b[]没到*，会走到
//              如果b[]走过了*，回到那个时刻，a还没到*，sum始终小于target，a会不断走到*，完证。
