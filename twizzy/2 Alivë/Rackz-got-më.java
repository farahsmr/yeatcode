class Solution {
    public static int getGCDRecursive(int a, int b) {
        return b == 0 ? Math.abs(a) : getGCDRecursive(b, a % b);
    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(
                0, getGCDRecursive(str1.length(), str2.length())
        );
    }
}