package Algo;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class algo {		
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		Deque<Integer> Q = new LinkedList<>();
		ArrayList<Integer> answer = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			while (st.hasMoreTokens()) {
				String text = st.nextToken();
				if (text.equals("push")) {
					Q.offer(Integer.parseInt(st.nextToken()));
					break;
				} else if (text.equals("pop")) {
					Integer item = Q.poll();
					if (item == null)
						answer.add(-1);
					else answer.add(item);
					break;
				} else if (text.equals("size")) {
					answer.add(Q.size());
					break;
				} else if (text.equals("empty")) {
					if (Q.isEmpty()) 
						answer.add(1);
					else 
						answer.add(0);
					break;
				} else if (text.equals("front")) {
					Integer item = Q.peek();
					if (item == null)
						answer.add(-1);
					else answer.add(item);
					break;
				} else if (text.equals("back")) {
					Integer item = Q.peekLast();
					if (item == null)
						answer.add(-1);
					else answer.add(item);
					break;
				}
			}
		}
		for (int i = 0; i < answer.size(); i++) 
			System.out.println(answer.get(i));
    }
}
