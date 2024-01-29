import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        int start = 0; int end = start + 9;
        
        for (int i = start; i <= end; i++) {
            if (map.containsKey(discount[i])) {
                map.put(discount[i], map.get(discount[i]) - 1);   
            }
        }
        
        while (end < discount.length - 1) {
            boolean flag = true;
            for (String text : want) {
                if (map.get(text) > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
            if (map.containsKey(discount[start])) {
                map.put(discount[start], map.get(discount[start]) + 1);
            }
            start++; end++;
            if (map.containsKey(discount[end])) {
                map.put(discount[end], map.get(discount[end]) - 1);
            }
        }
        
        boolean flag2 = true;
        for (String text : want) {
            if (map.get(text) > 0) {
                flag2 = false;
                break;
            }
        }
        if (flag2) {
            answer++;
        }
        
        return answer;
    }
}