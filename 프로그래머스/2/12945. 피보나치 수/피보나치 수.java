import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        List<Integer> num = new ArrayList<>();
        num.add(0);
        num.add(1);
        
        for (int i = 2; i <= n; i++) {
            num.add((num.get(i - 2) + num.get(i - 1)) % 1234567); 
        }
        
        return num.get(n);
    }
}