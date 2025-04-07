// Weekly Premium Sep 2023 W2
class Solution {
    public String rearrangeString(String s, int k) {
        if (k <= 1) {
            return s;
        }
        int n = s.length();
        char[] ans = new char[n];
        int[][] count = new int[26][2];
        for (char c : s.toCharArray()) {
            count[c - 'a'][0]++;
        }
        int max = -1;
        int maxCount = 1;
        for (int i = 0; i < 26; i++) {
            count[i][1] = i;
            if (max < count[i][0]) {
                max = count[i][0];
                maxCount = 1;
            } else if (max == count[i][0]) {
                maxCount++;
            }
        }
        if ((n + k - maxCount) / k < max) {
            return "";
        }
        Arrays.sort(count, (a, b) -> (b[0] - a[0]));
        // System.out.println(Arrays.deepToString(count));
        int maxMinusOne = 26;
        for (int i = 0; i < 26; i++) {
            if (count[i][0] < max - 1) {
                maxMinusOne = i;
                break;
            }
        }
        StringBuilder[] sb = new StringBuilder[max];
        for (int i = 0; i < max - 1; i++) {
            sb[i] = new StringBuilder();
            for (int j = 0; j < maxMinusOne; j++) {
                sb[i].append((char)(count[j][1] + 'a'));
            }
        }
        sb[max - 1] = new StringBuilder();
        for (int i = 0; i < maxCount; i++) {
            sb[max - 1].append((char)(count[i][1] + 'a'));
        }
        int charIdx = maxMinusOne;
        int currSeg = 0;
        while (charIdx < 26) {
            while (count[charIdx][0] > 0) {
                sb[currSeg].append((char)(count[charIdx][1] + 'a'));
                count[charIdx][0]--;
                currSeg = (currSeg + 1) % (max - 1);
            }
            while (charIdx < 26 && count[charIdx][0] == 0) {
                charIdx++;
            }
        }
        return String.join("", sb);
    }
}
// 1. count letters occurance
// 2. split string with max segments
// 3. assign letter that count = max to each segments
// 4. assign letter that count = max - 1 to first max - 1 segments
//    *** This is the key point. If assign this kind of letters with round-robin,
//        will cause same letter with max-1 count assign to max-1 segments 
//        while having different index in some segments. 
//    eg. abcdabcdabdeac k = 4 -> a___a___a___a_ -> ab__ab__ab__a__ -> abc_abc_ab__ac
//        -> abcdabcdabd_ac, cause dabd invalid.
// 5. assign count < max - 1 to first max-1 segments with round-robin.
