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
   public static final int RADIX = 85;
   public static final int BIG_PRIME = 506683;
    /**
     * TODO: Complete this function, STRCount(), to return longest consecutive run of STR in sequence.
     */
    public static int STRCount(String sequence, String STR) {
        int count = 0;
        long strHash = hash(STR);
        String currentSection = sequence.substring(0, STR.length());
        for(int i = 0; i < sequence.length() - STR.length(); i++) {
            long hashed = hash(currentSection);

            // If we match, look ahead to the next STR — use Horner's method
            if(strHash == hashed) {
                count++;
            }
            long firstLetter = (long)Math.pow(BIG_PRIME, 1);
            // No match — shift window over by 1 char
            hashed = ((hashed + BIG_PRIME) - sequence.charAt(i) * firstLetter % BIG_PRIME) % BIG_PRIME;
            hashed = (hashed * RADIX + sequence.charAt(i+STR.length())) % BIG_PRIME;
            currentSection = sequence.substring(i, i + STR.length());
            if(hashed == strHash) {
                count++;
            }
        }
        return count;
    }

    // make recursive
    public static long hash (String toHash) {
        int current = 0;
        long hash = 0;
        // how to make this more efficient by only adding the last letter and removing the first
        for(int i = 0; i < toHash.length(); i++) {
            //hash = hash + (toHash.charAt(i)*(int)Math.pow(RADIX, (double)i-current) % BIG_PRIME);
            hash = (hash * RADIX + toHash.charAt(i)) % BIG_PRIME;
            current++;
        }
        return hash;
    }
}