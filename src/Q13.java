
public class Q13 {
	public static void main(String[]args) {
		System.out.println(romanToInt("III"));
	}
	public static int romanToInt(String s) {
		int out = 0;
		while (s.equals("") == false) {
			if(s.length()==1) {
				out += convert (s.charAt(0));
				s = s.substring(1, s.length());
			} else if (s.charAt(0)=='I' && s.charAt(1)=='V') {
				out += 4;
				s = s.substring(2, s.length());
			} else if (s.charAt(0)=='I' && s.charAt(1)=='X') {
				out += 9;
				s = s.substring(2, s.length());
			} else if (s.charAt(0)=='X' && s.charAt(1)=='L') {
				out += 40;
				s = s.substring(2, s.length());
			} else if (s.charAt(0)=='X' && s.charAt(1)=='C') {
				out += 90;
				s = s.substring(2, s.length());
			} else if (s.charAt(0)=='C' && s.charAt(1)=='D') {
				out += 400;
				s = s.substring(2, s.length());
			} else if (s.charAt(0)=='C' && s.charAt(1)=='M') {
				out += 900;
				s = s.substring(2, s.length());
			} else {
				out += convert(s.charAt(0));
				s = s.substring(1, s.length());
			}
		}
		return out;
	}
	private static int convert(char c) {
		if (c == 'I') {
			return 1;
		} else if (c == 'V') {
			return 5;
		} else if (c == 'X') {
			return 10;
		} else if (c == 'L') {
			return 50;
		} else if (c == 'C') {
			return 100;
		} else if (c == 'D') {
			return 500;
		} else {
			return 1000;
		}
	}
}
