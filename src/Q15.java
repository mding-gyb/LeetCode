import java.util.*;
public class Q15 {
	public static void main(String[]args) {
		 int[] test = new int[]{0}; 
		 System.out.println(threeSum(test).toString());
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> out = new ArrayList<>();
		Map<List<Integer>, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length-2; i++) {
			int k = nums.length-1;
			for (int j = i+1; j < k;j++) {
				while (j < k) {
					if (nums[i]+nums[j]+nums[k] == 0) {
						if (!map.containsKey(Arrays.asList(nums[i], nums[j]))) {
							map.put(Arrays.asList(nums[i], nums[j]), nums[k]);
							out.add(new ArrayList());
							out.get(out.size()-1).add(nums[i]);
							out.get(out.size()-1).add(nums[j]);
							out.get(out.size()-1).add(nums[k]);
							j++;
							k--;
						} else {
							j++;
							k--;
						}
					} else if (nums[i]+nums[j]+nums[k] < 0) {
						j++;
					} else {
						k--;
					}
				}
			}
		}
		return out;
	}
	
}
