class Solution {
    private final int LAMB_SKEWERS = 12000;
    private final int DRINK = 2000;
    
    public int solution(int n, int k) {
        int answer = 0;
        answer = LAMB_SKEWERS * n + DRINK * k - isService(n);
        return answer;
    }
    
    private int isService(int n) {
        int service = n / 10;
        return service * DRINK;
    }
}