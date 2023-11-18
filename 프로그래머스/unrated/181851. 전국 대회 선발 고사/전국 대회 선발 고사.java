import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        
        Map<Integer, Integer> list = new HashMap<>();
        
        for (int i = 0; i < rank.length; i++) {
            if (attendance[i]) {
                list.put(rank[i], i);
            }
        }
        
        List<Integer> keySet = new ArrayList<>(list.keySet());
        Collections.sort(keySet);
        
        answer = 10000 * list.get(keySet.get(0)) + 100 * list.get(keySet.get(1)) + list.get(keySet.get(2));
        
        return answer;
    }
}