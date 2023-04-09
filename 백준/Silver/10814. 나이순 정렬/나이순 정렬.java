import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
	public int age;
	public int index;
	
	Point(int age, int index) {
		this.age = age;
		this.index = index;
	}
	
	public int compareTo(Point o) {
		if (this.age == o.age)
			return this.index - o.index;
		else 
			return this.age - o.age;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(bf.readLine());
        
        ArrayList<Point> arr = new ArrayList<>();
        ArrayList<String> name_arr = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(bf.readLine());
        	int age = Integer.parseInt(st.nextToken());
        	String name = st.nextToken();
        	arr.add(new Point(age, i));
        	name_arr.add(name);
        }
        
        Collections.sort(arr);
        
        for (Point o : arr) 
        	System.out.println(o.age + " " + name_arr.get(o.index));
	}
}