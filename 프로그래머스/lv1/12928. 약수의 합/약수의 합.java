import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) 
            if (n % i == 0) arr.add(i);
        
        for (int num : arr) answer += num;
        return answer;
    }
}