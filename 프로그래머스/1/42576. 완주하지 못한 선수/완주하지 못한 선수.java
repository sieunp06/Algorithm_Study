import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String runner: participant) {
            map.put(runner, map.getOrDefault(runner, 0) + 1);
        }
        
        for (String completedRunner: completion) {
            map.put(completedRunner, map.get(completedRunner) - 1);
        }
        
        for (String runner: map.keySet()) {
            if (map.get(runner) > 0) {
                return runner;
            }
        }
        
        return answer;
    }
}