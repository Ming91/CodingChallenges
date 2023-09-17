class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int i = 0;
        while (i < l) {
            if (l - i < n) {
                return false;
            }
            if (n == 0) {
                return true;
            }
            if (flowerbed[i] == 1) {
                i += 2;
                continue;
            }
            if (i + 1 < l && flowerbed[i + 1] == 1) {
                i += 3;
                continue;
            }
            n--;
            i += 2;
        }
        return n == 0;
    }
}
// step size为1, 则要赋值flowerbed为1给新插的花
// step size设置为2 or 3, 直接跳过,不用赋值, 快上加快.

// class Solution {
//     public boolean canPlaceFlowers(int[] flowerbed, int n) {
//         boolean ans = true;
//         //boolean avaliable = true;
//         int l = flowerbed.length;
//         for (int i = 0; i < l && n > 0; i++) {
//             // if the #remain spots is not large enough
//             if (l - i < n) {
//                 return false;
//             }
//             if ((i - 1 < 0 || flowerbed[i - 1] == 0) &&
//                 (flowerbed[i] == 0) &&
//                 (i + 1 >= l || flowerbed[i + 1] == 0)) {
//                     flowerbed[i] = 1;
//                     n--;
//                 }
//         }
//         if (n > 0) {
//             return false;
//         }
//         return true;
//     }
// }
