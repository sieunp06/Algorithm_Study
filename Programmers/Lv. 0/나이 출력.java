class Solution {
    final int YEAR = 2022;
    public int solution(int age) {
        int answer = 0;
        answer = calculateAge(age);
        return answer;
    }
    
    private int calculateAge(int age) {
        return YEAR - age + 1;
    }
}