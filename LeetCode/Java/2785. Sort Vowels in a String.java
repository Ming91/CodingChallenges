// Biweekly Contest 109
class Solution {
    public String sortVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        List<Character> vowels = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels.add(c);
                ch[i] = '-';
            }
        }
        int idx = 0;
        Collections.sort(vowels);
        // for (char c : vowels) {
        //     System.out.println(c);
        // }
        // for (char c : ch) {
        //     System.out.println(c);
        // }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '-') {
                ch[i] = vowels.get(idx++);
            }
        }
        return new String(ch);
    }
}
class Solution {
    public String sortVowels(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        List<Character> vowels = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels.add(c);
                ch[i] = '-';
            }
        }
        int idx = 0;
        Collections.sort(vowels);
        // for (char c : vowels) {
        //     System.out.println(c);
        // }
        // for (char c : ch) {
        //     System.out.println(c);
        // }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '-') {
                ch[i] = vowels.get(idx++);
            }
        }
        return new String(ch);
    }
}
// you cant modify the iterated elements,
// so for(c:ch) {c = '-'} not working
