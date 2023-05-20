import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int[] num_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Arrays.sort(num_list);
        for (int i = 5; i < num_list.length; i++) {
            answer.add(num_list[i]);
        }
        
        return answer;
    }
}