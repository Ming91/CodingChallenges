// Weekly Contest 355
class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        String sep = String.valueOf(separator);
        if (separator < 'A' || separator > 'z') {
            sep = "\\" + sep;
        }
        for (String word : words) {
            //System.out.println(word);
            String[] segWords = word.split(sep);
            // String[] segWords = word.split("[" + sep + "]");
            for (String segWord : segWords) {
                //System.out.println(segWord);
                if (!segWord.isEmpty()) {
                    ans.add(segWord);
                }                
            }
        }
        return ans;
    }
}
// 本质是java string的split使用reg作为输入，要么加"\\"转义, 
// 加"\\"其实是加"\", 第一个\表示第二个\并非特殊, 无法用"\" + sep, 因为这里 \" 视为加一个 " ,
// 要么前后加[]
