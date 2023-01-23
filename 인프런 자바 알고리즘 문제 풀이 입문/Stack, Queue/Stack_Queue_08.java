import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Person {
	int id;
	int priority;
	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
}
  
public class Main {
  private static int solution(int N, int M, int[] danger) {
		int answer = 1;
		
		Queue<Person> patient = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			patient.offer(new Person(i, danger[i]));
		}
		
		while (!patient.isEmpty()) {
			Person tmp = patient.poll();
			
			for (Person x : patient) {
				if (x.priority > tmp.priority) {
					patient.offer(tmp);
					tmp = null;
					break;
				}
			}
			if (tmp != null) {
				if (tmp.id == M) return answer;
				else answer++;
			}
		}

		
		return answer;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		int[] danger = new int[N];
		
		StringTokenizer st2 = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < N; i++) 
			danger[i] = Integer.parseInt(st2.nextToken());
		
		System.out.println(solution(N, M, danger));
    }
}