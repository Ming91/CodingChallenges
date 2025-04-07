class Solution {

    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int[][] numCost = new int[n][2];
        for (int i = 0; i < n; i++) {
            numCost[i][0] = nums[i];
            numCost[i][1] = cost[i];
        }

        Arrays.sort(numCost, (a, b) -> (a[0] - b[0]));
        //Arrays.sort(numCost, (a, b) -> CompareInt(a[0], b[0]));

        long min = Long.MAX_VALUE;
        // dist diff nums[i] - nums[i - 1]
        
        // get the cost before and after for each nums[i], including cost[i];
        long[] costBefore = new long[n];
        long[] costAfter = new long[n];
        costBefore[0] = numCost[0][1];
        for (int i = 1; i < n; i++) {
            //costBefore[i] = costBefore[i - 1] + pairs[i].getCost();
            costBefore[i] = costBefore[i - 1] + numCost[i][1];
        }

        costAfter[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            costAfter[i] = costAfter[i + 1] + numCost[i + 1][1];
        }

        // calculate the sum that nums[0] as k
        long costSum = 0;
        for (int i = 1; i < n; i++) {
            //costSum += (nums[i] - nums[0]) * cost[i];
            costSum += (long) (numCost[i][0] - numCost[0][0]) * numCost[i][1];
        }
        //System.out.println(costSum);
        //min = costSum;
        for (int i = 1; i < n; i++) {
            int distDiff= numCost[i][0] - numCost[i - 1][0];
            if (distDiff == 0) {
                continue;
            }
            long costDiff = costBefore[i - 1] - costAfter[i - 1];
            if (costDiff > 0) {
                //System.out.println(pairs[i - 1].getNum() + "," + pairs[i - 1].getCost());
                return costSum;
            }
            costSum += costDiff * distDiff;
        }
        //System.out.println(pairs[n - 1].getNum() + "," + pairs[n - 1].getCost());
        return costSum;
    }
} 

/*
    thoughts after hint:

    optimal point k cant be out of n_max and n_min (or just move to edge can cost less)

    order nums, assume the optimal is k and between n[i] and n[i+1]
    
    .'''''.''''''''''.
    i     k          i+1
       l1       l2
    
    let |k - n[i]| be l1, |k - n[i+1]| be l2

    move frome n[i] to k, total cost:
        + cost[0 ~ i] * l1
        - cost[i+1 ~ n-1] * l1
     
    if +more, just move to n[i], 
    if -more, just move to n[i+1]

    so the optimal is always for the array
    
*/
