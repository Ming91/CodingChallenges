class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int l = 1;
        int r = target;
        int k = 0;
        long sumK = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            long sum = (long) (mid + 1) * mid / 2;
            if (sum < target) {
                //k = mid;
                l = mid + 1;
            } else {
                sumK = sum;
                k = mid;
                r = mid - 1;
            }
        }
        int diff = (int) (sumK - target);
        if (diff % 2 == 0) {
            return k;
        }
        if (k % 2 == 0) {
            return k + 1;
        }
        return k + 2;
    }
}

// beat 99% 改进:
// k++, 找到sum(k)>=target是sqrt(target)
// 在target以下二分查找, 是log(target)
// 注意用long
// 复习: sqrt' == (x^a)'|a = 1/2
//             == ax^(a-1) ==1/2 1/sqrt(x)
//      log'  == 1/(x ln(a))
// 推到log'可从定义出发, 最后回到e = lim (1 + 1/x)^x

class Solution_sqrt {
    public int reachNumber(int target) {
        int k = 0;
        target = Math.abs(target);
        while (target > 0) {
            k++;
            target -=k;
        }
        // if (target == 0) {
        //     return k;
        // }
        if (target % 2 == 0) {
            return k;
        }
        if (k % 2 == 0) {
            return k + 1;
        }
        return k + 2;
    }
}
// 数学题
// ()1()2()3...()n = target
// () = +-, 填空令n最小
// 全为+, 则为sum(n), 某个j变成-, 则-j*2

// 1.
// 若sum(k) == target, k为解
// ****k-1以下不可能为解,因为不变号也不可能到达target
// 2.
// 现在考虑 sum(k) < target < sum(k + 1)
// 数轴: sum(k) .... target ... sum(k + 1)
// sum(k) 到 sum(k+1) 距离为k+1
// diff = sum(k + 1) - target, diff < k + 1
// 若diff 为even, 则证明存在j < k + 1 满足target = sum(k + 1) - j * 2
// (j*2 = diff < k + 1, so j < k + 1)
// 解为k + 1(变号,不改变步数)
// (结合1, 即为满足sum>=target的最小sum(.)的可选值)
// ****同理,k步不行, k步全+也不到target
// 3.
// diff为odd, 则证明k和k+1步均不行
// k至多到sum(k), 
// sum(k)到sum(k+1)中间想要到达只能从sum(k+1)变号, 但是diff表明变不到
// 因此此时至少k+2步
// 此时diff2 = sum(k+2) - target = diff(odd) + k + 2
// k + 1为偶,则diff2为偶, 同k+1,变号1次即可, k=2步
// k + 1为奇数, 同理2,说明k+2步,即从sum(k+2)在(<=k+2)范围找变号不可行,
// 只能,再扩展到sum(k+3),diff3 = diff2 + k + 3此时一定为偶数,(diff(odd) +两个相邻数 = even)


// 搜索不行，超时
// class Solution {
//     Map<List<Integer>, Integer> dp;
//     int maxStep;
//     private int dfs(int current, int step, int target) {
//         if (current < 0) {
//             current = -current;
//         }
//         //int l = Integer.MAX_VALUE;
//         //int r = Integer.MAX_VALUE;
//         List<Integer> pairCurrent = List.of(current, step);
//         if (current == target) {     
//             dp.put(pairCurrent, 0);
//             return 0;
//         }
//         if (maxStep <= step) {
//             dp.put(pairCurrent, maxStep);
//             return maxStep;
//         }
//         //List<Integer> pairReverse = List.of(-current, step);
//         Integer minDp = dp.getOrDefault(pairCurrent, Integer.MAX_VALUE);
//         //Integer r = dp.getOrDefault(pairReverse, Integer.MAX_VALUE);
//         //Integer minDp = l < r ? l : r;
//         if (minDp == Integer.MAX_VALUE) {
//             int l = dfs(current + step, step + 1, target);
//             int r = dfs(current - step, step + 1, target);
//             minDp = Math.min(l, r) + 1;
//         }
//         dp.put(pairCurrent, minDp);
//         //dp.put(pairReverse, minDp);
//         return minDp;
//     }
//     public int reachNumber(int target) {
//         dp = new HashMap<>();
        
//         //minStep = Integer.MAX_VALUE;
//         if (target < 0) {
//             target = -target;
//         }
//         maxStep = 2 * target;
//         return dfs(0, 1, target);
//     }
// }
