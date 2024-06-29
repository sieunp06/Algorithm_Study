import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> answer = Arrays.stream(arr)
            .boxed().collect(Collectors.toList());
        
        int min = answer.get(0);
        int ind = 0;
        
        for (int i = 1; i < answer.size(); i++) {
            if (answer.get(i) < min) {
                min = answer.get(i);
                ind = i;
            }
        }
        
        answer.remove(ind);
        
        if (answer.isEmpty()) answer.add(-1);
        
        return answer;
    }
}