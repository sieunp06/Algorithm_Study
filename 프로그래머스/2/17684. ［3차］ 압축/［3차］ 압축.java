import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> dic = new ArrayList<>();
        String[] dicAlpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
                    "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        
        for (int i = 0; i < dicAlpha.length; i++) {
            dic.add(dicAlpha[i]);
        }
        
        int start = 0; int end = start + 1;;
        int tmp = -1;
        
        while (start < msg.length()) {
            String text = msg.substring(start, end);
            if (dic.contains(text)) {
                tmp = dic.indexOf(text) + 1;
                if (end < msg.length()) {
                    end++;
                } else {
                    answer.add(tmp);
                    start = end;
                }
            } else {
                dic.add(text);
                answer.add(tmp);
                start = end - 1;
                
            }
        }
        
        return answer;
    }
}