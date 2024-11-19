import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        
        while (stringTokenizer.hasMoreTokens()) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        return min + " " + max;
    }
}