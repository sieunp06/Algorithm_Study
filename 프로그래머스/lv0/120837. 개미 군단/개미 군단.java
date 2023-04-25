class Solution {
    private final int GENERAL_ANT = 5;
    private final int SOLDIER_ANT = 3;
    private final int WORK_ANT = 1;
    
    public int solution(int hp) {
        int answer = 0;
        
        answer += hp / GENERAL_ANT;
        hp %= GENERAL_ANT;
        
        answer += hp / SOLDIER_ANT;
        hp %= SOLDIER_ANT;
        
        answer += hp;
        
        return answer;
    }
}