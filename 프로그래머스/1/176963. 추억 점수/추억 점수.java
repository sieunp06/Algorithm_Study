import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> answer = new ArrayList<>();
        
        for (String[] person : photo) {
            List<String> texts = new ArrayList<>();
            for (int i = 0; i < person.length; i++) {
                texts.add(person[i]);
            }
            int score = 0;
            for (int i = 0; i < name.length; i++) {
                if (texts.contains(name[i])) {
                    score += yearning[i];
                }
            }
            answer.add(score);
        }
        
        return answer;
    }
}