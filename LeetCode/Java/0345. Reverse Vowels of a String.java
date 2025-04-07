class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowelDict = Set.of('a', 'e', 'i', 'o', 'u',
                                          'A', 'E', 'I', 'O', 'U');
        char[] vowelList = new char[s.length()];
        StringBuilder result = new StringBuilder();
        int vowelListLen = 0;
        int vowelListIdx = 0;
        for (char c : s.toCharArray()) {
            if (vowelDict.contains(c)) {
                vowelList[vowelListLen] = c;
                vowelListLen++;
            }
        }
        for (char c : s.toCharArray()) {
            if (vowelDict.contains(c)) {
                result.append(vowelList[vowelListLen - 1 - vowelListIdx]);
                vowelListIdx++;
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
// use two pointers is better
