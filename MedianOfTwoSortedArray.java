public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = new int[m + n];
        double ans = 0.0;
        int i = 0, j = 0, h = 0;
        while (i < m || j < n) {
            if (j >= n || i < m && nums1[i] < nums2[j]) {
                merge[h] = nums1[i];
                i++;
            } else {
                merge[h] = nums2[j];
                j++;
            }
            h++;
        }
        if ((m + n) % 2 == 1) {
            ans = (double) merge[(m + n) / 2];
        } else {
            ans = (double) (merge[(m + n) / 2] + merge[(m + n) / 2 - 1]) / 2;
        }
        return ans;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 == 1) {
            return findKth(nums1, 0, m, nums2, 0, n, total / 2 + 1);
        } else {
            return (findKth(nums1, 0, m, nums2, 0, n, total / 2) + findKth(nums1, 0, m, nums2, 0, n, total / 2 + 1)) / 2;
        }
    }

    public double findKth(int[] nums1, int start1, int m, int[] nums2, int start2, int n, int k) {
        if (m > n) {
            return findKth(nums2, start2, n, nums1, start1, m, k);
        }
        if (m == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int p1 = Math.min(k / 2, m), p2 = k - p1;
        if (nums1[start1 + p1 - 1] < nums2[start2 + p2 - 1]) {
            return findKth(nums1, start1 + p1, m - p1, nums2, start2, n, k - p1);
        } else {
            return findKth(nums1, start1, m, nums2, start2 + p2, n - p2, k - p2);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArray test = new MedianOfTwoSortedArray();
        int[] nums1 = {};
        int[] nums2 = {1};
        System.out.println(test.findMedianSortedArrays2(nums1, nums2));
    }
}