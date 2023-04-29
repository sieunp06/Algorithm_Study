class Solution {
    public int solution(int a, int b) {
        if (a % 2 == 0 && b % 2 == 0) return (int)Math.abs(a - b);
        else if (a % 2 != 0 && b % 2 != 0) return (int)Math.pow(a, 2) + (int)Math.pow(b, 2);
        return 2 * (a + b);
    }
}