class Solution {
 public:
    double solve(vector<int>& max, vector<int>& min){
        int m, n;
        int minlen, maxlen;
        maxlen = max.size();
        minlen = min.size();
        m = maxlen /2;
        n = minlen /2;
        int jumpm = m / 2;
        int jumpn = n / 2;
        while (true){
            cout<<"m"<<m<<n<<endl;
            cout<<"ma"<<max[m]<<min[n]<<endl;
            cout<<"j"<<jumpm<<jumpn<<endl;
            if (max[m] == min[n]) return max[m];
            if /*((m==0)&&(n=minlen-1)
                ||*/((jumpn==0)&&(jumpm==0))/*)*/ {
                if (m+n == (maxlen+minlen)/2) return min[n];
                if (m+n+1 == (maxlen+minlen)/2) return max[m];

                return (max[m]+min[n])/2.0;
            }
            if (max[m] > min[n]) {
                if (m>0) {
                    m -= jumpm;
                    jumpm = jumpm / 2;
                } else jumpm = 0;
                if (n<minlen-1) {
                    n += jumpn;
                    jumpn = jumpn / 2;
                } else jumpn = 0;
            } else {
                if (n>0) {
                    n -= jumpn;
                    jumpn = jumpn / 2;
                } else jumpn = 0;
                if (m<maxlen-1) {
                    m += jumpm;
                    jumpm = jumpm / 2;
                } else jumpm = 0;
            }
        }
    }

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
