// Daily Challenge 08/29/2023
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        char[] ch = customers.toCharArray();
        int min = 0;
        int curr = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'Y') {
                curr--;
            } else {
                curr++;
            }
            if (curr < min) {
                min = curr;
                idx = i + 1;
            }
        }
        return idx;
    }
}
// min max is relative relations, so we can move it `up or down` simultaneously
// for two passes, we need check the number of total 'y's and decrease penalty when left `y`s increase, and increase penalty when right `y`s increase. So, cut the chase, ignore total y, just get the remaining part of result. It does not effect the relative relations.

// stupid two pass
// class Solution {
//     public int bestClosingTime(String customers) {
//         int n = customers.length();
//         char[] ch = customers.toCharArray();
//         int[] res = new int[n + 1];
//         res[n - 1] = (ch[n - 1] == 'Y' ? 1 : 0);
//         for (int i = n - 2; i >= 0; i--) {
//             res[i] = res[i + 1] + (ch[i] == 'Y' ? 1 : 0);
//         }
//         int min = res[0];
//         int prev = 0;
//         int idx = 0;
//         for (int i = 1; i < n; i++) {
//             prev += (ch[i - 1] == 'N' ? 1 : 0);
//             res[i] += prev;
//             // System.out.println(i + "," + res[i]);
//             if (min > res[i]) {
//                 min = res[i];
//                 idx = i;
//             }
//         }
//         prev += (ch[n - 1] == 'N' ? 1 : 0);
//         if (prev < min) {
//             return n;
//         }
//         return idx;
//     }
// }
