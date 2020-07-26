import java.util.ArrayList;
public class Q8 {
	public static void main(String[] args) {
		System.out.println(myAtoi("  15"));
	}
	public static int myAtoi(String str) {
		String out = "";
		int index = 0;
		ArrayList <String> checks = new ArrayList<String>();
		
		for(int i = 1; i < 10; i++) {
			checks.add(Integer.toString(i));
		}
		
		checks.add("-");
		
		while (str.charAt(index) == ' ') {
			System.out.println(index);
			index ++;
		}
		if(!checks.contains(Character.toString(str.charAt(index)))) {
			return 0;
		} 
		
		while (checks.contains(Character.toString(str.charAt(index))) && index < str.length()) {
			System.out.println(index);
			out += Character.toString(str.charAt(index));
			index++;	
		}
		return Integer.parseInt(out);
	}
}
