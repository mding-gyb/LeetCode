import java.math.*;
public class Q11 {
	public int maxArea(int[] height) {
		if (height.length == 2) {
			return Math.min(height[0], height[1]);
		} else {
			return calcMax(height);
		}
	}
	private int calcMax(int[]a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) { 
			for (int j = i; j < a.length; j++) {
				int temp = (j - i) * Math.min(a[i], a[j]);
				if (temp > max) {
					max = temp;
				}
			}
		}
		return max;
		
	}
}
