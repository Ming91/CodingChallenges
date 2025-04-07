// Top Interview 150 Hashmap Q6
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(n + n >> 1);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] ans = new int[2];
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     ans[0] = i;
//                     ans[1] = j;
//                     return ans;
//                 }
//             }
//         }
//         return ans;
//     }
// }

// 令人费解的beat 100%
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[] ans=new int[2];
//         for(int i=1;i<nums.length;i++){
//             for(int j=i;j<nums.length;j++){
//                 if(nums[j-i]+nums[j]==target){
//                     ans[0]=j-i;
//                     ans[1]=j;
//                     return ans;
//                 }
//             }
//         }
//         return ans;
//     }
// }
