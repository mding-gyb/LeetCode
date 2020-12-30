
public class Q14 {
	public static void main(String[]args) {
		
	}
	public static String longestCommonPrefix(String[] strs) {
		String out = "";
		int shortest = Integer.MAX_VALUE;
		for(int i = 0; i < strs.length; i++) {
			if (strs[i].length()<shortest) {
				shortest = strs[i].length();
			}
		}
		
		if (strs.length == 0) {
			return "";
		} else {
			for (int i = 0; i < shortest; i ++) {
				char temp = strs[0].charAt(i);
				for (int j = 0; j < strs.length; j++) {
					if (strs[j].charAt(i)!=temp) {
						return out;
					}
				}
				out += Character.toString(temp);
			}
		}
		return out;
	}
}
