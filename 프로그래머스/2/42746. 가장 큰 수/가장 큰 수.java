import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(num, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));
        
        if (num[0].equals("0")) {
            return "0";
        }
        return String.join("", num);
    }
}