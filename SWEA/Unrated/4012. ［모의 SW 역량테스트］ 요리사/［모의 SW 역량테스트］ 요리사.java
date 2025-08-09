import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	private static final StringBuilder stringBuilder = new StringBuilder();
	private static StringTokenizer stringTokenizer;
	
	private static int N;	// 식재료의 수
	private static boolean[] foods;
	private static boolean[] visited;
	private static int[][] scores;
	private static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int tc = 1; tc <= T; tc++) {
			init();
			separate(0, 0);
			stringBuilder.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(stringBuilder);
	}
	
	private static void init() throws NumberFormatException, IOException {
		N = Integer.parseInt(bufferedReader.readLine());
		foods = new boolean[N];
		visited = new boolean[N];
		
		scores = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < N; j++) {
				scores[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}
		
		answer = Integer.MAX_VALUE;
	}
	
	// 조합 구하기
	private static void separate(int depth, int start) {
		if (depth == N / 2) {
			calcDiff();
			return;
		}
		
		for (int i = start; i < N; i++) {
			foods[i] = true;
			separate(depth + 1, i + 1);
			foods[i] = false;
		}
	}
	
	static void calcDiff() {
        int sumA = 0;
        int sumB = 0;
        
        for (int i = 0; i < N; i++) {
        	for (int j = i + 1; j < N; j++) {
        		if (foods[i] && foods[j]) {
        			sumA += scores[i][j] + scores[j][i];
        		}
        		if (!foods[i] && !foods[j]) {
        			sumB += scores[i][j] + scores[j][i];
        		}
        	}
        }
        
        int diff = Math.abs(sumA - sumB);
        answer = Math.min(answer, diff);
    }
}