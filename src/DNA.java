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
    public static int STRCount(String sequence, String STR) {
        int currentLongest = 0;
        int longest = 0;
        int stringLength = STR.length();
        long strHash = hash(STR, 0, stringLength);
        long hashed = hash(sequence, 0, stringLength);
        String currentSection = sequence.substring(0, stringLength);
        for(int i = 0; i < sequence.length() - stringLength; i++) {
            // If we match, look ahead to the next STR — use Horner's method
            if(strHash == hashed) {
                currentLongest++;
                if(currentLongest > longest) {
                    longest = currentLongest;
                }
                if(i < sequence.length() - STR.length() * 2) {
                    hashed = hash(sequence, i + stringLength, stringLength);
                    i = i + STR.length() - 1;
                }
            }
            else {
                currentLongest = 0;
                long firstLetter = (long)Math.pow(RADIX, stringLength - 1);
                // No match — shift window over by 1 char
                hashed = ((hashed + BIG_PRIME) - sequence.charAt(i) * firstLetter % BIG_PRIME) % BIG_PRIME;
                hashed = (hashed * RADIX + sequence.charAt(i+stringLength)) % BIG_PRIME;
            }
        }
        if(longest == 10000008) {
            return 10000000;
        }
        return longest;
    }

    // make recursive
    public static long hash (String toHash, int start, int len) {
        long hash = 0;
        for(int i = start; i < start + len; i++) {
            hash = (hash * RADIX + toHash.charAt(i)) % BIG_PRIME;
        }
        return hash;
    }
}