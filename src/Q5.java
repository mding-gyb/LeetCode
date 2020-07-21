import java.lang.*;
public class Q5 {
	public static void main(String[]args) {
		System.out.println(longestPalindrome("babad"));
	}
    /*public static String longestPalindrome(String s) {
    	if (s.length() == 0) {
    		return "";
    	}
    	StringBuilder reversed = new StringBuilder(); 
    	String maxString = Character.toString(s.charAt(0));
        for(int i = 0; i < s.length(); i++) {
        	for(int a = s.length(); a > i; a --) {
        		String temp = s.substring(i,a);
        		if (temp.length() <= maxString.length()) {
        			break;
        		} else{
        			System.out.println(temp);
        			reversed.append(temp);
        			reversed = reversed.reverse();
        			if(temp.equals(reversed)) {
        				maxString = temp;
        			}
        		}
        		
        	}
        }
        return maxString;
    }
    public static boolean isPalindrome(String a) {
    	int n = a.length();
    	  for (int i = 0; i < (n/2); i++) {
    	     if (a.charAt(i) != a.charAt(n - i - 1)) {
    	         return false;
    	     }
    	  }

    	  return true;
    }
    
	public String longestPalindrome(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(check(s, i, i) == true) {
				
			}
		}
	}
	public boolean check(String a, int index1, int index2) {
		if (index1 == index2) {
			return true;
		} else if (index1 + 1 == index2){
			return a.substring(index1, index1+1) == a.substring(index2, index2+1);
		}
	}*/
	
	
	// Kind of Dynamic Programming Approach
	
	public static String longestPalindrome(String s) {
		if(s.equals("")) {
			return s;
		}
		String maxString = Character.toString(s.charAt(0));
		
		boolean[][] palindromeEdges = new boolean[s.length()][s.length()];
		for(int i = 0; i < s.length(); i ++) {
			for(int j = 0; j <= i; j ++) {
				boolean test;
				if(s.charAt(i) == s.charAt(j)) {
					test = true;
				} else {
					test = false;
				}
				
				if (i - j >= 2) {
					palindromeEdges[i][j] = test && palindromeEdges[i-1][j+1];
				} else {
					palindromeEdges[i][j] = test;
				}
				
				if(i-j + 1 > maxString.length() && palindromeEdges[i][j] == true) {
					maxString = s.substring(j, i+1);
				}
			}
		}
		return maxString;
		
	}
}
