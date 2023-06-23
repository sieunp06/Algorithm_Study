import java.util.Arrays;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        
        Arrays.sort(indices);
        int ind = 0;
        
        for (int i = 0; i < my_string.length(); i++) {
            if (ind >= indices.length) {
                answer += my_string.substring(i, my_string.length());
                break;
            }
            
            if (i == indices[ind]) {
                ind++;
            } else {
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}