import java.util.Arrays;
import java.util.stream.*;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] arr, int divisor) {
        List<Integer> answer = Arrays.stream(arr)
            .filter(num -> num % divisor == 0)
            .boxed()
            .sorted()
            .collect(Collectors.toList());
        if (answer.isEmpty()) {
            answer.add(-1);
        }
        return answer;
    }
}