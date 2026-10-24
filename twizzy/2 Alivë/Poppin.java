class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        if (((l1<1) && (l2 <1))  && ((l2>100) && (l1>100)) && (!word1.toLowerCase().equals(word1)) && (!word2.toLowerCase().equals(word2))){ throw new IllegalArgumentException("invalid words");}
        String output ="";
        String rest ="";
        if(l1>l2){
            for(int i=0;i<l2;++i){
                output= output+ word1.charAt(i)+word2.charAt(i);
            }
            rest = word1.substring(l2,l1);
            output = output+ rest;
        } else {
            for(int i=0;i<l1;++i){
                output= output+ word1.charAt(i)+word2.charAt(i);
            }
            rest = word2.substring(l1,l2);
            output = output+ rest;
        }
        return output;
    }
}
// cleaner solution
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int min = Math.min(l1, l2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        sb.append(word1.substring(min));
        sb.append(word2.substring(min));
        return sb.toString();
    }
}

// even cleaner ( 0ms)

class Solution {
    public String mergeAlternately(String word1, String word2) {
        // Store both lengths (declaring two ints on one line)
        int wl1 = word1.length(), wl2 = word2.length();

        // Result array, exactly big enough for all letters from both words
        char[] mergedArr = new char[wl1 + wl2];

        // Convert each String into a char array so we can read letters by index
        char[] wArr1 = word1.toCharArray();
        char[] wArr2 = word2.toCharArray();

        // w1 = how many letters taken from word1
        // w2 = how many letters taken from word2
        // i  = next empty slot in mergedArr
        int w1 = 0, w2 = 0, i = 0;

        // Keep going while BOTH words still have letters left
        while (w1 < wl1 && w2 < wl2) {
            if (w1 == w2) {
                // Equal counts means it's word1's turn.
                // wArr1[w1++] reads the letter at w1, THEN adds 1 to w1.
                // mergedArr[i++] = ... writes at i, THEN adds 1 to i.
                mergedArr[i++] = wArr1[w1++];
            } else {
                // word1 is one ahead, so it's word2's turn
                mergedArr[i++] = wArr2[w2++];
            }
        }

        // Copy whatever is left over (only one word can have leftovers).
        // arraycopy(source, startInSource, destination, startInDestination, howManyItems)
        System.arraycopy(wArr1, w1, mergedArr, i, wl1 - w1);
        System.arraycopy(wArr2, w2, mergedArr, i, wl2 - w2);

        // Turn the char array back into a String
        return new String(mergedArr);
    }
}