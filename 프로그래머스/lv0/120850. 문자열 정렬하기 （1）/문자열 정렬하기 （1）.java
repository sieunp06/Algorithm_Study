import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ArrayList<Integer> solution(String my_string) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (char alpha : my_string.toCharArray()) {
            if (Character.isDigit(alpha)) 
                answer.add(alpha - '0');
        }
        
        Collections.sort(answer);
        
        return answer;
    }
}