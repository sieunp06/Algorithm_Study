import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for (String text : keymap) {
            char[] alpha = text.toCharArray();
            for (int i = 0; i < alpha.length; i++) {
                if (!map.containsKey(alpha[i])) {
                    map.put(alpha[i], i);
                } else {
                    if (map.get(alpha[i]) > i) {
                        map.put(alpha[i], i);
                    }
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            for (char al : targets[i].toCharArray()) {
                if (!map.containsKey(al)) {
                    answer[i] = -1;
                    break;
                }
                answer[i] += map.get(al) + 1;
            }
        }
        
        return answer;
    }
}