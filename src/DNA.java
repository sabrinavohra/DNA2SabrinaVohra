/**
 * DNA
 * <p>
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *</p>
 * <p>
 * Completed by: Sabrina Vohra
 *</p>
 */

public class DNA {
    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        int current = 0;
        int longestCount = 0;
        int currentCount = 0;
        for(int i = 0; i < sequence.length() - 1; i++) {
            if(current >= STR.length()) {
                current = 0;
                currentCount++;
                if(currentCount >= longestCount) {
                    longestCount = currentCount;
                }
            }
            else if(sequence.charAt(i) == STR.charAt(current)) {
                current++;
            }
            else if(sequence.charAt(i) != STR.charAt(current)){
                current = 0;
                currentCount = 0;
            }
        }
        return longestCount;
    }
    // Could approach with binary search -- looking through options from both sides (changing STR to be opposite to
    // search properly

    // Hash tables?
        // Used for fast access?
        // Seems similar to a map

    //
}
