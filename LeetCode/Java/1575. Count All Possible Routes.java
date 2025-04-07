class Solution {
    int[][] dp;

    private int dpPosFuel(int[] locations, int current, int finish, int fuel) {
        //System.out.println("current, fuel:" +current + "," + fuel);
        //System.out.println(dp[current][fuel]);
        if (fuel < 0) {
            return 0;
        }
        if (dp[current][fuel] > 0) {
            //System.out.println("current, fuel:" +current + "," + fuel);
            //System.out.println(dp[current][fuel]);
            return dp[current][fuel];
        }
        if (current == finish) {
            dp[current][fuel] = 1;
        }
        int n = locations.length;
        int dist = locations[finish] - locations[current];
        dist = dist > 0 ? dist : -dist;
        if (dist > fuel) {
            return 0;
        } // code below casue double of return, since current to finish will be 
          // calculated in the loop  
            // else {
            // dp[current][fuel] += 1;
        //}
        for (int i = 0; i < current; i++) {
            dist = locations[i] - locations[current];
            dist = dist > 0 ? dist : -dist;
            dp[current][fuel] += dpPosFuel(locations, i, finish, fuel - dist);
            if (dp[current][fuel] > 1_000_000_007) {
                dp[current][fuel] -= 1_000_000_007;
            }
        }
        for (int i = current + 1; i < n; i++) {
            dist = locations[i] - locations[current];
            dist = dist > 0 ? dist : -dist;
            dp[current][fuel] += dpPosFuel(locations, i, finish, fuel - dist);
            if (dp[current][fuel] > 1_000_000_007) {
                dp[current][fuel] -= 1_000_000_007;
            }
        }
        //System.out.println("current, fuel:" +current + "," + fuel);
        //System.out.println(dp[current][fuel]);
        return dp[current][fuel];
    }

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        if (start < 0 || start >= n) {
            return 0;
        }
        if (finish < 0 || finish >= n) {
            return 0;
        }
        int dist = locations[finish] - locations[start];
        if (dist > fuel || dist < -fuel) {
            return 0;
        }
        dp = new int[n][fuel + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        return dpPosFuel(locations, start, finish, fuel);

    }
}


/** 递归
    dp[i][j] routes of location i with remain fuel j

    result: sum{dp[finish][0~fuel]}

    dp[i][j] = dp[k][l] + 1 
        if j - dist[i][k] >= disk[k][finish]
*/
