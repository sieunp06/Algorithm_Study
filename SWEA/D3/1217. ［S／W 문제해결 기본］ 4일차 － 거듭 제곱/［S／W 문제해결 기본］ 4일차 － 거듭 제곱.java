import java.util.Scanner;

class Solution {
	public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        for(int test_case = 0; test_case < 10; test_case++) {
             
            int test = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println("#"+(test_case+1) + " " + power(N, M));
        }
    }
     
    public static int power(int N, int M) {
        if(M == 1) 
            return N;
         
        return N * power(N, M-1);
    }
}