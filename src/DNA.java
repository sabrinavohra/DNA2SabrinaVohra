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
        for(int i = 0; i < sequence.length(); i++) {
//            if(current >= STR.length()) {
//                currentCount++;
//                if(currentCount > longestCount) {
//                    longestCount = currentCount;
//                }
//            }
            if(sequence.charAt(i) == STR.charAt(current)) {
                current++;
            }
            else if(sequence.charAt(i) != STR.charAt(current)){
                current = 0;
                currentCount = 0;
            }
            if(current >= STR.length()) {
                current = 0;
                currentCount++;
                if(currentCount > longestCount) {
                    longestCount = currentCount;
                }
            }
        }
        return longestCount;
    }
    // Could approach with binary search -- looking through options from both sides (changing STR to be opposite to
    // search properly

    // Hash tables?
        // Used for fast access?
        // Seems similar to a map

    // Could go through each n-letter chunk of letters?
        // Probably would be slower because splitting would take a long time
    // Could keep track of values in a more efficient way?

    // Could find a way to skip parts where there's no possibility of an STR
}
