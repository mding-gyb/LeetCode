import java.util.Arrays;
public class Q6 {
	public static void main(String[]args) {
		System.out.println(convert("PAYPALISHIRING", 4));
	}
    public static String convert(String s, int numRows) {
        int letterNum = 0;
        int col = 0;
        int outIndexes [] [] = new int [2][s.length()];
        while(letterNum < s.length()) {
        	for(int i = 0; i < numRows && letterNum < s.length(); i++) {
        		outIndexes[0][letterNum] = i;
        		outIndexes[1][letterNum] = col;
        		letterNum++;
        	}
        	for (int i = 0; i < numRows-2 && letterNum < s.length(); i++) {
        		col++;
        		outIndexes[0][letterNum] = (numRows-1) - (i+1);
        		outIndexes[1][letterNum] = col;
        		letterNum++;
        	}
        	col++;
        }
        char output [] [] = new char [numRows][col];
        
        for(int a = 0; a < s.length(); a++) {
        	output [outIndexes[0][a]][outIndexes[1][a]] = s.charAt(a);
        }
        String letters = "";
        
        for(int i = 0; i < numRows; i ++) {
        	for(int j = 0; j < col; j++) {
        		letters += output[i][j] == '\u0000' ? "" : output[i][j];
        	}
        }
        /* Debugging code
         * System.out.println(letters);
        for(int i = 0; i < letters.length(); i ++) {
        	System.out.print(i + " ");
        	System.out.println(letters.charAt(i));
        }
        String out = new String(letters);
        //System.out.println(letters.charAt(1) == " ");
        System.out.println("a" + Character.toString(letters.charAt(19))+ "b");
        System.out.println(Character.toString(letters.charAt(19)).equals);
        out = out.replaceAll("\\p{Blank}","");*/
        
       
        return letters;
    }
}
