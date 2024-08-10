class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int duration = 0;
        int userHealth = health;
        
        for (int[] attack : attacks) {
            duration += attack[0] - time - 1;
            time = attack[0];
            userHealth += duration * bandage[1];
            while (duration >= bandage[0]) {
                userHealth += bandage[2];
                duration -= bandage[0];
            }
            if (userHealth > health) {
                userHealth = health;
            }
            
            userHealth -= attack[1];
            duration = 0;
            
            if (userHealth <= 0) {
                return -1;
            }
        }
        return userHealth;
    }
}