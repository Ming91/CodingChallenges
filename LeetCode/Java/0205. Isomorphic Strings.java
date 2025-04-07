// Top Interview 150 Hashmap Q2
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] smap = new int[256];
        int[] tmap = new int[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // char sc = s.charAt(i);
            // char tc = t.charAt(i);
            if (smap[sc[i]] == 0 && tmap[tc[i]] == 0) {
                smap[sc[i]] = tc[i];
                tmap[tc[i]] = 1;
                // smap[sc] = Integer.valueOf(tc);
                // tmap[tc] = Integer.valueOf(sc);
            } else if (smap[sc[i]] != tc[i]) {
                return false;
            }
            // } else if (tmap[tc] == null || tmap[tc] != sc 
            //         || smap[sc] == null || smap[sc] != tc) {
            //     return false;
            // }
        }
        return true;
    }
}
// totally no idea
// [Editorial] just map each char in s to corresponding char in t
// return false if found conflict.
