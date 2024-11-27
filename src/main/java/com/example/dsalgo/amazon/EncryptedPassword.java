package com.example.dsalgo.amazon;

public class EncryptedPassword {
    public static void main(String[] args) {
        String password = "yxxy";
        int x = 3;
        int y = 5;
        int z = 10;
        char ch = 't';
        char ca = 't';
        char cc = 'i';
        System.out.println(++z + y - y + z + x++);
        System.out.println(findEncryptedPassword(password));
    }

    public static String findEncryptedPassword(String password){
        int[] countChars = new int[27];

        // count characters for number of characters lexicographically
        for(int i = 0; i< password.length(); i++){
            if(password.charAt(i) != ' '){
                countChars[password.charAt(i) - 'a']++;
            } else {
                countChars[countChars.length-1]++;
            }
        }

        // we can now make new string lexicographically
        char[] newPasswordChars = new char[password.length()];
        int lengthNewPassword = password.length();

        int k = 0;
        for(int i = 0; i < countChars.length; i++){
            int j = 0;
            while (countChars[i] > 0){
                if(password.charAt(k) == ' '){
                    newPasswordChars[k] = ' ';
                    newPasswordChars[lengthNewPassword - k - 1] = ' ';
                    countChars[countChars.length-1] = countChars[countChars.length-1]-2;
                } else {
                    newPasswordChars[k+j] = (char) ('a' + i);
                    newPasswordChars[lengthNewPassword - k - 1 - j] = (char) ('a' + i);
                    countChars[i] = countChars[i] -2;
                    j++;
                }
                k++;
            }
        }

        return String.valueOf(newPasswordChars);
    }
}
