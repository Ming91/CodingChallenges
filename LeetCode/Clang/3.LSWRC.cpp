/*
Copyright <2018> <wming9310@gmail.com>
*/
class Solution {
 public:
    int lengthOfLongestSubstring(string s) {
        int len = s.size();
        int max = 0;
        int head = 0;
        int tail = 0;
        int count = 0;
        int set[128];
        memset(set, -1, sizeof(set));
        for (int i = 0; i< len; i++) {
            if (set[s[i]] < 0) {
            } else {
                head = set[s[i]]+1 > head ? set[s[i]]+1 : head;
            }

            tail = i;
            count = tail - head + 1;
            max = (count > max) ? count : max;
            set[s[i]] = i;
        }
        return max;
    }
};
