class Solution {
    public int findNumberOfLIS(int[] nums) {
        
    }
}

// how to use methond in problem 300, build subseq?

/**
一下代码思路错误,解题过程中的思考
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        List<Integer> lastList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        int count = 1;
        sub.add(nums[0]);
        lastList.add(nums[0]);
        countList.add(1);
        for (int j = 1; j < n; j++) {
            int num = nums[j];
            int size = sub.size();
            int last = sub.get(size - 1);
            if (num > last) {
                sub.add(num);
                int l = 0;
                int r = lastList.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (lastList.get(mid) >= num) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                // System.out.println("last");
                // for (int i = 0; i < lastList.size(); i++) {
                //     System.out.println(lastList.get(i) + "," + countList.get(i));
                // }
                count = 0;
                for (int i = l; i < lastList.size(); i++) {
                    count += countList.get(i);
                }
                lastList.clear();
                lastList.add(num);
                countList.clear();
                countList.add(count);
                continue;
            }
            // [1, 2] add 2, update lastList and countList
            // 当前的last一定是lastList里最后的一个,
            if (num == last) {
                int lastIdx = countList.size() - 1;
                count = countList.get(lastIdx) + 1;
                countList.set(lastIdx, count);
                continue;
            }
            int l = 0;
            int r = size - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sub.get(mid) < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            // if update last, update its count
            if (l == size - 1) {
                lastList.add(num);
                countList.add(1);
                count++;
            }
            sub.set(l, num);
        }
        // System.out.println("sub");
        // for (Integer s : sub) {
        //     System.out.println(s);
        // }
        return count;
    }
}

// smarter way: use problem 300 nlogn method -- build subseq using binary search
// 想法1: 一个sub,更新sub时,如果位置是最后,则count++
//   问题: [3, 1, 2], 2比3小, 此策略出问题.
//     解决: 加个last[], 看看怎么样
//      问题: [1,2,4,3,5,4,7,2]这种, 5继承了43的count2,7又继承了54的,但是这个5里的count是2
//       解决: 加个lastCount[]
//      问题: [2, 1]
//      问题: [1, 1, 1, 3, 3, 2, 2, 2]这种情况,这个办法没用,2已经不知道该继承多少个了
*/

// use editorial version topdown dp
// maybe bottom up faster

// class Solution {
//     private void dfs(int i, int[] nums, int[] len, int[] count) {
//         if (len[i] > 0) {
//             return;
//         }
//         // 这里处理比intuition好
//         // 之前是len和count都赋值1
//         // 但是遇到一个len为1的不知道是没访问过还是更新后为1
//         // 初值设置为0更好记忆和prune
//         len[i] = 1;
//         count[i] = 1;
//         for (int j = 0; j < i; j++) {
//             if (nums[j] < nums[i]) {
//                 dfs(j, nums, len, count);
//                 if (len[i] == len[j]  + 1) {
//                     count[i] += count[j];
//                 }
//                 if (len[i] < len[j] + 1) {
//                     count[i] = count[j];
//                     len[i] = len[j] + 1;
//                 }
//             }
            
//         }
//         return;
//     }
//     public int findNumberOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] len = new int[n];
//         int[] count = new int[n];
//         int maxLen = 0;
//         int maxCount = 0;
//         for (int i = 0; i < n; i++) {
//             dfs(i, nums, len, count);
//             if (len[i] > maxLen) {
//                 maxLen = len[i];
//             }
//         }
//         for (int i = 0; i < n; i++) {
//             if (len[i] == maxLen) {
//                 maxCount += count[i];
//             }
//         }
//         return maxCount;
//     }
// }


// intuition top down
// 记录以i结尾的count和len
// 挨个比较max
// 想法对头，表现不好

// class Solution {
//     int[] len;
//     int[] count;
//     private int dfs(int i, int[] nums) {
//         if (len[i] > 1) {
//             return len[i];
//         }
//         for (int j = 0; j < i; j++) {
//             if (nums[j] < nums[i]) {
//                 int lenJ = dfs(j, nums) + 1;
//                 if (len[i] == lenJ) {
//                     count[i] += count[j];
//                 }
//                 if (len[i] < lenJ) {
//                     len[i] = lenJ;
//                     count[i] = count[j];
//                 }
                
//             }
//         }
//         return len[i];
//     }
//     public int findNumberOfLIS(int[] nums) {
//         int n = nums.length;
//         len = new int[n];
//         count = new int[n];
//         Arrays.fill(len, 1);
//         Arrays.fill(count, 1);
//         int maxLen = -1;
//         int maxCount = 0;
//         for (int i = 0; i < n; i++) {
//             int lenI = dfs(i, nums);
//             if (maxLen == lenI) {
//                 maxCount += count[i];
//             }
//             if (maxLen < lenI) {
//                 //System.out.println(nums[i]);
//                 maxLen = len[i];
//                 maxCount = count[i];
//             }
//         }
//         //System.out.println(maxLen);
//         return maxCount;
//         //return count[n - 1];
//     }
// }
