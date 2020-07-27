
public class Q9 {
	/*public static void main(String[]args) {
		System.out.println(isPalindrome(-121));
	}*/
	public boolean isPalindrome(int x) {
        StringBuilder input1 = new StringBuilder();
        return Integer.toString(x).equals(input1.append(Integer.toString(x)).reverse().toString()) ? true : false;
    }
}
