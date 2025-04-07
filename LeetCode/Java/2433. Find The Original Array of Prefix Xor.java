// Daily Question 10/31/2023
class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        for (int i = n - 1; i > 0; i--) {
            pref[i] = pref[i] ^ pref[i - 1];
        }
        return pref;
    }
}
// [Editorial]
//  Reverse is magic!

// [Ming] Redudant var solution
// class Solution {
//     public int[] findArray(int[] pref) {
//         int n = pref.length;
//         int[] arr = new int[n];
//         int xor = 0;
//         for (int i = 0; i < n; i++) {
//             arr[i] = xor ^ pref[i];
//             xor = xor ^ arr[i];
//         }
//         return arr;
//     }
// }
