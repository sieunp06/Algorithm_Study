import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        
        for (String key: keymap) {
            for (char alphabet: key.toCharArray()) {
                if (!map.containsKey(alphabet)) {
                    map.put(alphabet, key.indexOf(alphabet));
                } else {
                    int idx = map.get(alphabet);
                    if (key.indexOf(alphabet) < idx) {
                        map.put(alphabet, key.indexOf(alphabet));
                    }
                }
            }
        }
        
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            for (char alphabet: target.toCharArray()) {
                if (map.containsKey(alphabet)) {
                    answer[i] += map.get(alphabet) + 1;
                } else {
                    answer[i] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}