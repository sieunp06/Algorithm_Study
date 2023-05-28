import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        char[] alphas = my_string.toLowerCase().toCharArray();
        Arrays.sort(alphas);
        
        for (char alpha : alphas) {
            answer += alpha;
        }
        
        return answer;
    }
}