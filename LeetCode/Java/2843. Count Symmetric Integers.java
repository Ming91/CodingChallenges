// Weekly Contest 361 Q1
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = Math.max(low, 11); i <= high && i < 100; i++) {
            if (i / 10 == i % 10) {
                ans++;
            }
        }
        for (int i = Math.max(low, 1001); i <= high; i++) {
            if (i / 1000 + i / 100 % 10 == i / 10 % 10 + i % 10) {
                ans++;
            }
        }
        return ans;
    }
}
