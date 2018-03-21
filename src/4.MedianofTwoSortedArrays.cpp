class Solution {
 public:


    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {

        int m, n;
        m = nums1.size();
        n = nums2.size();
        if (m==0)
            return n % 2 ? nums2[n/2] : (nums2[n/2]+nums2[n/2-1])/2.0;
        if (n==0)
            return m % 2 ? nums1[m/2] : (nums1[m/2]+nums1[m/2-1])/2.0;
        if (nums1[m/2] > nums2[n/2]) return solve(nums1, nums2);
        else return solve(nums2, nums1);
    }

};
