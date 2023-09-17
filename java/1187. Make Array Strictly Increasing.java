class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int n = arr1.length;

        if (n <= 1) {
            return 0;
        }

        // Integer[] b = Stream.of(arr2)
        //                     .distinct()
        //                     .sorted()
        //                     .toArray(Integer[]::new);
        //Set<Integer> set = new LinkedHashSet<Integer>(Arrays.asList(arr2));
        Set<Integer> set = new TreeSet<>();
        for (int i : arr2) {
            set.add(i);
        }
        Integer[] b = set.toArray(new Integer[0]);
        // Arrays.sort(b);
        // Arrays.stream(b).forEach(e -> System.out.println(e));
        int m = b.length;
        int[][] swap = new int[2][m];
        int[] keep = new int[2];
        keep[0] = 0;
        keep[1] = 2_001;
        Arrays.fill(swap[0], 1);
        Arrays.fill(swap[1], 2_001);
        int idx = 0;
        int prevMinSwap = 1;
        for (int i = 1; i < n; i++) {
            int minSwapK = 2_001;
            int minSwapJ = 2_001;
            keep[1 - idx] = 2_001;
            if (arr1[i - 1] < arr1[i]) {
                keep[1 - idx] = keep[idx];
            }
            for (int j = 0; j < m; j++) {
                swap[1 - idx][j] = 2_001;
                if (j > 0) {
                    //  处理k<j时的min(swap[i-1][k])
                    minSwapK = Math.min(minSwapK, swap[idx][j - 1]);
                }
                if (arr1[i] > b[j]) {
                    minSwapJ = Math.min(minSwapK, swap[idx][j]);
                }
                if (arr1[i - 1] < b[j]) {
                    swap[1 - idx][j] = keep[idx] + 1;
                }
                keep[1 - idx] = Math.min(keep[1 - idx], minSwapJ);
                swap[1 - idx][j] = Math.min(swap[1 - idx][j], minSwapK + 1);
                //System.out.println("i, j, keep, swap" + "," + i +"," + j + "," + keep[1 - idx] +"," + swap[1 - idx][j]);
            }
            idx = 1 - idx;
        }
        //idx = 1 - idx;
        int ans = keep[idx];
        for (int i = 0; i < m; i++) {
            if (ans > swap[idx][i]) {
                ans = swap[idx][i];
            }
        }
        if (ans >= 2_001) {
            ans = -1;
        }
        return ans;
    }
}
// 官方解法很不同，用map<prev, cost>存在dp队列中来处理

// 分情况讨论的dp，需要想仔细一点
// 状态转移写好之后，对于min的处理要想清楚
// 因为min不是对任意的j，而是小于j和小于等于j，应该在j循环里对i-1的swap来取min

// 为了节省空间，使用循环数组，但是因为分了4种情况，两种keep两种swap
// 需要比较来决定最后的keep和swap，这种情况下，在最后取min比较好，
// 因此要在循环开始给循环数组将要更新的一行赋值为inf
/**
    after hint
    swap[i][j] opertations that arr1[i] in arr1[i] arr2[j] swapped
    keep[i] operations that arr1[i] remain

    a[i - 1] a[i]   
        if a[i - 1] < a[i]
            keep[i] = keep[i - 1]
    b[k]     a[i] 
        if b[k] < a[i] k<=j
            keep[i] = min{swap[i - 1][k]}
    a[i - 1] b[j]
        if a[i - 1] < b[j]
            swap[i][j] = keep[i - 1] + 1
    b[k]     b[j] k < j
        if (j > 0)
            swap[i][j] = min{swap[i - 1][k] + 1}


    }
 */





/*  intuition thought
    dp[i] result for arr1[0 ~ i]
    l[i][j] smallest last element when #operations = j (dp[i] ~ i )
    l[i][dp[i]] = arr1[i]
    
    arr1[i] > arr1[i - 1]:
        dp[i] = dp[i - 1];
        l[i][dp[i]] = arr1[i];
        l[i][dp[i] + 1] = arr2[idx] that  dp[i - 1] < arr2[idx] < dp[i]
        l[i][j] = min{arr1[i], arr2[idx] that l[i - 1][j - 1] < arr2[idx] < arr1[i]}
    
    arr1[i] <= arr1[i - 1]:
        dp[i] = min{ k + 1 that l[i-1][k] < arr1[i],
                     dp[i - 1] + 1 that exsit arr1[i-1] < arr2[idx]}
        return -1 if cannot find
        l[i][dp[i]] = arr1[i] if 1st path
                      arr2[idx] if 2nd path;
        l[i][dp[i] + 1] = arr2[idx] that  dp[i - 1] < arr2[idx] < dp[i]
        l[i][j] = min{arr1[i], arr2[idx] that l[i - 1][j - 1] < arr2[idx] < arr1[i]}
 */
