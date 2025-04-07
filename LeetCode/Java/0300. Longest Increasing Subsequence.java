class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int num : nums) {
            // add to tail
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
                continue;
            }
            // binary search pos
            // binarySearch(num, sub);
            int l = 0;
            int r = sub.size() - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (sub.get(m) < num) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            // replace
            // no need to compare
            // if larger than all, already added
            // found must be the most left one that no smaller than num
            // int found = sub.get(l);
            // if (found > num) {
            //     sub.set(l, num);
            //     continue;
            // }
            sub.set(l, num);
            
        }
        // for (Integer s : sub) {
        //     System.out.println(s);
        // }
        return sub.size();
    }
}
// build sub using binary search
// 铭记sub不是满足要求的子串，只是长度相同
// 例如[3, 4, 5, 1], sub会是[1, 4, 5]
// 最后一位有更小的选择时，更新为更小的，这是直观的
// 但是更新前面的是为了用新的更好的可能结果覆盖旧的
// 例如[3,5,6,2,5,4,19,5,6,7,12]
// 只更新最后的,是[3, 5, 6, 7, 12], 会导致只会更新nums[0]开始的串
// i = 3时,用2更新3, 这样的结果是逐步构建2开头的串并记录,但是目前没有超过已有的3开头的而已
// 这里新串会记录的只有是比目前sub里的数要小时, 比如i=5时,用4更新5, 
// 这样保证更新有意义(有更大'潜力'变长)
// 需要好好理解这个思想
// 由673的最优引到这里