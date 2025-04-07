// Top Interview 150 Hashmap Q1
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length(), n = magazine.length();
        if (m > n) {
            return false;
        }
        int[] count = new int[26];

        // [Beat 99%]
        // for (char c : ransomNote.toCharArray()) {
        //     count[c - 'a'] = magazine.indexOf(c, count[c - 'a']);
        //     if (count[c - 'a'] < 0) {
        //         return false;
        //     }
        //     count[c - 'a']++;
        // }
        // return true;

        // [Improved] iterate over ransomNote rather than magazine
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            if (count[c - 'a'] <= 0) {
                continue;
            }
            count[c - 'a']--;
            m--;
            if (m == 0) {
                return true;
            }
        }
        return false;

        // [Ming] 
        // for (char c : magazine.toCharArray()) {
            // count[c - 'a']++;
        // }
        // for (char c : ransomNote.toCharArray()) {
        //     count[c - 'a']--;
        //     if (count[c - 'a'] < 0) {
        //         return false;
        //     }
        // }
        // return true;
    }
}
// class Solution {
//     private Map<Character, Integer> genCountMap(String s) {
//         Map<Character, Integer> counts = new HashMap<>();
//         for (char c : s.toCharArray()) {
//             int current = counts.getOrDefault(c, 0);
//             counts.put(c, current + 1);
//         }
//         return counts;
//     }
//     public boolean canConstruct(String ransomNote, String magazine) {
//         if (ransomNote.length() > magazine.length()) {
//             return false;
//         }

//         Map<Character, Integer> magCount = genCountMap(magazine);

//         for (char c : ransomNote.toCharArray()) {
//             int count = magCount.getOrDefault(c, 0);
//             if (count == 0) {
//                 return false;
//             } else {
//                 magCount.put(c, count - 1);
//             }
//         }
        
//         return true;
//     }
// }
