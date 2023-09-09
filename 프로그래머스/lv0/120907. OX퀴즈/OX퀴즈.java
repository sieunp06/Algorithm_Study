import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    public ArrayList<String> solution(String[] quiz) {
        ArrayList<String> answer = new ArrayList<>();
        StringTokenizer st;
        
        for (String text : quiz) {
            st = new StringTokenizer(text);
            int num1 = Integer.parseInt(st.nextToken());
            String operator = st.nextToken();
            int num2 = Integer.parseInt(st.nextToken());
            st.nextToken();
            int result = Integer.parseInt(st.nextToken());
            int compare = Integer.MIN_VALUE;
            
            if (operator.equals("+")) {
                compare = calculatePlus(num1, num2);
            } else if (operator.equals("-")) {
                compare = calculateMinus(num1, num2);
            }
            
            if (result == compare) answer.add("O");
            else answer.add("X");
        }
        
        
        return answer;
    }
    
    public int calculatePlus(int num1, int num2) {
        return num1 + num2;
    }
    public int calculateMinus(int num1, int num2) {
        return num1 - num2;
    }
}