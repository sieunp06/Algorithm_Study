import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        int total = 0;
        
        for (int key : keySet) {
            total += map.get(key);
            answer++;
            if (total >= k) {
                break;
            }
        }
        
        return answer;
    }
}