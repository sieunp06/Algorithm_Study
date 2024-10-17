import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {	
	static Character[][] arr; // 글자판 배열
	static int sum; // 회문의 갯수
	static int l; // 회문의 길이
	
	public static void find(int i, int j, String type) {
		String tmp = "";
		int count = 0;
		
		// 가로 찾기
		if(type.equals("x")) {
			while(count < l) {
				tmp += arr[i][j+count];
				count++;
			}
		}
		// 세로 찾기
		else {
			while(count < l) {
				tmp += arr[j+count][i];
				count++;
			}
		}

		// 문자열 뒤집기
		StringBuffer bf = new StringBuffer(tmp);
		String reverse = bf.reverse().toString();
		
		// 회문 여부 검사
		if(tmp.equals(reverse)) {
			sum++;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t =0; t<10; t++) {
			l = Integer.parseInt(br.readLine());
			sum = 0; 
			arr = new Character[8][8];
			
			// 글자판 입력
			for(int i=0; i<8; i++) {
				String str = br.readLine();
				for(int j=0; j<8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			for(int i=0; i<8; i++) {
				for(int j =0; j <= (8-l); j++) {
					find(i,j,"x"); // 가로찾기
					find(i,j,"y"); // 세로찾기
				}
			}	
			System.out.println("#"+ (t+1) + " " + sum);
		}
	}
}