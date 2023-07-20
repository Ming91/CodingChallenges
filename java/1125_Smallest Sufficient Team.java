class Solution {
    int m, n;
    long[] dp;
    int[] personSkillMap;
    boolean[] prune;
    private long dfs(int skillMap) {
        if (dp[skillMap] >= 0) {
            return dp[skillMap];
        }
        long result = -1;
        for (int j = 0; j < n; j++) {
            if (prune[j]) {
                continue;
            }
            int beforeMap = skillMap & ~personSkillMap[j];
            if (beforeMap != skillMap) {
                long beforeResult = dfs(beforeMap);
                if (Long.bitCount(result) > Long.bitCount(beforeResult) + 1) {
                    result = beforeResult | (1L << j);     
                }
            }
        }
        dp[skillMap] = result;
        return result;
    }
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        m = req_skills.length;
        n = people.size();
        final int STATES_NUM = 1 << m;
        dp = new long[STATES_NUM];
        prune = new boolean[n];
        Arrays.fill(dp, -1);
        Arrays.fill(prune, false);
        dp[0] = 0L;

        personSkillMap = new int[n];
        // 要么都排序，要么用hashmap
        Arrays.sort(req_skills);
        for (int j = 0; j < n; j++) {
            List<String> person = people.get(j);
            personSkillMap[j] = 0;
            if (person.size() == 0) {
                continue;
            }
            // 或者用hashmap存string到idx
            Collections.sort(person);
            int mem = 0;
            for (String skill : person) {
                for (int i = mem; i < m; i++) {
                    if (skill.equals(req_skills[i])) {
                        personSkillMap[j] += 1 << i;
                        mem = i + 1;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int map1 = personSkillMap[i];
                int map2 = personSkillMap[j];
                if (map1 == (map1 | map2)) {
                    prune[j] = true;
                } else {
                    if (map2 == (map1 | map2)) {
                        prune[i] = true;
                    }
                }
            }
        }
        //int in = 0;
        long ansMap = dfs(STATES_NUM - 1);
        int ansLen = Long.bitCount(ansMap);
        int[] ans = new int[ansLen];
        int idx = 0;
        for (int i = 0; i < ansLen; i++) {
            while ((ansMap & 1) == 0) {
                ansMap = ansMap >> 1;
                idx++;
            }
            ans[i] = idx;
            ansMap = ansMap >> 1;
            idx++;
        }

        return ans;
    }
}
// top down dp
// memory
// beat 99% idea:
//  prune when possible, if people[i] | people[j] == people[i], can prune j

// bottom up dp
// attention: long operations!

// class Solution {
//     public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
//         int m = req_skills.length;
//         int n = people.size();
//         final int STATES_NUM = 1 << m;
//         long[] dp = new long[STATES_NUM];
//         Arrays.fill(dp, -1);
//         // maybe better use code below
//         // Arrays.fill(dp, 1L << n - 1);
//         dp[0] = 0;
//         for (int j = 0; j < n; j++) {
//             List<String> person = people.get(j);
//             if (person.size() == 0) {
//                 continue;
//             }
//             int map = 0;
//             for (String skill : person) {
//                 for (int i = 0; i < m; i++) {
//                     if (skill.equals(req_skills[i])) {
//                         map += 1 << i;
//                         break;
//                     }
//                 }
//             }
//             for (int state = 0; state < STATES_NUM; state++) {
//                 int before = state;
//                 int after = state | map;
//                 if (Long.bitCount(dp[after]) > Long.bitCount(dp[before]) + 1) {
//                     //long temp = (long) 1 << j;
//                     // 1<<j, only lowest 5 bits of j considered
//                     dp[after] = dp[before] | 1L << j;
//                 }
//             }
//         }
//         long ansMap = dp[STATES_NUM - 1];
//         int ansLen = Long.bitCount(ansMap);
//         int[] ans = new int[ansLen];
//         int idx = 0;
//         for (int i = 0; i < ansLen; i++) {
//             while ((ansMap & 1) == 0) {
//                 ansMap = ansMap >> 1;
//                 idx++;
//             }
//             ans[i] = idx;
//             ansMap = ansMap >> 1;
//             idx++;
//         }

//         return ans;
//     }
// }
