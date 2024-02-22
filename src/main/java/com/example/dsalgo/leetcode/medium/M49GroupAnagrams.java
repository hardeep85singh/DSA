package com.example.dsalgo.leetcode.medium;

import java.util.*;

/**
 * @author Hardeep Singh
 */
public class M49GroupAnagrams {
    public static void main (String[] args){
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramsAuxArrayForSorting(s));
    }
    public static List<List<String >> groupAnagramsAuxArrayForSorting(String[] strs){
        if(strs.length == 0){
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];

        for(int i = 0; i < strs.length; i++){
            Arrays.fill(count, 0);
            String str = strs[i];
            char[] chars = str.toCharArray();
            for(int j = 0; j < chars.length; j++){
                count[chars[j] - 'a'] ++;
            }
            String sortedStr = "";
            for(int k = 0; k < count.length; k++){
                if(count[k] != 0){
                    while (count[k] != 0) {
                        sortedStr = sortedStr + (k + 'a');
                        count[k]--;
                    }
                }
            }
            if(!ans.containsKey(sortedStr)){
                ans.put(sortedStr, new ArrayList<>());
            }
            ans.get(sortedStr).add(str);
        }
        return new ArrayList(ans.values());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            List<String> temp = new ArrayList<>();
            temp.add(str);
            String sortedStr = sortString(str);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr, temp);
            } else {
                List<String> list = map.get(sortedStr);
                list.add(str);
                map.put(sortedStr, list);
            }
        }
        for(Map.Entry<String , List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String result = "";
        for(int i = 0; i< chars.length; i++){
            result = result + chars[i];
        }
        return result;
    }
}
