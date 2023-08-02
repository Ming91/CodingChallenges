// Daily Challenge 08/02/2023
class Solution {
    void swap(int[] nums, int x, int y) {
        if (x == y) {
            return ;
        }
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
        return ;
    }
    void calc(int[] nums, int idx, List<List<Integer>> ans) {
        if (idx == nums.length - 1) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                res.add(num);
            }
            ans.add(res);
            return ;
        }
        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            calc(nums, idx + 1, ans);
            swap(nums, i, idx);
        }
        return ;
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        calc(nums, 0, ans);
        return ans;
    }
}
// beat 99% idea:
//  从nums出发, 无非是交换里面的顺序,
//  i = 0开始, 跟i ~ n-1依次交换, 再将交换idx之后的数组输入下次递归 形成新的array加入ans, 
//  如此递归, 可以保证都被交换过一遍

// editorial solution
// class Solution {
//     void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> curr) {
//         if (nums.length == curr.size()) {
//             ans.add(new ArrayList<>(curr));
//             return ;
//         }
//         for (int num : nums) {
//             if (!curr.contains(num)) {
//                 curr.add(num);
//                 backtrack(nums, ans, curr);
//                 curr.remove(curr.size() - 1);
//             }
            
//         }
//         return ;
//     }
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         backtrack(nums, ans, new ArrayList<>());
//         return ans;
//     }
// }

// naive idea, add nums[i] to all i-1 perm
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         int n = nums.length;
//         List<List<Integer>> ans = new ArrayList<>();
//         // if (n == 0) {
//         //     return ans;
//         // }
//         if (n == 1) {
//             ans.add(new LinkedList<>(List.of(nums[0])));
//             return ans;
//         }
//         List<List<Integer>> res = permute(Arrays.copyOf(nums, n - 1));
//         int target = nums[n - 1];
//         for (List<Integer> list : res) {
//             System.out.println(list.toString());
//             for (int i = 0; i < n; i++) {
//                 List<Integer> temp = new LinkedList<>(list);
//                 temp.add(i, target);
//                 ans.add(temp);
//             }
//         }
//         return ans;
//     }
// }
