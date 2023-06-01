class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        int num1 = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int num2 = 2 * a * b;
        
        if (num1 >= num2) return num1;   
        return num2;
    }
}