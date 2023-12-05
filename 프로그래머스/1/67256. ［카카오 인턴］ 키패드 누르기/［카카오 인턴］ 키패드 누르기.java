class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] leftHand = {3, 0};
        int[] rightHand = {3, 2};
        
        for (int number : numbers) {
            int x = number % 3;
            if (x == 1) {
                answer += "L";
                leftHand[0] = number / 3;
                leftHand[1] = 0;
            } else if (x == 0 && number != 0) {
                answer += "R";
                rightHand[0] = number / 3 - 1;
                rightHand[1] = 2;
            } else {
                int y = number / 3;   
                if (number == 0) {
                    y = 3;
                }
                int leftD = Math.abs(leftHand[0] - y) + Math.abs(leftHand[1] - 1);
                int rightD = Math.abs(rightHand[0] - y) + Math.abs(rightHand[1] - 1);
                
                if (leftD > rightD) {
                    answer += "R";
                    rightHand[0] = y;
                    rightHand[1] = 1;
                } else if (leftD == rightD) {
                    if (hand.equals("right")) {
                        answer += "R";
                        rightHand[0] = y;
                        rightHand[1] = 1;
                    } else {
                        answer += "L";
                        leftHand[0] = y;
                        leftHand[1] = 1;
                    }
                } else {
                    answer += "L";
                    leftHand[0] = y;
                    leftHand[1] = 1;
                }
            }
        }
        
        return answer;
    }
}