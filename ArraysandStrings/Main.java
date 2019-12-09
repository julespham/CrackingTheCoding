import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        //System.out.println(palindromePermutation("tact coa"));
        //System.out.println(oneArray("pale", "palesd"));
        System.out.println(stringCompression("abcccccaaa"));
        // int[][] arr = { { 0, 2 }, { 3, 4 } }; 
        // int[][] temp = zeroMatrix(arr);
        // for(int i=0; i < temp.length ; i++) {
        //     for(int j=0; j<temp[i].length; j++){
        //         System.out.println(temp[i][j]);
        //     }
        // }
    }

    /**
     * Implement an alogorithm to determine if a string has all unique characters. 
     * What if you cannot use additional data strucutres?
     */
    public static boolean isUnique(String s1) {
        char[] temp = s1.toCharArray();
        Arrays.sort(temp);
        for(int curr=0; curr<temp.length - 1; curr++) {
            if (curr+1 > temp.length) {
                return true;
            }
            if (temp[curr] == temp[curr+1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Given two strings, write a method to decide if one permutation of the other. 
     * Solution: HashMap < char, int> int for number of occurances, < 0 or != 0 
     */
    public static boolean checkPermutation(String s1, String s2) {
        HashMap<Character, Integer> occurances = new HashMap<>();
        if (s1.length != s2.length) {
            return false;
        }
        char[] letters = s1.toCharArray();
        for(char curr : letters) {
            int currVal = occurances.putIfAbsent(curr, 1);
            occurances.put(curr, currVal+1);
        }
        char[] s2letters = s2.toCharArray();
        for(char curr : s2letters) {
            if(occurances.containsKey(curr)) {
               int val = occurances.get(curr);
               if (val < 0) {
                   return false;
               }
               occurances.put(curr, val--);
            }
        }
        for(Map.Entry<Character, Integer> entry : occurances.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Write a method to replace all spaces in a string with '%20'.
     * Use a character array.
     * Solution: move backawards
     */
    public static String urlify(String s1) {
        String replacedString = "";
        char[] temp = s1.toCharArray();
        int numspaces = 0;
        for(char curr : temp) {
            if (curr == " ") {
                numspaces++;
            }
        }
        int padding = temp.length + numspaces - 1;
        for(int i=temp.length-1; i>=0; i--) {
            if(temp[i] != " "){
                temp[padding--] = '0';
                temp[padding--] = '2';
                temp[padding--] = '%';

            } else {
                temp[padding] = temp[i];
            }
            --padding;
        }
        return replacedString;
    }


    /**
     * Given a string, write a function to check if its a permutation of a palindrome. 
     * A palindrome is a word or phrase that is the same forwards and backwards.
     * A permutation is a rearrangement of letters.
     * The palindrome does not need to be limited to just dictionary words.
     * if the length is even, all even occurances
     * if the length is odd, only one occurance
     */
    public static boolean palindromePermutation(String s1) {
        HashMap<Character, Integer> letters = new HashMap<>();
        char[] temp = s1.toCharArray();
        for(char curr : temp) {
            if(letters.containsKey(curr)) {
                letters.put(curr, letters.get(curr)+1);
            } else{
                letters.put(curr, 1);
            }
        }
        int occurances = 0;
        for(Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if(letters.length % 2 == 0) {
                if(entry.getValue() % 2 != 0) {
                    return false;
                }
            } else {
                if (entry.getValue() % 2 == 1) {
                    occurances++;
                }
                if (occurances > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * There are three types of edits that can be performed on strings
     * Insert a charcter, remove a character, or replace a character. 
     * Given two strings, write a function to check if they are one edit (or zero edits) away.
     * Example. pale, ple -> true
     * pales, pale -> true
     * pale, bale -> true
     * pale, bake -> false
     * solution: iterate through s1 and s2
     */
    public static boolean oneArray(String s1, String s2) {
        int edits = 0;
        for(char c1 : s1.toCharArray()) {
            for(char c2 : s2.toCharArray()){
                if (c1 != c2) {
                    edits++;
                }
                if (edits > 1) {
                    return false;
                }
            }
        }
        
        return true;
    }

    /**
     * Implement a method to perform basic string compression using the counts of repeated characters.
     * For example, aabcccccaaa would become a2b1c5a3.
     * If the "compressed" string would not become smaller than the original string, 
     * your method should return the original string. 
     * You can assume the string has only uppercase and lowercase letters.
     */
    public static String stringCompression(String s1) {
        StringBuilder sb = new StringBuilder();
        char[] temp = s1.toCharArray();
        int index = 0;
        int count = 1;
        for(char curr : temp) {
            if (sb.length() == 0) {
                sb.append(curr);
                continue;
            }
            if (sb.charAt(index) != curr) {
                sb.append(count);
                sb.append(curr); 
                count = 1;
                index+=2;
                continue;
            } 
            count++;
        }
        sb.append(count);
        if (sb.length() > s1.length()) {
            return s1;
        }
        return sb.toString();
    }

    /**
     * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes.
     * Write a method to rotatethe image by 90 degres. 
     * Can you do this in place?
     */
    public static void rotateMatrix() {

    }

    /**
     * Write an algorithm such that is an element is an MxN matrix is 0, 
     * its entire row and column are set to 0.
     */
    public static int[][] setColumnZero(int[][] a, int row, int col) {
        for(int curr = row; curr < a.length; curr++) {
            a[curr][col] = 0;
        }
        return a;
    }

    // public static int[][] setRowZero(int[][] a, int row, int col) {
    //     for(int curr = col; curr<a[row].length; curr++) {
    //         a[row][curr] = 0;
    //     }
    //     return a;
    // }

    public static int[][] zeroMatrix(int[][] a) {
        int[][] zeroes = a;
        for(int row = 0; row < a.length; row++) {
            for(int col=0; col < a[row].length; col++){
                if(a[row][col] == 0) {
                    zeroes = setColumnZero(zeroes, row, col);
                    //zeroes = setRowZero(zeroes, row, col);
                    Arrays.fill(zeroes[row], 0);
                    continue;
                }
            }
        }
        return zeroes;
    }

    /**
     * Assume you have a method isSubstring which checks if one word is a substring of another
     * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 
     * using only one call to isSubstring. 
     */
    public static void stringRotation() {

    }
}