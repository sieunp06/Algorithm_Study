import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((t1, t2) -> map.get(t2).compareTo(map.get(t1)));
        
        int answer = 0;
        int total = 0;
        for (int num : list) {
            total += map.get(num);
            answer++;
            if (total >= k) {
                break;
            }
        }
        
        return answer;
    }
}