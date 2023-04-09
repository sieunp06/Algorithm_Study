import java.util.*;
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2 - num1 + 1];
        ArrayList<Integer> parseNumbers = new ArrayList<>();
        
        for (int i = num1; i <= num2; i++) {
            parseNumbers.add(numbers[i]);
        }
             
        for (int i = 0; i < answer.length; i++) {
            answer[i] = parseNumbers.get(i);
        }
        return answer;
    }
}