class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        
        StringBuilder s12 = new StringBuilder();
        StringBuilder s21 = new StringBuilder();
        s12 = s12.append(str1).append(str2);
        s21 = s21.append(str2).append(str1);
        if (!s12.toString().equals(s21.toString())) {
            return "";
        }
        if (m == n) {
            return str1;
        }
        String ans = "";
        if (m > n) {
            return gcdOfStrings(str2, str1.substring(n, m));
        } else {
            return gcdOfStrings(str1, str2.substring(m, n));
        }
    }
}
// 精妙之处在于验证
// 方法1：Check if the concatenations of str1 and str2 in different orders are the same.
// If not, return "".
// 方法2：l.startsWith(s) 如果有解，长串一定startswith短串
