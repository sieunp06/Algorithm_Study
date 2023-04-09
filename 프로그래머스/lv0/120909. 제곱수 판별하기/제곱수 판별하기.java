import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        Double x = Math.sqrt(n);
        if (x == x.intValue()) answer = 1;
        else answer = 2;
        return answer;
    }
}