class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;

        while (i < flowerbed.length) {
            int left = (i == 0) ? 0 : flowerbed[i-1];
            int right = (i == flowerbed.length-1) ? 0 : flowerbed[i+1];

            if ((left + flowerbed[i] + right) == 0) {
                flowerbed[i] = 1;
                --n;
                i += 2;
            }
            else {
                i++;
            }
        }

        if (n <= 0) return true;
        else return false;
    }
}