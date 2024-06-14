import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(String s) {
        List<String> numbers = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        
        for (int i = 0; i < numbers.size(); i++) {
            s = s.replaceAll(numbers.get(i), String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}