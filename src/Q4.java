import java.lang.Math;
public class Q4 {
	public static void main (String[]args) {
		// Insert test code here
		System.out.println(5/2);
	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = 0;
		int mergedlength = nums1.length + nums2.length;
		int index1 = 0, index2 = 0;
		int bigarr [] = new int [mergedlength];
		while(index1<nums1.length && index2 < nums2.length) {
			if(nums1[index1] <= nums2[index2]) {
				bigarr[count] = nums1[index1];
				index1++;
				count++;
			} else {
				bigarr[count] = nums2[index2];
				index2++;
				count++;
			}
		}
		while (index1 < nums1.length) {
			bigarr[count] = nums1[index1]; 
			index1++;
			count++;
		}
		while (index2 < nums2.length) {
			bigarr[count] = nums2[index2]; 
			index2++;
			count++;
		}
        
		if(bigarr.length % 2 == 1) {
			return bigarr[bigarr.length/2]; // will floor
		} else {
			return (double)(bigarr[bigarr.length/2-1] + bigarr[bigarr.length/2])/2; // zero indexed array
		}
    }
}
