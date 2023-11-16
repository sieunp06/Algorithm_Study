import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> solution(int n) {
        List<Integer> arr = new ArrayList<>();
        
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                arr.add(i);
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        
        return arr;
    }
}