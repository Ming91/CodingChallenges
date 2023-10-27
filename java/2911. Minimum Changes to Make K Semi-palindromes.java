// Weekly Contest 368 Q4
class Solution {
    static int inf = 200;
    List<Integer>[] factorLists;// = getFactorLists(inf); //getDivisors(inf);
    int n;
    int k;
    char[] ch;
    Integer[][][] stepwiseCost;
    Integer[][] cost, d;
    public int minimumChanges(String s, int k) {
        this.k = k;
        n = s.length();
        ch = s.toCharArray();
        
        // [***] This cost most part of the time. 
        //  So memorization actually cost more time. 
        // stepwiseCost = new Integer[n][n][n];

        factorLists = getFactorLists(n);
        cost = new Integer[n + 1][n + 1];
        d = new Integer[n + 1][n + 1];
        // return calcDP(n - 1, k);
        return calcDP();
        // return calc(n, k);
    }
    static List<Integer>[] getFactorLists(int n) {
        List<Integer>[] l = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            l[i] = new ArrayList<>();
            l[i].add(1);
        }
        for (int factor = 2; factor < n; factor++) {
            for (int num = factor + factor; num <= n; num += factor) {
                l[num].add(factor);
            }
        }
        return l;
    }
    int calcDP() {
        int[] dp = new int[n];
        for (int i = n - k * 2 + 1; i >= 1; i--) {
            dp[i] = getCost(0, i);
        }
        int bound = 0;
        for (int subs = 2; subs <= k; subs++) {
            bound = subs * 2;
            for (int i = n - 1 - k * 2 + subs * 2; i >= bound - 1; i--) {
                dp[i] = inf;
                for (int prev = bound - 3; prev < i - 1; prev++) {
                    dp[i] = Math.min(dp[i], dp[prev] + getCost(prev + 1, i));
                }
            }
        }
        return dp[n - 1];
    }
    int getCost(int l, int r) {
        if (l >= r) {
            return inf;
        }
        if (cost[l][r] != null) {
            return cost[l][r];
        }
        cost[l][r] = inf;
        for (int factor : factorLists[r - l + 1]) {
            cost[l][r] = Math.min(cost[l][r], getStepwiseCost(l, r, factor));
        }
        return cost[l][r];
    }
    int getStepwiseCost(int l, int r, int stepsize) {
        if (l >= r) {
            return 0;
        }
        // if (stepwiseCost[l][r][stepsize] != null) {
        //     return stepwiseCost[l][r][stepsize];
        // }
        int left = 0;
        int right = 0;
        int count = 0;
        for (int i = 0; i < stepsize; i++) {
            left = l + i;
            right = r - stepsize + 1 + i;
            while (left + stepsize <= right) {
                if (ch[left] != ch[right]) {
                    count++;
                }
                left += stepsize;
                right -= stepsize;
            }
        }
        return count;
        // len % stepsize == 0, so the recursion end at l+stepsize=r,
        //  no condition like [1, 1, 1, 2, 3, 3, 3] and stepsize=3.
        // int diff = 0;
        // for (int i = 0; i < stepsize; i++) {
        //     diff += ch[l + i] == ch[r - stepsize + 1 + i] ? 0 : 1;
        // }
        // stepwiseCost[l][r][stepsize] = diff + 
        //     getStepwiseCost(l + stepsize, r - stepsize, stepsize);
        // return stepwiseCost[l][r][stepsize];
    }
}
// [Beat 99%] [Failed]
//  I didn't solve this.
//  But apparently we can save one dimension since always k-1->k. 
//  Preprocess the factor lists of [1~200] is also a good idea. 
//  Memorize the cost but not stepsizeCost, since it takes too much space. 

// [Lee] dp[i][k] = min(dp[j][k-1] + cost[j + 1][i]) for j in [1 ~ i - 2]
//  1. get the factor/divisor lists 
//  2. update dp
//      2.0. calc cost[][], need to go through all factors of len=r-l+1 (except itslef), 
//           find the min cost among such factors 
//      2.0.0   for given [l][r][d], 
//              [l][r][d] = [l+d][r-d][d] + (diffs in [l~l+d-1] and [r-d+1~r])
// class Solution {
//     char[] ch;
//     Integer[][][] semi;
//     Integer[][] distance;
//     Map<Integer, List<Integer>> factorMap;
//     int getSemi(int l, int r, int step) {
//         if (l >= r) {
//             return 0;
//         }
//         if (semi[l][r][step] != null) {
//             return semi[l][r][step];
//         }
//         int diff = 0;
//         for (int i = 0; i < step; i++) {
//             diff += ch[l + i] == ch[r - step + 1 + i] ? 0 : 1;
//         }
//         semi[l][r][step] = diff + getSemi(l + step, r - step, step);
//         return semi[l][r][step];
//     }
//     int getDistance(int l, int r) {
//         if (distance[l][r] != null) {
//             return distance[l][r];
//         }
//         distance[l][r] = 200;
//         for (int factor : factorMap.getOrDefault(r - l + 1, List.of(1))) {
//             distance[l][r] = Math.min(distance[l][r], getSemi(l, r, factor));
//         }
//         return distance[l][r];
//     }
//     public int minimumChanges(String s, int k) {
//         int n = s.length();
//         ch = s.toCharArray();
//         distance = new Integer[n][n];
//         semi = new Integer[n][n][n];
//         factorMap = new HashMap<>();
//         for (int len = 2; len < n; len++) {
//             for (int num = len + len; num <= n; num += len) {
//                 factorMap.computeIfAbsent(num, key -> new ArrayList<>(){{add(1);}}).add(len);
//             }
//         }
//         int[] dp = new int[n];
//         for (int i = n - 1; i >= 0; i--) {
//             dp[i] = getDistance(0, i);
//         }
//         // System.out.println(Arrays.toString(dp));
//         int bound = 0;
//         for (int subs = 2; subs <= k; subs++) {
//             bound = 2 * subs;
//             for (int i = n - 1; i >= bound - 1; i--) {
//                 // System.out.println(Arrays.toString(dp));
//                 dp[i] = 200;
//                 for (int prev = bound - 3; prev < i - 1; prev++) {
//                     dp[i] = Math.min(dp[i], dp[prev] + getDistance(prev + 1, i));
//                 }
//             }
//         }
//         return dp[n - 1];
//         // return 0;
//     }
    
//     // [Ming] A failed impl. 
//     // void getDistance(Integer[][] v, char[] ch, int l, int r, Map<Integer, List<Integer>> factorMap) {
//     //     if (v[l][r] != null) {
//     //         return;
//     //     }
//     //     if (l >= r) {
//     //         v[l][r] = 0;
//     //         return;
//     //     }
//     //     // if (l + 1 == r) {
//     //     //     v[l][r] = ch[l] == ch[r] ? 0 : 1;
//     //     //     return;
//     //     // }
//     //     v[l][r] = 200;
//     //     // int diff = 0;
//     //     // int last = 0;
//     //     // System.out.println(r - l + 1);

//     //     // [Wrong❌] This is wrong, since the how recursive should use the same interval
//     //     // Rather than use each optimal interval. 
//     //     for (int factor : factorMap.getOrDefault(r - l + 1, List.of(1))) {
//     //         getDistance(v, ch, l + factor, r - factor, factorMap);
//     //         int diff = 0;
//     //         for (int i = 0; i < factor; i++) {
//     //             diff += ch[l + i] == ch[r - factor + 1 + i] ? 0 : 1;
//     //         }
//     //         // last = factor;
//     //         v[l][r] = Math.min(v[l][r], v[l + factor][r - factor] + diff);
//     //     }
//     // }
// }
