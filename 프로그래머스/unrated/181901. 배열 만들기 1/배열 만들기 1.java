import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int n, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (i % k == 0) answer.add(i);
        }
        
        return answer;
    }
}