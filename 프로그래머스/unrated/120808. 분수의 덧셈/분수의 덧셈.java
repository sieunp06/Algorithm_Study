import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        int result_numer = numer1 * denom2 + numer2 * denom1;
        int result_denom = denom1 * denom2;
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 2; i <= result_numer; i++) {
            while (result_numer % i == 0) {
                result_numer /= i;
                list.add(i);
            }   
        }
        
        for (int num : list) {
            if (result_denom % num == 0) {
                result_denom /= num;
            } else {
                result_numer *= num;
            }
        }
        
        answer[0] = result_numer;
        answer[1] = result_denom;
        
        return answer;
    }
}