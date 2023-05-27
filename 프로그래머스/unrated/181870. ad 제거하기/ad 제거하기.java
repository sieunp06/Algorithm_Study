import java.util.ArrayList;

class Solution {
    public ArrayList<String> solution(String[] strArr) {
        ArrayList<String> answer = new ArrayList<>();
        
        for (String text : strArr) {
            if (!text.contains("ad"))
                answer.add(text);
        }
        
        return answer;
    }
}