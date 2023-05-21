import java.util.ArrayList;

class Solution {
    public ArrayList<String> solution(String my_string) {
        ArrayList<String> answer = new ArrayList<>();
        
        String[] gg = my_string.split(" ");
        
        for (String text : gg) {
            if (!text.isEmpty()) answer.add(text);
        }
        
        return answer;
    }
}