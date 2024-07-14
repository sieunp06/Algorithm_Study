import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> score = new ArrayList<>();
        Map<String, Integer> yearningMap = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            yearningMap.put(name[i], yearning[i]);
        }
        
        for (String[] ph: photo) {
            int total = 0;
            for (String na: ph) {
                if (yearningMap.containsKey(na)) {
                    total += yearningMap.get(na);
                }
            }
            score.add(total);
        }
        
        int[] answer = new int[score.size()];
        
        for (int i = 0; i < score.size(); i++) {
            answer[i] = score.get(i);
        }
        
        return answer;
    }
}