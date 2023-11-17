import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> solution(String[] picture, int k) {
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < picture.length; i++) {
            String zoom = "";
            
            for (int j = 0; j < picture[i].length(); j++) {
                for (int z = 0; z < k; z++) {
                    zoom += picture[i].charAt(j);
                }
            }
            
            for (int m = 0; m < k; m++) {
                answer.add(zoom);   
            }
        }
        
        return answer;
    }
}