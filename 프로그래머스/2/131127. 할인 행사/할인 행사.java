import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            if (wantMap.containsKey(discount[i])) {
                wantMap.put(discount[i], wantMap.get(discount[i]) - 1);
            }
        }
        
        int start = 0; int end = start + 10;
        while (end < discount.length) {
            boolean flag = true;
            for (String name : want) {
                if (wantMap.get(name) > 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer++;
            }
            if (wantMap.containsKey(discount[start])) {
                wantMap.put(discount[start], wantMap.get(discount[start]) + 1);
            }
            if (wantMap.containsKey(discount[end])) {
                wantMap.put(discount[end], wantMap.get(discount[end]) - 1);
            }
            start++; end++;
        }
        
        boolean flag = true;
        for (String name : want) {
            if (wantMap.get(name) > 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            answer++;
        }
        
        return answer;
    }
}