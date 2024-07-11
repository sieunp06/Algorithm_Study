import java.util.ArrayList;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) 
                numbers.add(i);
        }
        
        int max = Integer.MIN_VALUE;
        
        for (int num : numbers) {
            if (m % num == 0 && num > max) 
                answer[0] = num;
        }
        
        answer[1] = n * m / answer[0];
        
        return answer;
    }
}