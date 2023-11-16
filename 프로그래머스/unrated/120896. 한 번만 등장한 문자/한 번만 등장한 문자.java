import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        SortedMap<Character, Integer> map = new TreeMap<>();
        
        for (char alpha : s.toCharArray()) {
            map.put(alpha, map.getOrDefault(alpha, 0) + 1);
        }
        
        for (char alpha : map.keySet()) {
            if (map.get(alpha) == 1) {
                answer += alpha;
            }
        }
        
        return answer;
    }
}