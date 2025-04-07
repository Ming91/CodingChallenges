// LeetCode 75 HashMap / Set Q1
class Solution {
    // range from -1000 to 1000;
    static int BASE = 1_000;
    static int RANGE = 2_000;
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        boolean[] s1 = new boolean[RANGE + 1];
        boolean[] s2 = new boolean[RANGE + 1];
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int num : nums1) {
            s1[num + BASE] = true;
        }
        for (int num : nums2) {
            s2[num + BASE] = true;
            if (!s1[num + BASE]) {
                l2.add(num);
                s1[num + BASE] = true;
            }
        }
        for (int num : nums1) {
            if (!s2[num + BASE]) {
                l1.add(num);
                s2[num + BASE] = true;
            }
        }
        ans.add(l1);
        ans.add(l2);
        return ans;
    }
}
// beat 100% idea:
//  定义一个AbstractList<List<Integer>>, copy一个List<List<>> 
//  通过override size()和get()来初始化
//  初始化的时候, 进行以上操作

// class Solution {
//     public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//         int m = nums1.length;
//         int n = nums2.length;
//         List<Integer> l1 = new ArrayList<>();
//         List<Integer> l2 = new ArrayList<>();
//         Set<Integer> s1 = new HashSet<>();
//         Set<Integer> s2 = new HashSet<>();
//         for (int num : nums1) {
//             s1.add(num);
//         }
//         for (int num : nums2) {
//             s2.add(num);
//         }
//         for (Integer num : s1) {
//             if (!s2.contains(num)) {
//                 l1.add(num);
//             }
//         }
//         for (Integer num : s2) {
//             if (!s1.contains(num)) {
//                 l2.add(num);
//             }
//         }
//         List<List<Integer>> ans = new ArrayList<>();
//         ans.add(l1);
//         ans.add(l2);
//         return ans;
//     }
// }
