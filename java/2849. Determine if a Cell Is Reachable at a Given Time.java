// Weekly Contest 362 Q2
class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy && t == 1) {
            return false;
        }
        int lenX = Math.abs(fx - sx), lenY = Math.abs(fy - sy);
        return t >= Math.max(lenX, lenY);
    }
}
