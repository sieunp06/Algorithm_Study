class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String num1 = String.valueOf(a) + String.valueOf(b);
        String num2 = String.valueOf(b) + String.valueOf(a);
        
        if (Integer.parseInt(num1) > Integer.parseInt(num2))
            return Integer.parseInt(num1);
        return Integer.parseInt(num2);
    }
}