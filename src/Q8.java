import java.util.ArrayList;
public class Q8 {
	public static void main(String[] args) {
		System.out.println(myAtoi("+-2"));
	}
	public static int myAtoi(String str) {
		String out = "";
		int index = 0;
		ArrayList <String> checks = new ArrayList<String>();
		
		for(int i = 0; i < 10; i++) {
			checks.add(Integer.toString(i));
		}
		try {
			while (str.charAt(index) == ' ') {
				index ++;
			}
			if (str.charAt(index) == '+') {
				out += "+";
                index++;
			} else if (str.charAt(index) == '-') {
				out += "-";
                index++;
			}
			
			if(!checks.contains(Character.toString(str.charAt(index)))) {
				return 0;
			} 
		} catch (Exception e) {
			
		}
		
		try {
			while (checks.contains(Character.toString(str.charAt(index)))) {
				out += Character.toString(str.charAt(index));
				index++;	
			}
		} catch (Exception e) {
			
		}
		try {
			
			return out.equals("") ? 0 : Integer.parseInt(out);
		} catch (Exception e) {
			if (out.charAt(0) == '-') {
				if(out.length() != 1) {
					return Integer.MIN_VALUE;
				}
				return 0;
			} else if (out.charAt(0) == '+') {
                if(out.length() != 1) {
					return Integer.MAX_VALUE;
				}
				return 0;
			} else {
                return Integer.MAX_VALUE;
            }
		}	
	}
}
