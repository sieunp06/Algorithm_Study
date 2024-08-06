class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        for (int i = 0; i < wallpaper.length; i++) {
            String wall = wallpaper[i];
            for (int j = 0; j < wall.length(); j++) {
                if (wall.charAt(j) == '#') {
                    int y = i; int x = j;
                    if (y <= answer[0]) answer[0] = y;
                    if (x <= answer[1]) answer[1] = x;
                    if (y >= answer[2]) answer[2] = y + 1;
                    if (x >= answer[3]) answer[3] = x + 1;
                }
            }
        }
        
        return answer;
    }
}