import java.util.ArrayList;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        boolean[] have = new boolean[10];
        
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
            have[numbers[i]] = true;
        }

        for (int i = 0; i < have.length; i++) {
            System.out.println(have[i]);
            if (!have[i])
                answer += i;
        }
        
        return answer;
    }
}