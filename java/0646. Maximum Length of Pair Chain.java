// Daily Challenge 08/26/2023
class Solution {
    public int findLongestChain(int[][] pairs) {
        int max = pairs[0][1], min = max;
        for (int[] pair : pairs) {
            max = Math.max(max, pair[1]);
            min = Math.min(min, pair[1]);
        }
        int[] latestStart = new int[max - min + 2];
        for (int[] pair : pairs) {
            int start = pair[0] - min + 1;
            int end = pair[1] - min + 1;
            latestStart[end] = Math.max(latestStart[end], start);
        }
        int end = 1;
        int ans = 1;
        for (int i = min + 1; i <= max; i++) {
            int time = i - min + 1;
            if (latestStart[time] > end) {
                ans++;
                end = time;
            }
        }
        return ans;
    }
}
// 经典按结束排序, because sort by end can make sure current interval won't effect remaining ones
// class Solution {
//     public int findLongestChain(int[][] pairs) {
//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
//         int ans = 1, curr = pairs[0][1];
//         for (int i = 1; i < pairs.length; i++) {
//             if (curr < pairs[i][0]) {
//                 ans++;
//                 curr = pairs[i][1];
//             }
//         }
//         return ans;
//     }
// }
