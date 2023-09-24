// Weekly Contest 364 Q1
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        int i = 0;
        var sb = new StringBuilder();
        for (; i < count - 1; i++) {
            sb.append("1");
        }
        for (; i < n - 1; i++) {
            sb.append("0");
        }
        sb.append("1");
        return sb.toString();
    }
}
