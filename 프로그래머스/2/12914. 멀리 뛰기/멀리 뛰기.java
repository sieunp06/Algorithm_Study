class Solution {
    public long solution(int n) {
        long[] distance = new long[2001];
        distance[1] = 1; distance[2] = 2;
        for (int i = 3; i <= n; i++) {
            distance[i] = (distance[i - 2] + distance[i - 1]) % 1234567;
        }
        return distance[n];
    }
}