package com.example.dsalgo.strings;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Hardeep Singh
 */
@Service
public class StringProblems {

    public void reverseString(String str) {
        String newString = "";

        for (int i = 0; i < str.length(); i++) {
            newString += str.charAt(str.length() - 1 - i);
        }
        System.out.println("Reverse String: " + newString);
    }

    public void reverseStringRecursive(String str, int index, String newString) {
        if (index == 0) {
            newString += str.charAt(0);
            System.out.println("Reverse String recursive: " + newString);
            return;
        }
        char c = str.charAt(index);
        newString += c;
        reverseStringRecursive(str, index - 1, newString);
    }

    // Brute force
    public void removeDuplicatesUsingArray(String str) {

        char[] chars = new char[26];
        String newString = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            chars[ch - 'a'] = ch;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                newString += chars[i];
            }
        }

        System.out.println("Remove duplicates: " + newString);
    }

    public void removeDuplicatesHashSet(String str) {
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            hashSet.add(str.charAt(i));
        }
        String newString = "";
        for (char ch : hashSet) {
            newString += ch;
        }
        System.out.println("Remove duplicates: " + newString);
    }

    public void removeDuplicatesIndexOf(String str) {
        String newString = new String();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (newString.indexOf(ch) < 0) {
                newString = newString + ch;
            }
        }
        System.out.println("Remove duplicates: " + newString);
    }

    public void removeDuplicates(String str) {
        char[] chars = str.toCharArray();
        String newString = "";
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (chars[i] == chars[j]) {
                    break;
                }
            }
            if (j == i) {
                newString = newString + chars[j];
            }
        }
        System.out.println("Remove duplicates: " + newString);
    }

    public boolean[] map = new boolean[26];

    public void removeDuplicatesRecursive(String str, int idx, String newString) {
        if (idx == str.length()) {
            System.out.println("Remove Duplicates Recursively: " + newString);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            removeDuplicatesRecursive(str, idx + 1, newString);
        } else {
            newString = newString + currChar;
            map[currChar - 'a'] = true;
            removeDuplicatesRecursive(str, idx, newString);
        }
    }

    public void subSequencesRecursive(String str, int idx, String newString) {
        if (idx == str.length()) {
            System.out.println("Subsequences: " + newString);
            return;
        }
        char currChar = str.charAt(idx);
        subSequencesRecursive(str, idx + 1, newString + currChar);
        subSequencesRecursive(str, idx + 1, newString);
    }

    static HashSet<String> set = new HashSet<>();

    public void subsequencesUniqueStringsRecursive(String str, int idx, String newString) {
        if (idx == str.length()) {
            if (!set.contains(newString)) {
                System.out.println(newString);
                set.add(newString);
            }
            return;
        }

        char currChar = str.charAt(idx);
        subsequencesUniqueStringsRecursive(str, idx + 1, newString + currChar);
        subsequencesUniqueStringsRecursive(str, idx + 1, newString);
    }

    public boolean isPalindrome(String str) {
        String str1 = str.toLowerCase();
        String newStr = "";

        // iff string contains special characters
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) - 'a' < 26 && str1.charAt(i) - 'a' >= 0) {
                newStr += str1.charAt(i);
            }
        }

        for (int i = 0; i < newStr.length() / 2; i++) {
            if (newStr.charAt(i) != newStr.charAt(newStr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeRecursive(String str, int firstIdx, int lastIdx) {
        if (firstIdx == lastIdx) {
            return true;
        }
        if (str.charAt(firstIdx) != str.charAt(lastIdx)) {
            return false;
        }
        if (firstIdx < lastIdx + 1) {
            return isPalindromeRecursive(str, firstIdx + 1, lastIdx - 1);
        }
        return true;
    }

    // can also be done by sorting the strings and check for each character's equality
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr_s = new int[26];
        int[] arr_t = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr_s[s.charAt(i) - 'a']++;
            arr_t[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr_s.length; i++) {
            if (arr_s[i] != arr_t[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean validParentheses(String str) {
        for (int i = 0; i < str.length() - 1; i = i + 2) {
            char c = str.charAt(i);
            if (c != str.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    // aaabaaa -> aba
    public String removeConsecutiveCharacter(String str) {
        String newStr = "";
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            if (c != str.charAt(i + 1)) {
                newStr = newStr + c;
            }
        }
        return newStr + str.charAt(str.length() - 1);
    }

    public String removeConsecutiveCharRecursive(String input) {
        if (input.length() <= 1) {
            return input;
        }
        if (input.charAt(0) == input.charAt(1)) {
            return removeConsecutiveCharRecursive(input.substring(1));
        } else {
            return input.charAt(0) + removeConsecutiveCharRecursive(input.substring(1));
        }
    }

    public String longestCommonPrefix(String[] strings, int n) {
        String prefix = strings[0];
        for (int i = 1; i < n; i++) {
            prefix = longestCommonPrefixTwoStrings(prefix, strings[i]);
        }
        return prefix;
    }

    public String longestCommonPrefixTwoStrings(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();

        // Compare str1 and str2
        for (int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }

        return (result);
    }

    public String lCPCharByChar(String[] strings) {
        int n = strings.length;
        int minLenStr = findMinimumLength(strings);
        String newStr = "";

        for (int i = 0; i < minLenStr; i++) {
            char current = strings[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (strings[j].charAt(i) != current) {
                    return newStr;
                }
            }
            newStr = newStr + current;
        }
        return newStr;
    }

    public int findMinimumLength(String[] strings) {
        int min = strings[0].length();
        int minIndex = -1;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() < min) {
                min = strings[i].length();
                minIndex = i;
            }
        }
        return min;
    }

    public void printDuplicatesAndCount(String str) {
        int[] countArr = new int[255];

        for (int i = 0; i < str.length(); i++) {
            countArr[str.charAt(i)]++;
        }
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] > 1) {
                System.out.println("Duplicate Character : " + (char) (i) + ", Count: " + countArr[i]);
            }
        }
    }

    public int longestSubstringRemovingDuplicates(String str) {
        int[] countArr = new int[255];
        String newStr = "";

        for (int i = 0; i < str.length(); i++) {
            countArr[str.charAt(i)]++;
        }
        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] >= 1) {
                newStr += (char) (i);
            }
        }
        return newStr.length();
    }

    public int findLengthOfMaxSubstringByReplacingChar(String str, int k) {
        int maxLength = 1;
        for (int i = 0; i < 26; i++) {
            maxLength = Math.max(maxLength, findLength(str, k, (char) (i + 'A')));
            maxLength = Math.max(maxLength, findLength(str, k, (char) (i + 'a')));
        }
        return maxLength;
    }

    // aabcd, ch-> c, k=2
    public int findLength(String str, int k, char ch) {
        int count = 0;
        int maxLength = 1;
        int left = 0;
        int right = 0;
        while (right < str.length()) {
            if (str.charAt(right) != ch) {
                count++;
            }
            while (count > k) {
                if (str.charAt(left) != ch) {
                    count--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public void groupAnagrams(String[] strings) {

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);
            ArrayList<String> arr = new ArrayList<>();
            if (hashMap.containsKey(sortedStr)) {
                hashMap.get(sortedStr).add(strings[i]);
            } else {
                arr.add(strings[i]);
                hashMap.put(sortedStr, arr);
            }
        }
        for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public int longestPalindromeInString(String str) {
        int n = str.length();
        if (n < 2) {
            return n;
        }
        int maxLength = 1;
        int low = 0, high = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;
            while (high < n && str.charAt(high) == str.charAt(i)) {
                high++;
            }
            while (low >= 0 && str.charAt(low) == str.charAt(i)) {
                low--;
            }
            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                low--;
                high++;
            }
            int length = high - low - 1;
            if (maxLength < length) {
                maxLength = length;
                start = low + 1;
            }
        }

        System.out.print("Longest palindrome substring is: ");
        System.out.println(str.substring(start, start + maxLength));
        return maxLength;
    }

    public void countPalindromeSubstrings(String str) {

        int n = str.length();
        if (n < 2) {
            return;
        }
        int high = 0;
        int low = 0;
        int count = 0;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            low = i - 1;
            high = i + 1;

            while (high < n && str.charAt(i) == str.charAt(high)) {
                list.add(str.substring(i, high + 1));
                high++;
                count++;
            }
            while (low >= 0 && str.charAt(low) == str.charAt(i)) {
                list.add(str.substring(low, i + 1));
                low--;
                count++;
            }
            while (low >= 0 && high < n && str.charAt(low) == str.charAt(high)) {
                list.add(str.substring(low, high + 1));
                high++;
                low--;
                count++;
            }
        }
        HashSet<String> hashSet = new HashSet<>();
        for (String str1 : list) {
            hashSet.add(str1);
        }
        System.out.println(hashSet.stream().count());
        System.out.println(hashSet);

    }

    public void findPalindromeSubstrings(String str) {
        if (str == null) {
            return;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            // for odd length
            expandString(str, i, i, set);
            // for even length
            expandString(str, i, i + 1, set);
        }
        System.out.println(set.stream().count());
        System.out.println(set);
    }

    public void expandString(String str, int low, int high, Set<String> set) {

        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            set.add(str.substring(low, high + 1));
            high++;
            low--;
        }

    }

    public int countAnagramsSorting(String str, String subStr){
        int count = 0;
        int n = str.length();
        int k = subStr.length();
        for (int i = 0; i< n - k; i++){
            String temp = str.substring(i,k+i);
            boolean isEqual = checkCharsForEquality(subStr, temp);
            if(isEqual){
                count++;
            }
        }
        return count;
    }

    private boolean checkCharsForEquality(String subStr, String temp) {
        char [] ch1 = subStr.toCharArray();
        char [] ch2 = temp.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for(int i = 0; i< ch1.length; i++){
            if(ch1[i] != ch2[i]){
                return false;
            }
        }
        return true;
    }
    public int countAnagramsUsingArray(String str, String subString){
        int CHARACTERS = 256;
        int n = str.length();
        int k = subString.length();
        int count = 0;
        if(n < 0 || k < 0 || n < k){
            return 0;
        }
        char [] strArray = new char[CHARACTERS];
        char [] subStrArray = new char[CHARACTERS];

        for(int i = 0; i < k; i++){
            strArray[CHARACTERS - str.charAt(i)] ++;
            subStrArray[CHARACTERS - subString.charAt(i)] ++;
        }
        if(Arrays.equals(strArray, subStrArray)){
            count++;
        }

        for(int i = k; i< n; i++ ){
            strArray[CHARACTERS - str.charAt(i)] ++;
            strArray[CHARACTERS - str.charAt(i - k)] --;
            if(Arrays.equals(strArray, subStrArray)){
                count++;
            }
        }
        return count;
    }

    public int countAnagramsMap(String str, String subStr) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < subStr.length(); i++) {
            if(!map.containsKey(subStr.charAt(i))){
                map.put(subStr.charAt(i), 1);
            } else{
                int j = map.get(subStr.charAt(i));
                map.put(subStr.charAt(i), j++);
            }
        }
        int count = 0;
        Map<Character, Integer> tempMap = new HashMap<>();
        int i = 0;
        for(int j = 0; j< str.length(); j++){
            char ch = str.charAt(i);
            tempMap.put(ch, tempMap.getOrDefault(ch, 0) + 1);
            if(j - i +1 == subStr.length()){
                if(isAnagramMap(map, tempMap)){
                    count++;
                }
                tempMap.put(str.charAt(i), tempMap.get(str.charAt(i))-1);
                i++;
            }
        }
        return count;
    }

    private boolean isAnagramMap(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for(char c : map1.keySet()){
            if(map1.get(c) != map2.get(c)){
                return false;
            }
        }
        return true;
    }
}
