// LeetCode 75 Hash Map / Set Q3
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m != n) {
            return false;
        }
        // important condition!
        if (word1.equals(word2)) {
            return true;
        }
        byte[] ch1 = word1.getBytes();
        byte[] ch2 = word2.getBytes();
        int[] count1 = new int['z' + 1];
        int[] count2 = new int['z' + 1];
        for (byte c : ch1) {
            count1[c]++;
        }
        for (byte c : ch2) {
            count2[c]++;
        }
        // can upgrade this part with bitwise map
        for (int i = 'a'; i <= 'z'; i++) {
            // if ((count1[i] == 0 && count2[i] != 0)
            //  || (count1[i] != 0 && count2[i] == 0)) {
            if ((count1[i] == 0) ^ (count2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        for (int i = 'a'; i <= 'z'; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
        // return Arrays.equals(count1, count2);
    }
}
