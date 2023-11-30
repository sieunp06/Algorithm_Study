import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        
        for (String route : routes) {
            int y = answer[0]; int x = answer[1];
            StringTokenizer st = new StringTokenizer(route);
            
            String direction = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            int[] direc = new int[2];
            boolean flag = true;
            
            if (direction.equals("E")) {
                direc[1] = x + num;
                if (direc[1] >= park[0].length()) {
                    continue;
                } 
                for (int i = x; i <= direc[1]; i++) {
                    if (park[y].charAt(i) == 'X') {
                        flag = false;
                        break;
                    } 
                }
                if (flag) {
                    x = direc[1];
                }
            } else if (direction.equals("W")) {
                direc[1] = x - num;
                if (direc[1] < 0) {
                    continue;
                }
                for (int i = x; i >= direc[1]; i--) {
                    if (park[y].charAt(i) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    x = direc[1];
                }
            } else if (direction.equals("S")) {
                direc[0] = y + num;
                if (direc[0] >= park.length) {
                    continue;
                }
                for (int i = y; i <= direc[0]; i++) {
                    if (park[i].charAt(x) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    y = direc[0];
                }
            } else {
                direc[0] = y - num;
                if (direc[0] < 0) {
                    continue;
                }
                for (int i = y; i >= direc[0]; i--) {
                    if (park[i].charAt(x) == 'X') {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    y = direc[0];
                }
            }
            answer[0] = y; answer[1] = x;
        }
        
        return answer;
    }
}