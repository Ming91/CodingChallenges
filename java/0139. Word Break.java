// Daily Challenge 08/04/2023
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {        
//         Set<String> dict = new HashSet<>(wordDict);
//         char[] ch = s.toCharArray();
//         int n = ch.length;
//         boolean[] dp = new boolean[n + 1];
//         dp[0] = true;
//         // for (int i = 1; i <= n; i++) {
//         //     dp[i] = dict.contains(s.substring(0, i));
//         //     // System.out.print(dp[i] + ",");
//         // }
//         int maxLen = 0;
//         for (String word : wordDict) {
//             maxLen = maxLen < word.length() ? word.length() : maxLen;
//         }
//         for (int i = 0; i < n; i++) {
//             if (!dp[i]) {
//                 continue;
//             }
//             for (int j = i + 1; j <= i + maxLen && j <= n; j++) {
//                 if (dp[j]) {
//                     continue;
//                 }
//                 if (dict.contains(s.substring(i, j))) {
//                     dp[j] = true;
//                 }
//             }
//         }
//         return dp[n];
//     }
// }
// compare byte by byte, n*n*compare()
// 学习后的改进：把string的maxlen找出来，不用j<=n, 只用j<= i + maxlen

// recursive version, 别人的代码: 可以保证只访问需要的idx
class Solution {
    static boolean solve(int ind , String s, List<String> wordDict , Boolean[] dp){
        if(ind >= s.length()) return true;
        
        // 这里需要考虑下，如果dp[ind]是true, 之前应该一路true回去了
        // 所以dp[ind] 应该必然是false; 可是替换成false后有一次跑的结果还慢了
        // 另一个看到的方法, 是用visited[]来看是否访问过, dp的值直接是每次返回, 不存
        // if(dp[ind] != null) return dp[idx];
        // 用下面打印检测了,的确如此
        // if (dp[ind]!= null && dp[ind] == true) {
        //     System.out.println(123);
        // }

        // 注意,用的是Boolean, wrap过的, 因此会有null
        // if (dp[ind]==null) {
        //     System.out.println(123);
        // }
        if(dp[ind] != null) return false;

        boolean res = false;
        for(String st : wordDict){
            int n = st.length();
            if(s.length() - ind < n) continue;
            if(s.substring(ind , ind + n).equals(st) && solve(ind + n , s , wordDict , dp)){
                res = true;
                break;
            }
        }
        return dp[ind] = res;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(0 , s , wordDict , new Boolean[s.length()]);
    }
}

// update curr from prev, faster.
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         boolean[] dp = new boolean[n + 1];
//         dp[0] = true;
//         for (int i = 1; i <= n; i++) {
//             if (dp[i]) {
//                 continue;
//             }
//             for (String word : wordDict) {
//                 int len = word.length();
//                 // valid check
//                 if (i < len) {
//                     continue;
//                 }
//                 // early stop
//                 if (!dp[i - len]) {
//                     continue;
//                 }
//                 if (s.substring(i - len, i).equals(word)) {
//                     dp[i] = true;
//                     break;
//                 }
//             }

//         }
//         return dp[n];
//     }
// }

// 用队列的方法，update succ from curr, 跟下面没啥差别
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         boolean[] dp = new boolean[n + 1];
//         Queue<Integer> q = new LinkedList<>();
//         dp[0] = true;
//         q.offer(0);
//         while (!q.isEmpty())
//         {
//             int i = q.poll();
//             for (String word : wordDict) {
//                 int len = word.length();
//                 // valid check
//                 if (i + len > n) {
//                     continue;
//                 }
//                 // early stop
//                 if (dp[i + len]) {
//                     continue;
//                 }
//                 if (s.substring(i, i + len).equals(word)) {
//                     dp[i + len] = true;
//                     q.offer(i + len);
//                 }
//             }

//         }

//         return dp[n];
//     }
// }
// update succ from curr, early stop
// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         boolean[] dp = new boolean[n + 1];
//         dp[0] = true;
//         for (int i = 0; i < n; i++) {
//             if (!dp[i]) {
//                 continue;
//             }
//             for (String word : wordDict) {
//                 int len = word.length();
//                 // valid check
//                 if (i + len > n) {
//                     continue;
//                 }
//                 // early stop
//                 if (dp[i + len]) {
//                     continue;
//                 }
//                 if (s.substring(i, i + len).equals(word)) {
//                     dp[i + len] = true; 
//                 }
//             }

//         }
//         return dp[n];
//     }
// }

