class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int top = -1;
        for (int next : asteroids) {
            boolean isAlive = true;
            while (isAlive && next < 0 && top >= 0 && asteroids[top] > 0) {
                int temp = next + asteroids[top];
                isAlive = temp < 0;
                if (isAlive || temp == 0) {
                    top--;
                }
            }
            if (isAlive) {
                asteroids[++top] = next;
            }
        }
        return Arrays.copyOf(asteroids, top + 1);
    }
}
// beat 99% idea:
// same runtime, better structure and logic

// intuition stack
// attention: -1 <--, +1 -->, [-1, +1] never meet
// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         int n = asteroids.length;
//         int[] s = new int[n];
//         int head = 0;
//         int idx = 1;
//         s[head++] = asteroids[0];
//         int current = asteroids[0];
//         int next = asteroids[1];
//         while (idx < n) {
//             // 如果空栈,进一个
//             if (head < 1) {
//                 s[head++] = asteroids[idx];
//                 idx++;
//                 continue;
//             }
//             current = s[head - 1];
//             next = asteroids[idx];
//             // [1, -1]才合并
//             // [-1, 1]不管
//             if (current > 0 && current + next == 0) {
//                 s[--head] = 0;
//                 idx++;
//                 continue;
//             }
//             // [-1, 2],[1,2],,,[-1, -2]都该直接进
//             if (next > 0 || current < 0) {
//                     s[head++] = next;
//                     idx++;
//                     continue;
//             } else {
//                 // next<0 && current>0, 
//                 // [1, -2], 缩
//                 if (Math.abs(current) < Math.abs(next)) {
//                     s[--head] = 0;
//                     continue;
//                 } else {
//                     // [2, -1], 不动
//                     idx++;
//                     continue;
//                 }
//             }
//         }
//         int[] ans = new int[head];
//         for (int i = 0; i < head; i++) {
//             ans[i] = s[i];
//         }
//         return ans;
//     }
// }
