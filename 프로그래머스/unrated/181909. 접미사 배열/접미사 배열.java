import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<String> solution(String my_string) {
        ArrayList<String> answer = new ArrayList<>();
        
        for (int i = 0; i < my_string.length(); i++) {
            answer.add(my_string.substring(my_string.length() - 1 - i, my_string.length()));
        }
        
        Collections.sort(answer);
        
        return answer;
    }
}