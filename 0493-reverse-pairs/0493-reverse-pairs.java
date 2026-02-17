class Solution {
    public int reversePairs(int[] nums) {
        return nums == null || nums.length < 2 ? 0 : sort(nums, 0, nums.length - 1);
    }

    private int sort(int[] a, int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) >>> 1;
        int count = sort(a, l, m) + sort(a, m + 1, r);

        for (int i = l, j = m + 1; i <= m; i++) {
            while (j <= r && (long) a[i] > 2L * a[j]) j++;
            count += j - (m + 1);
        }

        int[] tmp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m || j <= r)
            tmp[k++] = (j > r || (i <= m && a[i] <= a[j])) ? a[i++] : a[j++];

        System.arraycopy(tmp, 0, a, l, tmp.length);
        return count;
    }
}
