// Daily Question 10/16/2023
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        long curr = 1;
        ans.add(1);
        for (int k = 1; k <= rowIndex; k++) {
            curr = curr * (rowIndex - k + 1) / k;
            ans.add((int)curr);
        }
        return ans;
    }
}
// [Editorial] Math!
// C(n, k) = n!/((n-k)! k!) = C(n, k - 1) * (n - k + 1) / k.

// [Ming] Iteration dp.
// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         Integer[] ans = new Integer[rowIndex + 1];
//         ans[0] = 1;
//         for (int i = 1; i <= rowIndex; i++) {
//             ans[i] = 0;
//             for (int j = i; j >= 1; j--) {
//                 ans[j] = ans[j] + ans[j - 1];
//             }
//         }
//         return Arrays.asList(ans);
//     }
// }
