class Solution {
    private Map<Character, Integer> genCountMap(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            int current = counts.getOrDefault(c, 0);
            counts.put(c, current + 1);
        }
        return counts;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> magCount = genCountMap(magazine);

        for (char c : ransomNote.toCharArray()) {
            int count = magCount.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            } else {
                magCount.put(c, count - 1);
            }
        }
        
        return true;
    }
}
