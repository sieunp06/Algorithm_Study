import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<String> solution(String myString) {
        ArrayList<String> answer = new ArrayList<>();
        
        for (String text : myString.split("x")) {
            if (!text.equals("")) {
                answer.add(text);
            }
        }
        
        Collections.sort(answer);
        
        return answer;
    }
}