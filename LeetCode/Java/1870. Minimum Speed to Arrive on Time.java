// Daily Challenge 07/26/2023
class Solution {
    private boolean check(int[] dist, int spd, double hour) {
        int count = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            // brilliant idea, no need ceil or other stupid method
            count += (dist[i] + spd - 1) / spd;
            // if (hour < count) {
            //     return false;
            // }
        }
        double remain = hour - count;
        return remain * spd + 1e-7 > dist[dist.length - 1];
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length - 1 + 1e-7 > hour) {
            return -1;
        }
        int l = 1;
        int r = (int) 1e7;
        while (l < r) {
            int mid = (l + r) >> 1;
            // boolean res = check(dist, mid, hour);
            //System.out.println(mid + "," + res);
            if (!check(dist, mid, hour)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
// beat 99% idea:
//  length + 1e-7 > hour 解决无解情形
//  (dist + (spd - 1)) / spd 解决向上取整问题
//  慎用除法!

// 丑陋的binary search,感觉很多冗余条件
// class Solution {
//     static final double EPS = 1e-9;
//     private double calcTime(int[] dist, int spd) {
//         int ansInt = 0;
//         for (int i = 0; i < dist.length - 1; i++) {
//             int added = (int)Math.ceil((double)dist[i] / spd);
//             //System.out.printf("%d / %d = %d%n", dist[i], spd, added);
//             ansInt += added;
//         }
//         return (double) ansInt + (double)dist[dist.length - 1] / spd;
//     }
//     private int calcSpd(int dist, double hour) {
//         int spd = (int)Math.ceil(dist / hour) - 1;
//         if (spd * hour < dist) {
//             return spd + 1;
//         } else {
//             return spd;
//         }
//     }
//     public int minSpeedOnTime(int[] dist, double hour) {
//         int n = dist.length;
//         // only one stop
//         if (n == 1) {
//             return calcSpd(dist[0], hour);
//         }
//         int hourInt = (int) hour;
//         double hourFrac = hour - hourInt;
//         //  [1, 1, 1] hour = 1.9 or 2.0
//         if (hourInt + 1 < n || hourFrac < EPS && hourInt < n) {
//             return -1;
//         }
//         Arrays.sort(dist, 0, n - 1);
//         //int upperLast = (int) Math.ceil(dist[n - 1] / hourFrac);
//         int upper; // = Math.max(upperLast, dist[n - 2]);
//         if (hourFrac > EPS) {
//             int upperLast = calcSpd(dist[n - 1], hourFrac);//(int) Math.ceil(dist[n - 1] / hourFrac);
//             upper = Math.max(upperLast, dist[n - 2]);
//         } else {
//             upper = Math.max(dist[n - 1], dist[n - 2]);
//         }
//         // [1, 1, 1] 2.1
//         // System.out.println(Math.ceil(dist[n - 1] / hourFrac));
//         // not working, since [1, 1, 10000] 2.01 get upperLast = 10000001
//         // if (hourInt == n - 1) {
//         //     return upper;
//         // }
//         int l = 1;
//         int r = upper;
//         while (l < r) {
//             int mid = (l + r) / 2;
//             double res = calcTime(dist, mid);
//             // System.out.println(mid + "," + res);
//             if (res > hour) {
//                 l = mid + 1;
//             } else {
//                 r = mid;
//             }
//         }
//         return l;
//     }
// }


// 想法:除了最后的一站,其他一个最少1小时,
// n-1个元素排序,每富裕1小时就给前面多分配1小时,不过好像不好分配.
// class NotSolution {
//     static final EPS = 1e-9;
//     public int minSpeedOnTime(int[] dist, double hour) {
//         int n = dist.length;
//         int hourInt = (int) hour;
//         double hourFrac = hour - hourInt;
//         if (hourInt + 1 < n || hourFrac < EPS && hourInt < n) {
//             return -1;
//         }
//         Arrays.sort(dist, 0, n - 1);
//         int spdLast = dist[n - 1] / hourFrac;
//     }
// }
