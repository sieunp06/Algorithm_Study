class Solution {
    public int solution(int n) {
        int target = countNumOne(Integer.toBinaryString(n));
        int num = n + 1;
        while (true) {
            int count = countNumOne(Integer.toBinaryString(num));
            if (count == target) {
                return num;
            }
            num++;
        }
    }
    
    private int countNumOne(String num) {
        int count = 0;
        for (char each : num.toCharArray()) {
            if (each == '1') {
                count++;
            }
        }
        return count;
    }
}