// Top Interview 150 Hashmap Q3
class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        char[] pChar = pattern.toCharArray();
        Map<Character, String> pToS = new HashMap<>();
        Set<String> visited = new HashSet<>();
        String[] sArr = s.split(" ");
        if (n != sArr.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char c = pChar[i];
            String str = sArr[i];
            if (pToS.containsKey(c) && !pToS.get(c).equals(str)) {
                return false;
            }
            if (!pToS.containsKey(c) && visited.contains(str)) {
                return false;
            }
            pToS.put(c, str);
            visited.add(str);
            // if (!pToS.containsKey(pChar[i])) {
            //     if (!visited.contains(sArr[i])) {
            //         visited.add(sArr[i]);
            //         pToS.put(pChar[i], sArr[i]);
            //     } else {
            //         return false;
            //     }
            // } else if (!pToS.get(pChar[i]).equals(sArr[i])) {
            //     return false;
            // }
        }
        return true;
    }
}
