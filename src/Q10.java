import java.util.*;
public class Q10 {
	public static void main(String[]args) {
		System.out.println(isMatch("hello", "world"));
	}
	public static boolean isMatch(String s, String p) {
		if (s.length() != p.length()) {
			return false;
		}
		if (s.length() == 0) {
			return true;
		}
		
		int count = 1;
		char s_previous = s.charAt(0);
		char p_previous = p.charAt(0);
		while(count < s.length()) {
			char s_char = s.charAt(count);
			char p_char = p.charAt(count);
			if(s.charAt(count) == '*') {
				s_char = s_previous;
			}
			if(p.charAt(count) == '*') {
				p_char = p_previous;
			}
			if(s_char != p_char) {
				if(s_char != '.' || p_char != '.') {
					return false;
				} else if (s_char == '.' && p_char == '.') {
					
				} else {
					s_char = s_char == '.' ? p_char : s_char;
					p_char = p_char == '.' ? s_char : p_char;
				}
			}
			s_previous = s_char;
			p_previous = p_char;
		}
        return true;
        
        
        
    }	
}
