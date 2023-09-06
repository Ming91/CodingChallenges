// Weekly Premium Aug 2023 W5
class Solution {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        // int[][] occur = new int[sideLength][sideLength];
        int len = sideLength * sideLength;
        int[] occur = new int[len];
        int idx = 0;
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                // i, i + s, i + 2s...
                // [i + 1, w - 1] total w - i - 1 cells
                occur[idx++] = (1 + (width - i - 1) / sideLength) * (1 + (height - j - 1) / sideLength);
                // System.out.println(occur[i * sideLength + j]);
            }
        }
        Arrays.sort(occur);
        // System.out.println(occur[3]);
        int ans = 0;
        for (int i = 0; i < maxOnes; i++) {
            // System.out.println(occur[len - i - 1]);
            ans += occur[len - i - 1];
        }
        return ans;
    }
}
