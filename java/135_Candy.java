// Top Interview 150 Q15
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int up = 0;
        int down = 0;
        int peak = 0;
        int candies = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                up++;
                peak = up + 1;
                down = 0;
                candies += peak;
            } else if (ratings[i] == ratings[i - 1]) {
                peak = 0;
                up = 0;
                down = 0;
                candies++;
            } else {
                down++;
                up = 0;
                candies += down + (peak > down ? 0 : 1);
            }
        }
        return candies;
    }
}
// 1.1 more clear structure
//  up is up trail count except start, including peak, 
//  down is down trail except pea, including end;
// so peak = up + 1
// if peak <= down, means down has more points, and peak should be down + 1
// so for every peak <= down, lift peak by 1.


// 1.   O(n) w/ O(1) idea:
//  consider it as peaks, each peak has up and down
//  for up need [1 ~ up] candies, for down [1 ~ down]
//  and the peak is max(up, down)

// 1.2 Impl
// class Solution {
//     int count(int n) {
//         return n * (n + 1) / 2;
//     }
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         if (n == 1) {
//             return 1;
//         }
//         int prevSlope = 0;
//         int up = 0, down = 0;
//         int ans = 0;
//         for (int i = 1; i < n; i++) {
//             int currSlope = Integer.compare(ratings[i], ratings[i - 1]);
//             // update when peak is over
//             // aka. valley is reached
//             if (/*prevSlope != 0 && */(currSlope == 0 || (prevSlope < 0 && currSlope > 0))) {
//                 // # up points + # down points + peak value
//                 // up is added after [i] > [i - 1], consider it is for i - 1
//                 // so peak is not included.

//                 // In fact the peak should be max(up, down) + 1,
//                 // but if remove the valley point, can delay to last peak count
//                 ans += count(up) + count(down) + Math.max(up, down);
//                 up = 0;
//                 down = 0;
//             }
//             prevSlope = currSlope;
//             if (currSlope == 0) {
//                 ans++;
//                 continue;
//             }
//             if (currSlope < 0) {
//                 down++;
//                 continue;
//             }
//             up++;

//         }
//         // for this idea, you can see the last point of each peak
//         // aka. the valley, is not included in the previous count.

//         // so the last one need to take care of it with +1.
//         ans += count(up) + count(down) + Math.max(up, down) + 1;
//         return ans;
//     }
// }


// 2. Two pass(Actuall Fastest):
// Left to right: consider it as order the `up` trail
// Right to left: consider it as order the `down` trail, and translate the peak to
//  the higher point of up and down.
// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         int[] candies = new int[n];
//         candies[0] = 1;
//         for (int i = 0; i < n - 1; i++) {
//             if (ratings[i] < ratings[i + 1]) {
//                 candies[i + 1] = candies[i] + 1;
//             } else {
//                 candies[i + 1] = 1;
//             }
//         }
//         int ans = 0;//candies[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             if (ratings[i] > ratings[i + 1] /*&& candies[i] < candies[i + 1] + 1*/) {
//                 candies[i] = Math.max(candies[i], candies[i + 1] + 1);
//             }
//             // ans += candies[i];
//         }
//         for (int candy : candies) {
//             ans += candy;
//         }
//         return ans;
//     }
// }

// 3. O(n^2) brute force -- The Solution Should Come to Mind
// since max candy is n, sim the process, adjust each time until valid
// so each point modified at most n, n points is O(n^2)
// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         int[] candies = new int[n];
//         boolean changed = true;
//         while (changed) {
//             changed = false;
//             for (int i = 0; i < n - 1; i++) {
//                 if (ratings[i] < ratings[i + 1] && candies[i] >= candies[i + 1]) {
//                     candies[i + 1] = candies[i] + 1;
//                     changed = true;
//                 }
//             }
//             for (int i = n - 1; i > 0; i--) {
//                 if (ratings[i] < ratings[i - 1] && candies[i] >= candies[i - 1]) {
//                     candies[i - 1] = candies[i] + 1;
//                     changed = true;
//                 }
//             }
//         }
//         int sum = 0;
//         for (int i = 0; i < n; i++) {
//             sum += candies[i] + 1;
//         }
//         return sum;
//     }
// }
