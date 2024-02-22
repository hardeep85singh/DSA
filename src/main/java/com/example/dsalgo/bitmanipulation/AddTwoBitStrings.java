package com.example.dsalgo.bitmanipulation;

/**
 * @author Hardeep Singh
 * @since 05-02-2023
 */
public class AddTwoBitStrings {
    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("1101");
        StringBuilder str2 = new StringBuilder("11");
        System.out.println(addBitStrings(str1, str2));
        System.out.println(addBitStringBitManipulation(str1, str2));
    }

    public static String addBitStringBitManipulation(StringBuilder str1, StringBuilder str2){
        // To store the sum bits
        String result = "";
        // make same lengths before adding
        int length = makeEqualLength(str1, str2);

        // convert StringBuilder to Strings
        String first = str1.toString();
        String second = str2.toString();

        int carry = 0;

        // add all bits one by one
        for (int i = length-1; i >=0 ; i--){
            int firstBit = first.charAt(i) - '0';
            int secondBit = second.charAt(i) - '0';

            // boolean expression for sum of 3 bits
            int sum = (firstBit ^ secondBit ^ carry) + '0';

            result = String.valueOf((char) sum) + result;

            // boolean expression of 3-bit addition
            carry = (firstBit & secondBit) | (secondBit & carry) | (carry & firstBit);
        }

        // if overflown, then add a leading 1
        if(carry == 1){
            result = '1' + result;
        }
        return result;
    }

    private static int makeEqualLength(StringBuilder str1, StringBuilder str2){
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 < len2){
            for(int i = 0; i < (len2-len1); i++){
                str1.insert(0, '0');
            }
            return len2;
        } else if (len1 > len2){
            for(int i = 0; i < (len1-len2); i++){
                str2.insert(0, '0');
            }
        }
        return len1;
    }

    public static String addBitStrings(StringBuilder str1, StringBuilder str2){
        StringBuilder ans = new StringBuilder();
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0){
            if(i >= 0){
                carry = carry + str1.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                carry = carry + str2.charAt(j) - '0';
                j--;
            }
            ans.append(carry % 2);
            carry = carry / 2;
        }
        return ans.reverse().toString();
    }
}
