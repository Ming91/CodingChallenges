// Top Interview 150 Hashmap Q5
class Solution {
    String getEncode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        return new String(count);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String codedCount = getEncode(s);
            List<String> list = map.computeIfAbsent(codedCount, (key) -> new ArrayList<>());
            list.add(s);
        }
        return new ArrayList<>(map.values());
    }
}
// [Beat 99%] Use char to encode the count array, 'a' for 97 etc..
// Always use this method when need to encode int array to a string for mapping.

// [Ming] Custom List to Use HashMap Properly
// class Solution {
//     private class CountMap {
//         int[] count;
//         public CountMap(String s) {
//             count = new int[26];
//             for (char c : s.toCharArray()) {
//                 count[c - 'a']++;
//             }
//         }
        
//         @Override
//         public int hashCode() {
//             return Arrays.hashCode(count);
//         }

//         @Override
//         public boolean equals(Object obj) {
//             if (obj instanceof CountMap) {
//                 for (int i = 0; i < 26; i++) {
//                     if (count[i] != ((CountMap)obj).count[i]) {
//                         return false;
//                     }
//                 }
//                 return true;
//             }
//             return false;
//         }

//     }
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<CountMap, List<String>> map = new HashMap<>();
//         for (String s : strs) {
//             CountMap cm = new CountMap(s);
//             if (!map.containsKey(cm)) {
//                 map.put(cm, new ArrayList<>());
//             }
//             map.get(cm).add(s);
//         }
//         return new ArrayList<>(map.values());
//     }
// }

// [Ming] converst count[] to string
// [Editorial] Improve structure
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         int n = strs.length;

//         Map<String, List<String>> map = new HashMap<>();
//         for (String s : strs) {
//             int[] count = new int[26];
//             for (char c : s.toCharArray()) {
//                 count[c - 'a']++;
//             }
            
//             var sb = new StringBuilder();
//             for (int j = 0; j < 26; j++) {
//                 sb.append("#").append(count[j]);
//                 // extremely slow
//                 // sb.append(String.format("%03d", count[i][j]));
//             }
//             String countRes = sb.toString();
//             // System.out.println(countRes[i]);

//             if (!map.containsKey(countRes)) {
//                 map.put(countRes, new ArrayList<>());
//             }
//             map.get(countRes).add(s);
//         }
//         return new ArrayList<>(map.values());
//     }
// }
