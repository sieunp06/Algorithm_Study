class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String text = "";
            String map1 = Integer.toBinaryString(arr1[i]);
            String map2 = Integer.toBinaryString(arr2[i]);
            
            while (map1.length() < n) {
                map1 = "0" + map1;
            }
            while (map2.length() < n) {
                map2 = "0" + map2;
            }
            
            for (int j = 0; j < n; j++) {
                if (map1.charAt(j) == '1' || map2.charAt(j) == '1') {
                    text += "#";
                } else if (map1.charAt(j) == '0' && map2.charAt(j) == '0') {
                    text += " ";
                }
            }
            answer[i] = text;
        }
        
        return answer;
    }
}