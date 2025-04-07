/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* p = NULL;
int* twoSum(int* nums, int numsSize, int target) {
    for (int i = 0; i < numsSize; i++){
        int a = nums[i];
        for (int j = i+1; j < numsSize; j++){
            int b= nums[j];
            if (a+b == target){
                p= malloc(sizeof(int)*2);
                if (p != NULL){
                    *p = i;
                    *(p+1) = j;
                }
                return p;
            }
        }
    }
    return p;
}
