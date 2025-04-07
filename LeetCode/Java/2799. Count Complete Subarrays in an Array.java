// Weekly Contest 356 Q2
class Solution {
    class MyInt {
        int val;
        int count;
        MyInt(int v, int c) {
            this.val = v;
            this.count = c;
        }
    }
    
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        Map<Integer, MyInt> map = new HashMap<>();
        int[] count = new int[2_001];
        for (int num : nums) {
            MyInt curr = map.get(num);
            count[num]++;
            if (curr == null) {
                map.put(num, new MyInt(num, 1));
            } else {
                curr.count++;
            }
        }
        int total = map.size();
        Set<Integer> s = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            s.clear();
            for (int j = i; j < n; j++) {
                s.add(nums[j]);
                if (s.size() == total) {
                    ans += n - j;
                    break;
                }
            }
        }
        return ans;
    }
}
