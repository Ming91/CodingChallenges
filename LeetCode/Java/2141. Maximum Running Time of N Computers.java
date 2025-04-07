// Daily Challenge 07/27/2023
class Solution {
    boolean check(int[] batteries, int n, long time) {
        long sum = time * n;
        for (int bat : batteries) {
            sum -= Math.min(bat, time);
            
        }
        // faster than put in loop;
        if (sum <= 0) {
            return true;
        }
        return false;
    }
    public long maxRunTime(int n, int[] batteries) {
        int m = batteries.length;
        long sum = 0L;
        for (int bat : batteries) {
            sum += bat;
        }
        long l = 1L;
        long r = sum / n;
        long ans = l;
        // System.out.println(l + "," + r);
        while (l < r) {
            
            // 溢出可能,靠左
            // long mid = (l + r) >> 1;
            // 溢出可能,靠右
            // long mid = (l + r + 1) >> 1;
            // 改进溢出, 靠左取整
            // long mid = l + ((r - l) >> 1);
            // 改进溢出, 靠右取整 check
            long mid = r - ((r - l) >> 1);
            if (check(batteries, n, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }

        }
        return r;
    }
}
// beat 99% idea:
//      减法替代加法
//      但是loop外判别更好, 为何?

// better idea: binary search
//              对于candidate time, 每个battery至多用这么多, 总共需要n*cand,比较即可

// class Solution {
//     public long maxRunTime(int n, int[] batteries) {
//         int k = batteries.length;
//         Arrays.sort(batteries);
//         if (k == n) {
//             return batteries[0];
//         }
//         long sum = 0L;
//         for (int i = 0; i < k - n; i++) {
//             sum += batteries[i];
//         }
//         int idx = k - n;
//         int count = 1;
//         while (count <= n && sum >= 0) {
//             // if (count < n && batteries[idx] == batteries[idx + 1]) {
//             //     idx++;
//             //     count++;
//             //     continue;
//             // }
//             if (count == n) {
//                 return batteries[idx] + sum / n;
//             }
//             long diff = (long)(batteries[idx + 1] - batteries[idx]) * count;
//             if (sum < diff) {
//                 return batteries[idx] + sum / count;
//             } 
//             sum -= diff;
//             idx++;
//             count++;
//         }
//         return 0;
//     }
// }
// 相当于往n个管子里倒水, 尽量平均
