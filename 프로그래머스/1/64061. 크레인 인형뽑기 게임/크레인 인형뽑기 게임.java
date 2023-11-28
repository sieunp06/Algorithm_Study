import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (!st.isEmpty()) {
                        if (st.peek() == board[i][move - 1]) {
                            while (st.peek() == board[i][move - 1]) {
                                st.pop();
                                answer += 2;
                                if (st.isEmpty()) break;
                            }   
                        } else {
                            st.push(board[i][move - 1]);
                        }
                    } else {
                        st.push(board[i][move - 1]);
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        
        return answer;
    }
}