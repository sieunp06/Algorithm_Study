import java.util.HashMap;
import java.util.Iterator;

class Solution {
    
    HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String[][] clothes) {
        int answer = 1;
        int len = clothes.length;
        
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], 1);
            } else {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }
        
        Iterator<Integer> it = map.values().iterator();
        
        while(it.hasNext()) {
            answer *= it.next().intValue() + 1;
        }
        
        answer --;
        
        return answer;
    }
}