class Solution {
    public int solution(int n) {
        int[] fibos = new int[100001];
        
        fibos[0] = 0;
        fibos[1] = 1; fibos[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            fibos[i] = (fibos[i - 2] + fibos[i - 1]) % 1234567;
        }

        return fibos[n];
    }
}