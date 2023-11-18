import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1); map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1); map.put(d, map.getOrDefault(d, 0) + 1);
        
        if (map.size() == 1) {
            answer = 1111 * a;
        } else if (map.size() == 2 && (map.get(a) == 3 || map.get(a) == 1)) {
            int p = 0; int q = 0;
            for (int key : map.keySet()) {
                if (map.get(key) == 3) {
                    p = key;
                } else {
                    q = key;
                }
            }
            answer = (int)Math.pow(10 * p + q, 2);
        } else if (map.size() == 2) {
            int[] num = new int[2];
            int i = 0;
            for (int key : map.keySet()) {
                if (map.get(key) == 2) {
                    num[i] = key;
                    i++;
                } 
            }
            answer = (num[0] + num[1]) * (Math.abs(num[0] - num[1]));
        } else if (map.size() == 4) {
            int min = Integer.MAX_VALUE;
            for (int key : map.keySet()) {
                if (min > key) {
                    min = key;
                }
            }
            answer = min;
        } else {
            int[] num = new int[2];
            int i = 0;
            for (int key : map.keySet()) {
                if (map.get(key) == 1) {
                    num[i] = key;
                    i++;
                } 
            }
            answer = num[0] * num[1];
        }
        
        return answer;
    }
}