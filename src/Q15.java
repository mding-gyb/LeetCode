import java.util.*;
public class Q15 {
	public static void main(String[]args) {
		 int[] test = new int[]{0}; 
		 System.out.println(threeSum(test).toString());
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> out = new ArrayList<>();
		
		for (int i = 0; i < nums.length-2; i++) {
			for (int j = i+1; j < nums.length;j++) {
				if (nums[i]+nums[j]<=0 && findThird(startingAt(nums, j+1), -1*(nums[i]+nums[j])) == true) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(-1*(nums[i]+nums[j]));
					if (out.contains(temp) == false) {
						out.add(new ArrayList());
						out.get(out.size()-1).add(nums[i]);
						out.get(out.size()-1).add(nums[j]);
						out.get(out.size()-1).add(-1*(nums[i]+nums[j]));
					}
				}
			}
			if(nums[i]>0) {
				break;
			}
		}
		return out;
	}
	public static boolean findThird(int[] nums, int wanted) {
		for (int i = nums.length-1; i >= 0; i--) {
			if (nums[i]==wanted) {
				return true;
			}
		}
		return false;
	}
	public static int[] startingAt(int[]nums, int start) {
		int out[] = new int [nums.length-start];
		for(int i = start; i < nums.length; i++) {
			out[i-start] = nums[i];
		}
		return out;
	}
	
}
