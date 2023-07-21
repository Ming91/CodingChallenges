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
// 由673的最优引到这里
