// Weekly Contest 357 Q1 
class Solution {
    public String finalString(String s) {
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == 'i') {
                sb.reverse();
                continue;
            }
            sb.append(c);
        }    
        return sb.toString();
    }
}
