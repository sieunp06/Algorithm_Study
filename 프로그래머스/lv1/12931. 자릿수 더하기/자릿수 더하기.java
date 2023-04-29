import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (char x : String.valueOf(n).toCharArray())
            answer += x - '0';

        return answer;
    }
}