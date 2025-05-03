import java.util.*;

class Solution {
    Map<Integer, Integer> one = new HashMap<>();
    Map<Integer, Integer> two = new HashMap<>();
    
    public int solution(int[] topping) {
        int answer = 0;
        
        one.put(topping[0], one.getOrDefault(topping[0], 0) + 1);
        for (int i = 1; i < topping.length; i++) {
            two.put(topping[i], two.getOrDefault(topping[i], 0) + 1);
        }
        
        int idx = 1;
        while (idx < topping.length) {
            one.put(topping[idx], one.getOrDefault(topping[idx], 0) + 1);
            two.put(topping[idx], two.get(topping[idx]) - 1);
            if (two.get(topping[idx]) == 0) {
                two.remove(topping[idx]);
            }
            
            if (isSame()) {
                answer++;
            }
            idx++;
        }
        
        return answer;
    }
    
    private boolean isSame() {
        return one.size() == two.size();
    }
}