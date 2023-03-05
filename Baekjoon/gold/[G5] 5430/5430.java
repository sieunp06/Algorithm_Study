import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(bf.readLine());
		
		while (T --> 0) {
			boolean check = true;
			boolean isRev = false;
			
			LinkedList<Integer> dq = new LinkedList<>(); 
			
			String command = bf.readLine();
			int n = Integer.parseInt(bf.readLine());
			String arr_text = bf.readLine();
			arr_text = arr_text.substring(1, arr_text.length() - 1);
			
			StringTokenizer st = new StringTokenizer(arr_text, ",");
			for (int i = 0; i < n; i++)
				dq.offer(Integer.parseInt(st.nextToken()));

			for (int i = 0; i < command.length(); i++) {
				char t = command.charAt(i);
				
				switch(t) {
					case 'R':
						if (isRev) 
							isRev = false;
						else isRev = true;
						break;
					case 'D':
						if (dq.isEmpty() && check) {
							sb.append("error").append('\n');
							check = false;
						} 
						if (isRev)
							dq.pollLast();
                        else  
							dq.poll();
						break;
				}
			}

			if (check) {
				sb.append('[');
				int leng = dq.size();

				if (isRev) {
					for (int i = 0; i < leng; i++) {
						if (dq.size() > 1) 
							sb.append(dq.pollLast()).append(',');
						else 
							sb.append(dq.pollLast());

					}
				} else {
					for (int i = 0; i < leng; i++) {
						if (dq.size() > 1)
							sb.append(dq.poll()).append(',');
						else sb.append(dq.poll());
					}
				}
				sb.append(']');
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}
}