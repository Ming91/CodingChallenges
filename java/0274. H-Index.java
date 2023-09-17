// Top Interview 150 Array / String Q11
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int cita : citations) {
            count[Math.min(n, cita)]++;
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}
// cita more than n has same effect of n.
