import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        
        for (String alpha : arr) answer += alpha;
        return answer;
    }
}