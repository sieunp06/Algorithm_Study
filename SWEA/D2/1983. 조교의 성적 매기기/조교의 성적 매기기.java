import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
        
		for (int test_case = 1; test_case <= T; test_case++) {
			double N = sc.nextDouble();
            int K = sc.nextInt();
            
            List<Student> students = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                double score = sc.nextDouble() * 0.35 + sc.nextDouble() * 0.45 + sc.nextDouble() * 0.2;
            	students.add(new Student(i, score));
            }
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student s1, Student s2) {
                    if (s1.score < s2.score) return 1;
                    return -1;
                }
            });
            
            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < students.size(); i++) {
            	if (students.get(i).no == K) {
                    double result = (i + 1) / (N / 10);
                    
                    if (result <= 1) sb.append("A+").append("\n");
                    else if (result <= 2) sb.append("A0").append("\n");
                    else if (result <= 3) sb.append("A-").append("\n");
                    else if (result <= 4) sb.append("B+").append("\n");
                    else if (result <= 5) sb.append("B0").append("\n");
                    else if (result <= 6) sb.append("B-").append("\n");
                    else if (result <= 7) sb.append("C+").append("\n");
                    else if (result <= 8) sb.append("C0").append("\n");
                    else if (result <= 9) sb.append("C-").append("\n");
                    else if (result <= 10) sb.append("D0").append("\n");
                }
            }
		}
        
        System.out.print(sb);
	}
}

class Student {
	public int no;
    public double score;
    public Student(int no, double score) {
    	this.no = no;
        this.score = score;
    }
}