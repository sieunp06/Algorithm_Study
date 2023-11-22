import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> answer = set.stream().sorted().collect(Collectors.toList());
        
        return answer;
    }
}