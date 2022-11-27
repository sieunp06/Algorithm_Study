import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        ArrayList<Integer> answer_arrayList = new ArrayList<>();
        
        if (isEven(n)) answer = new int[n / 2];
        else answer = new int[n / 2 + 1];
        
        for (int i = 1; i <= n; i++) {
            if (!isEven(i)) answer_arrayList.add(i);
        }
        for (int i = 0; i < answer_arrayList.size(); i++) {
            answer[i] = answer_arrayList.get(i);
        }
        return answer;
    }
    
    private boolean isEven(int num) {
        if (num % 2 == 0) return true;
        return false;
    }
}