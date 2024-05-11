import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
        int sharpIdx = 0;
		for (int i = 0; i < 5; i++) {
        	for (int j = 0; j < 5; j++) {
            	if (j == sharpIdx) {
                	System.out.print("#");
                } else {
                	System.out.print("+");
                }
            }
            System.out.println();
            sharpIdx++;
        }
	}
}