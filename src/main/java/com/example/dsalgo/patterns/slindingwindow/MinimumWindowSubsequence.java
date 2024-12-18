package com.example.dsalgo.patterns.slindingwindow;

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        String str1 = "abcdebdde";
        String str2 = "bde";

        System.out.println(minWindow(str1, str2));
    }

    public static String minWindow(String str1, String str2) {

        // Save the size of str1 and str2
        int sizeStr1 = str1.length();
        int sizeStr2 = str2.length();

        // Initialize length to a very large number (infinity)
        float minSubLen = Float.POSITIVE_INFINITY;

        // Initialize pointers to zero and the minSubsequence to an empty string
        int indexS1 = 0;
        int indexS2 = 0;
        int start = 0, end = 0;
        String minSubsequence = "";

        // Process every character of str1
        while (indexS1 < sizeStr1) {
            // Check if the character pointed by indexS1 in str1
            // is the same as the character pointed by indexS2 in
            if (str1.charAt(indexS1) == str2.charAt(indexS2)) {
                // If the pointed character is the same
                // in both strings increment indexS2
                indexS2 += 1;
                // Check if indexS2 has reached the end of str2
                if (indexS2 == sizeStr2) {
                    // At this point the str1 contains all characters of str2
                    start = indexS1;
                    end = indexS1;
                    // Initialize start to the index where all characters of
                    // str2 were present in str1
                    indexS2 -= 1;
                    // Decrement pointer indexS2 and start a reverse loop
                    while (indexS2 >= 0) {
                        // Decrement pointer indexS2 until all characters of
                        // str2 are found in str1
                        if (str1.charAt(start) == str2.charAt(indexS2)) {
                            indexS2 -= 1;
                        }

                        // Decrement start pointer everytime to find the
                        // starting point of the required subsequence
                        start -= 1;
                    }
                    start += 1;
                    // Check if length of sub sequence
                    // by start and end pointers is less than current min length
                    if ((end - start + 1) < minSubLen) {
                        // Update minSubLen if current sub sequence is
                        minSubLen = end - start + 1;
                        // Update minimum subsequence string
                        // to this new shorter string
                        minSubsequence = str1.substring(start, end + 1);
                    }
                    // Set indexS1 to start to continue checking in str1
                    // after this discovered subsequence
                    indexS1 = start;
                    indexS2 = 0;
                }
            }
            // Increment pointer indexS1 to check next character in str1
            indexS1 += 1;
        }
        return minSubsequence;
    }
}
