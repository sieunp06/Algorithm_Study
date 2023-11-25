class Solution {
    // n : 구역 개수, m : 롤러의 길이
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] paint = new int[n + 1];
        
        for (int secNum : section) {
            paint[secNum] = 1;
        }
        
        for (int i = 1; i < paint.length; i++) {
            if (paint[i] == 1) {
                if (i + m > n) {
                    for (int j = i; j < paint.length; j++) {
                        paint[j] = 0;
                    }
                    answer++;
                    break;
                } else {
                    for (int j = i; j < i + m; j++) {
                        paint[j] = 0;
                    }
                }
                i += m - 1;
                answer++;
            }
        }
        
        return answer;
    }
}