import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
	    Scanner in = new Scanner(System.in);
	    int count = 0;
	    
	    String input1 = in.nextLine();	// 문자열
	    String input2 = in.nextLine();	// 문자
	    
	    input1 = input1.toLowerCase();
	    input2 = input2.toLowerCase();
	    
	    char[] charList = new char[input1.length()];
	    
	    for (int i = 0; i < input1.length(); i++) {
	    	charList[i] = input1.charAt(i);
	    }
	    
	    for (int i = 0; i < input1.length(); i++) {
	    	if (charList[i] == input2.charAt(0)) {
	    		count++;
	    	}
	    }
	    
	    System.out.println(count);
	}
}