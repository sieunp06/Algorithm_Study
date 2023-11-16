import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {        
        List<Integer> indexs = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                indexs.add(i);
            }
        }   
        
        if (indexs.isEmpty()) {
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[indexs.get(indexs.size() - 1) - indexs.get(0) + 1];
        
        for (int i = indexs.get(0); i <= indexs.get(indexs.size() - 1); i++) {
            answer[i - indexs.get(0)] = arr[i];
        }
        
        return answer;
    }
}