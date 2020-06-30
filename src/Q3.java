import java.util.*;
public class Q3 {
	public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int [] lastIndexes = new int[128]; // We create an array of all possible characters and populate these with the index number of the last occurence of this character
        for(int i = 0; i < lastIndexes.length; i ++){
            lastIndexes[i] = -1;
        }
        
        int leftIndex = 0;
        for(int i = 0; i < s.length(); i ++){
            if(leftIndex < lastIndexes[s.charAt(i)] + 1){ // update left Index if needed
                leftIndex = lastIndexes[s.charAt(i)]+1;
            }
            max = Math.max(max, i - leftIndex + 1); // check if new length of non-reoccuring is greater than max
            lastIndexes[s.charAt(i)] = i; // set last index of current character as current index
        }
        return max;
    }
    public static void main(String[]args){
        
    }
}
