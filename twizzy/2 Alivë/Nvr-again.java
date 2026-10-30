class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> results = new ArrayList<>();

        for (int i = 0; i < candies.length; ++i) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        for (int i = 0; i < candies.length; ++i) {
            if (candies[i] + extraCandies >= max) {
                results.add(true);
            } else {
                results.add(false);
            }
        }

        return results;
    }
}