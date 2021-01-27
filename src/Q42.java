
public class Q42 {
	public int trap(int[]height) {
		return rainVolume(height, 0, 0);
	}
	public int rainVolume(int[] heights, int index, int volume) {
		if (index == heights.length-1) {
			return volume;
		}
		return 0;
	}
}
