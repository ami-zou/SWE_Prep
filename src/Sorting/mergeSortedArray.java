package Sorting;

public class mergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// algo: start from the very end of the nums1[]
		// since it is sorted, we pick whatever is larger at the very end of each array
		// to the tail-- of nums1[]
		// if nums2[] finishes first: great, the rest of nums1 remains unchanged
		// else if nums1 finishes first: need another while loop to copy the rest of
		// nums2 to 1's front
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}

		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
	}
}
