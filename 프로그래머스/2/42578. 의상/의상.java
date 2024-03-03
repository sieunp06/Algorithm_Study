import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] cloth: clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        
        for (String cloth: map.keySet()) {
            answer *= map.get(cloth) + 1;
        }
        
        return answer - 1;
    }
}