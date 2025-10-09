import java.util.StringTokenizer;

class Solution {    
    public String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(s);
    
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        while (stringTokenizer.hasMoreTokens()) {
            int target = Integer.parseInt(stringTokenizer.nextToken());
            if (max < target) {
                max = target;
            }
            if (min > target) {
                min = target;
            }
        }
        
        return stringBuilder.append(min).append(" ").append(max).toString();
    }
}