import java.util.Collections;
public class Q12 {
	public static void main(String[]args) {
		System.out.println(intToRoman(100));
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(9));
		System.out.println(intToRoman(58));
		System.out.println(intToRoman(1994));
		System.out.println(intToRoman(3999));
	}
	public static String intToRoman(int num) {
		String out = ""; 

		// Initialize all symbols and number needed
		int [][] values = new int [7][2];
		values[0][0] = 1000;
		values[1][0] = 500;
		values[2][0] = 100;
		values[3][0] = 50;
		values[4][0] = 10;
		values[5][0] = 5;
		values[6][0] = 1;

		int temp = num;
		for(int i = 0; i < values.length; i ++) {
			values[i][1] = temp/values[i][0];
			temp -= values[i][1]*values[i][0];
		}
		// Account for M
		out += String.join("", Collections.nCopies(values[0][1], "M"));

		// Check for 4 C's
		if (values[2][1] == 4 && values [1][1] == 0) {
			out += "CD";
		} else if (values[2][1] == 4 && values [1][1] == 1) {
			out += "CM";
		} else {
			out += String.join("", Collections.nCopies(values[1][1], "D"));
			out += String.join("", Collections.nCopies(values[2][1], "C"));
		}

		// Check for 4 X
		if (values[4][1] == 4 && values [3][1] == 0) {
			out += "XL";
		} else if (values[4][1] == 4 && values [3][1] == 1) {
			out += "XC";
		} else {
			out += String.join("", Collections.nCopies(values[3][1], "L"));
			out += String.join("", Collections.nCopies(values[4][1], "X"));
		}

		// Check for 4 I
		if (values[6][1] == 4 && values [5][1] == 0) {
			out += "IV";
		} else if (values[6][1] == 4 && values [5][1] == 1) {
			out += "IX";
		} else {
			out += String.join("", Collections.nCopies(values[5][1], "V"));
			out += String.join("", Collections.nCopies(values[6][1], "I"));
		}
		return out;
	}
}
