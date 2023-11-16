import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> strLengths = new HashMap<>();
        
        for (String str : strArr) {
            strLengths.put(str.length(), strLengths.getOrDefault(str.length(), 0) + 1);
        }
        
        int answer = 0;
        for (int num : strLengths.values()) {
            if (answer < num) {
                answer = num;
            }
        }
        
        return answer;
    }
}