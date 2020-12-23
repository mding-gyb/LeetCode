
public class Q10 {
	public static void main(String[]args) {
		System.out.println(spliceString("aaaaaaa"));
		System.out.println(spliceString("abba"));
		System.out.println(spliceString("aabc"));
		System.out.println(spliceString("aab"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("mississippi", "mis*is*ip*."));
		System.out.println(isMatch("bba", ".*bba"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("ab", ".*c"));
		System.out.println(isMatch("aaa", "a*a"));
		System.out.println(isMatch("a", "ab*"));
		System.out.println(isMatch("", "c*"));
	}
	
	public static boolean isMatch(String s, String p) {
		if (s.equals(p)) {
			return true;
		} else if (p.equals(".") && s.length()==1) {
			return true;
		} else if (p.length()==1 && s.length()==1) {
			return false;
		} else if (p.length()>=2 && s.length()==0 && p.charAt(1) == '*') {
			return isMatch(s, p.substring(2, p.length()));
		} else if (s.length() == 0 || p.length() == 0){
			return false;
		}	else {
			if (p.length()==1 && s.length()!=1) {
				return false;
			} else if (s.charAt(0) != p.charAt(0) && p.charAt(1)!='*' && p.charAt(0)!='.') {
				return false;
			} else if (s.charAt(0) != p.charAt(0) && p.charAt(1) == '*' && p.charAt(0)!='.'){
				return isMatch(s, p.substring(2, p.length()));
			} else if (p.charAt(0)=='.' && p.charAt(1) == '*') {
				return isMatch(adjust1(s, p), adjust2(s,p)) || isMatch(s, p.substring(2, p.length()))
						|| isMatch(s.substring(1, s.length()), p);
			} else if (p.charAt(0)==s.charAt(0) && p.charAt(1) == '*') {
				return isMatch(adjust1(s, p), adjust2(s,p)) || isMatch(s, p.substring(2, p.length()))
						|| isMatch(s.substring(1, s.length()), p);
			} else {
				return isMatch(adjust1(s, p), adjust2(s,p));
			}
		}
        
    }	
	public static String adjust1(String s, String p) {
		if (p.charAt(0) == '.' && p.charAt(1) == '*') {
			return spliceString(s);
		} else if (p.charAt(0) == s.charAt(0) && p.charAt(1) == '*') {
			return spliceString(s);
		} else {
			return s.substring(1, s.length());
		}
	}
	public static String adjust2(String s, String p) {
		if (p.charAt(0) == '.' && p.charAt(1) == '*') {
			return p.substring(2, p.length());
		} else if (p.charAt(0) == s.charAt(0) && p.charAt(1) == '*') {
			return p.substring(2, p.length());
		} else {
			return p.substring(1, p.length());
		}
	}
	public static String spliceString(String a) {
		if (a.length() == 1) {
			return "";
		} else if (a.charAt(0) != a.charAt(1)) {
			return a.substring(1, a.length());
		} else {
			return spliceString(a.substring(1, a.length()));
		}
	}
}
