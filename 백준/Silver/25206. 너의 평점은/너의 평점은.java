import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static double grades(String grade) {
        if (grade.equals("A+"))
            return 4.5;
        else if (grade.equals("A0"))
            return 4.0;
        else if (grade.equals("B+"))
            return 3.5;
        else if (grade.equals("B0"))
            return 3.0;
        else if (grade.equals("C+"))
            return 2.5;
        else if (grade.equals("C0"))
            return 2.0;
        else if (grade.equals("D+"))
            return 1.5;
        else if (grade.equals("D0"))
            return 1.0;
        return 0.0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double total = 0;
        double total_hour = 0;
        double answer;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(bf.readLine());

            String subject = st.nextToken();
            double hour = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                double grade_num = grades(grade);
                total_hour += hour;
                total += hour * grade_num;
            }

        }
        answer = total / total_hour;
        System.out.printf("%.6f\n", answer);
    }
}