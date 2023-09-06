// Top Interview 150 Q17
class Solution {
    
    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            switch (s.charAt(i)) {
                case 'V':
                    ans += 5;
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'M':
                    ans += 1000;
                    break;
                case 'I':
                    if (i < n - 1 && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                        ans--;
                    } else {
                        ans++;
                    }
                    break;
                case 'X':
                    if (i < n - 1 && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                        ans -= 10;
                    } else {
                        ans += 10;
                    }
                    break;
                case 'C':
                    if (i < n - 1 && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                        ans -= 100;
                    } else {
                        ans += 100;
                    }
                    break;
            }
            i++;
            // System.out.println(ans);
        }
        return ans;
    }
}
// convert to map, and check if next > curr is a better practice
