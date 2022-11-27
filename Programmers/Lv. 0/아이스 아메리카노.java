class Solution {
    private final int ICED_AMERICANO = 5500;
    public int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money / ICED_AMERICANO;
        answer[1] = money % ICED_AMERICANO;
        return answer;
    }
}