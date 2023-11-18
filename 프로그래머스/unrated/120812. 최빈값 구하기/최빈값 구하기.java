import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int max = 0;
        for (int num : map.keySet()) {
            if (map.get(num) > max) {
                answer = num;
                max = map.get(num);
            }
        }
        
        int number = 0;
        for (int num : map.values()) {
            if (num == max) {
                number++;
            }
        }
        
        if (number > 1) {
            return -1;
        }
        return answer;
    }
}