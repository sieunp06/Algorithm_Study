class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[] query : queries) {
            String first = my_string.substring(0, query[0]);
            String target = my_string.substring(query[0], query[1] + 1);
            String second = my_string.substring(query[1] + 1, my_string.length());
            
            for (int i = target.length() - 1; i >= 0; i--) {
                first += target.charAt(i);
            }
            my_string = first + second;
        }
        
        return my_string;
    }
}