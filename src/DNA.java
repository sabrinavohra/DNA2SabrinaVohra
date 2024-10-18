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
   public static final int RADIX = 4;
   public static final int BIG_PRIME = 506683;
    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        int count = 0;
        int strHash = hash(STR);
        String currentSection = sequence.substring(0, sequence.length() - 1);
        for(int i = 0; i < sequence.length(); i++) {
            currentSection = currentSection.substring(1) + sequence.substring(sequence.charAt(i +
                    sequence.length() - 1));
            int hashed = hash(currentSection);
            if(strHash == hashed) {
                count++;
            }
        }
        return count;
    }

    // make recursive
    public static int hash (String toHash) {
        int current = 0;
        int hash = 0;
        for(int i = 0; i < toHash.length(); i++) {
            hash = hash + (toHash.charAt(i)*(int)Math.pow(RADIX, (double)i-current) % BIG_PRIME);
            current++;
        }
        return hash;
    }
}