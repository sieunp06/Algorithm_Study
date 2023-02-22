import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = "";
        
        ArrayList<Character> arr = new ArrayList<>();
        
        for (int i = 0; i < s; i++) 
            answer += my_string.charAt(i);
        for (int i = s; i <= e; i++)
            arr.add(my_string.charAt(i));  

        for (int i = arr.size() - 1; i >= 0; i--) 
            answer += arr.get(i);

        for (int i = e + 1; i < my_string.length(); i++)
            answer += my_string.charAt(i);
        
        return answer;
    }
}