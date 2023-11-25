import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        double[] challenges = new double[N + 2];
        double[] passed = new double[N + 1];
        
        Map<Integer, Double> map = new HashMap<>();
        
        for (int stage : stages) {
            passed[stage - 1]++;
        }
        
        for (int i = passed.length - 2; i >= -1; i--) {
            challenges[i + 1] = challenges[i + 2] + passed[i + 1];
        }
        
        for (int i = 1; i <= N; i++) {
            if (challenges[i - 1] == 0.0) {
                map.put(i, 0.0);
            } else {
                map.put(i, passed[i - 1] / challenges[i - 1]);   
            }
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        return keySet;
    }
}