import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> cache = new LinkedList<>();
        
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for (String city : cities) {
            String target = city.toLowerCase();
            if (cache.size() < cacheSize) {
                if (cache.contains(target)) {
                    answer += 1;
                    cache.remove(target);
                    cache.add(target);
                } else {
                    cache.add(target);
                    answer += 5;   
                }
            } else {
                if (cache.contains(target)) {
                    answer += 1;
                    cache.remove(target);
                    cache.add(target);
                } else {
                    answer += 5;
                    cache.pollFirst();
                    cache.add(target);
                }
            }
        }
        
        return answer;
    }
}