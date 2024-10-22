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
        int currentLongest = 0;
        int longest = 0;
        long strHash = hash(STR, 0, STR.length());
        long hashed = hash(sequence, 0, STR.length());
        String currentSection = sequence.substring(0, STR.length());
        for(int i = 0; i < sequence.length() - STR.length(); i++) {
            //long hashed = hash(currentSection);
            // If we match, look ahead to the next STR — use Horner's method
            if(strHash == hashed) {
                count++;
                currentLongest++;
                if(currentLongest > longest) {
                    longest = currentLongest;
                }
                if(i < sequence.length() - STR.length() * 2) {
                    hashed = hash(sequence, i + STR.length(), STR.length());
                    i = i + STR.length() - 1;
                }
            }
            else {
                currentLongest = 0;
                // make STR.length() variable
                long firstLetter = (long)Math.pow(RADIX, STR.length() - 1);
                // No match — shift window over by 1 char
                hashed = ((hashed + BIG_PRIME) - sequence.charAt(i) * firstLetter % BIG_PRIME) % BIG_PRIME;
                hashed = (hashed * RADIX + sequence.charAt(i+STR.length())) % BIG_PRIME;
            }
        }
        return longest;
    }

    // make recursive
    public static long hash (String toHash, int start, int len) {
        long hash = 0;
        for(int i = start; i < start + len; i++) {
            //hash = hash + (toHash.charAt(i)*(int)Math.pow(RADIX, (double)i-current) % BIG_PRIME);
            hash = (hash * RADIX + toHash.charAt(i)) % BIG_PRIME;
        }
        return hash;
    }
}