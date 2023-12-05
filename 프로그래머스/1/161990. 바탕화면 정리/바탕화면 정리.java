class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int min_x = Integer.MAX_VALUE; int max_x = Integer.MIN_VALUE;
        int min_y = Integer.MAX_VALUE; int max_y = Integer.MIN_VALUE;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (min_x > j) {
                        min_x = j;
                    }
                    if (min_y > i) {
                        min_y = i;
                    }
                    if (max_x < j) {
                        max_x = j;
                    }
                    if (max_y < i) {
                        max_y = i;
                    }
                }
            }
        }
        
        answer[0] = min_y; answer[1] = min_x;
        answer[2] = max_y + 1; answer[3] = max_x + 1;
        
        return answer;
    }
}