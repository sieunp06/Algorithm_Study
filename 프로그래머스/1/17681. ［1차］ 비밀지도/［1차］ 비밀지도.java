class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < arr1.length; i++) {
            String map1 = makeMap(Integer.toString(arr1[i], 2), n);
            String map2 = makeMap(Integer.toString(arr2[i], 2), n);
            
            String result = "";
            for (int j = 0; j < n; j++) {
                if (map1.charAt(j) == '1' || map2.charAt(j) == '1') {
                    result += '#';
                } else {
                    result += ' ';
                }
            }
            answer[i] = result;
        }
        
        return answer;
    }
    
    private String makeMap (String text, int n) {
        String result = "";
        for (int i = 0; i < n - text.length(); i++) {
            result += '0';
        }
        return result + text;
    }
}