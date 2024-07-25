import java.util.List;
import java.util.stream.*;
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        List<Integer> list = Arrays.stream(s.split(" "))
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());
        
        answer.append(list.get(0)).append(" ").append(list.get(list.size() - 1));
        
        return answer.toString();
    }
}