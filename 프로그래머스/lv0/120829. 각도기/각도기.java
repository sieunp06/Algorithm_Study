class Solution {
    private final int ACUTE_ANGLE = 1;
    private final int RIGHT_ANGLE = 2;
    private final int OBTISE_ANGLE = 3;
    private final int FLAT_ANGLE = 4;
    
    public int solution(int angle) {
        int answer = 0;
        answer = calculateAngle(angle);
        return answer;
    }
    
    private int calculateAngle(int angle) {
        if (0 < angle && angle < 90)
            return ACUTE_ANGLE;
        if (angle == 90)
            return RIGHT_ANGLE;
        if (90 < angle && angle < 180) 
            return OBTISE_ANGLE;
        return FLAT_ANGLE;
    }
}