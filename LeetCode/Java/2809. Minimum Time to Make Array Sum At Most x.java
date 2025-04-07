// Biweekly Contest 110 Q4
class Solution {
    class MyAB {
        int a;
        int b;
        MyAB(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int minimumTime(List<Integer> a, List<Integer> b, int x) {
        int sumA = 0, sumB = 0;
        int n = a.size();
        MyAB[] ab = new MyAB[n];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int aa = a.get(i);
            int bb = b.get(i);
            ab[i] = new MyAB(aa, bb);
            sumA += aa;
            sumB += bb;
        }
        Arrays.sort(ab, (o1, o2) -> (o1.b - o2.b));
        // 按照b的排序来选择, 关键点在于有些可以跳过,仍然可以满足结果, 因此要用dp
        for (int j = 0; j < n; j++) {
            for (int i = j + 1; i > 0; i--) {
                dp[i] = Math.max(dp[i], dp[i - 1] + i * ab[j].b + ab[j].a);
            }
        }
        int target = sumA - x;
        for (int i = 0; i <= n; i++) {
            if (target <= dp[i]) {
                return i;
            }
            target += sumB;
        }
        return -1;
    }
}
