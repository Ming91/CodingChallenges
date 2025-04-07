// Biweekly Contest 111 Q4
class Solution {
    // dp[pos][under][started][even][odd][remainder]
    // dp[pos][under][started][evenOdd][remainder]
    Integer[][][][]/*[]*/[] dp;
    int k;
    int calcDP(String s, int pos, boolean under, boolean started, int even, /*int odd, */int remainder) {
        if (pos == s.length()) {
            return (started && even == 10/*odd*/ && remainder == 0) ? 1 : 0;
        }
        if (dp[pos][under ? 1 : 0][started ? 1 : 0][even]/*[odd]*/[remainder] != null) {
            // System.out.println('x');
            return dp[pos][under ? 1 : 0][started ? 1 : 0][even]/*[odd]*/[remainder];
        }
        int ans = 0;
        int diff = s.charAt(pos) - '0';
        for (int i = 0; i < 10; i++) {
            if (!under && i > diff) {
                break;
            }
            boolean isUnder = under || (i < diff);
            boolean isStarted = started || (i != 0);
            // int newOdd = isStarted ? odd + (i & 1) : 0;
            // int newEven = isStarted ? even + 1 - (i & 1) : 0;
            int newEven = 10;
            if (isStarted) {
                newEven = even + ((i & 1) == 1 ? -1 : 1);
            }
            int newRemainder = isStarted ? (remainder * 10 + i) % k : 0;
            ans += calcDP(s, pos + 1, isUnder, isStarted, newEven, /*newOdd, */newRemainder);
        }
        dp[pos][under ? 1 : 0][started ? 1 : 0][even]/*[odd]*/[remainder] = ans;
        return ans;
    }
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k = k;
        String highStr = String.valueOf(high);
        String lowStr = String.valueOf(low - 1);
        // int maxDigits = Math.max(highStr.length(), lowStr.length());
        // lowStr = String.format("%0" + maxDigits + "d", low - 1);
        
        dp = new Integer[10][2][2][20]/*[10]*/[k];
        int h = calcDP(highStr, 0, false, false, 10, /*0, 0, */0);
        dp = new Integer[10][2][2][20]/*[10]*/[k];
        int l = calcDP(lowStr, 0, false, false, 10, /*0, 0, */0);
        // System.out.println(h + "," + l);
        return h - l;
    }
}
// idea: digit DP
// iterate through each digit, [pos][under][started] is standard dimension
// @param pos is digit position
// @param under is whether current number less than target, use this for later early stop
// @param started is whether current number is all zero. use this to simplify calc and 
//          return result when stop.
// for this problem add [evenOdd][remainder]
// @param evenOdd is even - odd + 10 in this problem
// @param remainder is current number % k

// run dp for each high and low. each dp value is based on the input number, and not based
// on the current number. so, we can't use information from first dp in the second.

// eg: k = 2
// 0021 0023 -- same dp all 1 at first reach

// 004xx 002xx -- same dp, since all characteristics before 004 or 002 are same, 
//  if 002xy valid, 004xy also valid, can just add from previous result

// TLE for simulation
// class Solution {
//     public int numberOfBeautifulIntegers(int low, int high, int k) {
//         int start = (low + k - 1) / k * k;
//         int curr = start;
//         int count = 0;
//         while (curr <= high) {
//             int even = 0;
//             int odd = 0;
//             int c = curr;
//             while (c > 0) {
//                 if (((c % 10) & 1) == 0) {
//                     even++;
//                 } else {
//                     odd++;
//                 }
//                 c = c / 10;
//             }
//             if (even == odd) {
//                 count++;
//             }
//             curr += k;
//         }
//         return count;
//     }
// }
