import java.util.Queue;
import java.util.LinkedList;

class Solution {
    private final int CACHE_HIT = 1;
    private final int CACHE_MISS = 5;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        
        if (cacheSize == 0) {
            return cities.length * CACHE_MISS;
        }
        
        for (String city: cities) {
            String name = city.toLowerCase();
            if (queue.size() < cacheSize) {
                if (queue.contains(name)) {
                    queue.remove(name);
                    queue.add(name);
                    answer += CACHE_HIT;
                } else {
                    queue.add(name);
                    answer += CACHE_MISS;   
                }
                continue;
            }
            if (queue.contains(name)) {
                answer += CACHE_HIT;
                queue.remove(name);
            } else {
                answer += CACHE_MISS;
                queue.poll();
            }
            queue.add(name);
        }
        
        return answer;
    }
}