import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] scores = new int[3];
        
        int chance = -1;
        String score = "";
        for (char alphabet: dartResult.toCharArray()) {
            if (Character.isDigit(alphabet)) {
                score += alphabet;
                continue;
            }
            if (alphabet == 'S') {
                chance++;
                scores[chance] = Integer.parseInt(score);
                score = "";
            }
            if (alphabet == 'D') {
                chance++;
                scores[chance] = Integer.parseInt(score);
                score = "";
                scores[chance] = (int) Math.pow(scores[chance], 2);
                continue;
            }
            if (alphabet == 'T') {
                chance++;
                scores[chance] = Integer.parseInt(score);
                score = "";
                scores[chance] = (int) Math.pow(scores[chance], 3);
                continue;
            }
            if (alphabet == '*') {
                scores[chance] = 2 * scores[chance];
                if (chance > 0) {
                    scores[chance - 1] = 2 * scores[chance - 1];
                }
            }
            if (alphabet == '#') {
                scores[chance] = -1 * scores[chance];
            }
        }
        
        for (int s: scores) {
            answer += s;
        }
        
        return answer;
    }
}