class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        int max_x = (board[0] - 1) / 2;
        int max_y = (board[1] - 1) / 2;

        for (String text : keyinput) {
            if (text.equals("left")) {
                if (x > max_x * -1) {
                    x -= 1;
                }
            } else if (text.equals("right")) {
                if (x < max_x) {
                    x += 1;
                }
            } else if (text.equals("up")) {
                if (y < max_y) {
                    y += 1;
                }
            } else if (text.equals("down")) {
                if (y > max_y * -1) {
                    y -= 1;
                }
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        
        return answer;
    }
}