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
        int count = 0;
        for(int i = 0; i < sequence.length() - 1; i++) {
            if(current >= STR.length()) {
                count++;
            }
            else if(sequence.charAt(i) == STR.charAt(current)) {
                current++;
            }
            else {
                current = 0;
            }
        }
        return count;
    }
}
