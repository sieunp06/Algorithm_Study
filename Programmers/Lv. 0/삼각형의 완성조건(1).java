import java.util.*;
class Solution {
    private final int SUCCESS = 1;
    private final int FAILURE = 2;
    
    public int solution(int[] sides) {
        int answer = 0;
        sortArray(sides);
        answer = canMakeTriangle(sides);
        return answer;
    }
    
    private int canMakeTriangle(int[] sides) {
        int max = sides[2];
        
        if (max >= sides[0] + sides[1])
            return FAILURE;
        return SUCCESS;
    }
    
    private void sortArray(int[] arrays) {
        Arrays.sort(arrays);
    }
}