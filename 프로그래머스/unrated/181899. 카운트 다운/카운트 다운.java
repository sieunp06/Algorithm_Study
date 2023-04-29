import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int start, int end) {
        List<Integer> arr = new ArrayList<>();
        int[] answer = new int[start - end + 1];
        
        for (int i = start; i >= end; i--)
            arr.add(i);
        
        for (int i = 0; i < arr.size(); i++)
            answer[i] = arr.get(i);
        
        return answer;
    }
}