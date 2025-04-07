// Daily Question 10/19/2023
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sCount = 0;
        int tCount = 0;
        int sIdx = s.length() - 1;
        int tIdx = t.length() - 1;
        while (sIdx >= 0 || tIdx >= 0) {
            while (sIdx >= 0) {
                if (s.charAt(sIdx) == '#') {
                    sCount++;
                    sIdx--;
                    continue;
                }
                if (sCount == 0) {
                    break;
                }
                sCount--;
                sIdx--;
            }
            while (tIdx >= 0) {
                if (t.charAt(tIdx) == '#') {
                    tCount++;
                    tIdx--;
                    continue;
                }
                if (tCount == 0) {
                    break;
                }
                tCount--;
                tIdx--;
            }
            if (sIdx < 0 && tIdx < 0) {
                return true;
            }
            if (sIdx < 0 || tIdx < 0) {
                return false;
            }
            if (s.charAt(sIdx) != t.charAt(tIdx)) {
                return false;
            }
            sIdx--;
            tIdx--;
        }
        return true;
    }
}
