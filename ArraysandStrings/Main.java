import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Main {
    public static void main(String[] args) {
        //System.out.println(palindromePermutation("tact coa"));
        //System.out.println(oneArray("pale", "palesd"));
        System.out.println(stringCompression("aabcccccaaa"));

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
     */
    public static boolean checkPermutation(String s1, String s2) {
        HashSet<Char> unique = new HashSet<>();
        if (Math.abs(s1.length - s2.length) != 0) {
            return false;
        }
        char[] letters = s1.toCharArray();
        for(char curr : letters) {
            unique.add(curr);
        }
        char[] s2letters = s2.toCharArray();
        for(char curr : s2letters) {
            if (!unique.contains(curr)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Write a method to replace all spaces in a string with '%20'.
     * Use a character array.
     */
    public static String urlify(String s1) {
        String replacedString = "";
        char[] temp = s1.toCharArray();
        for(int i=0; i<temp.length; i++) {
            if (temp[i] == " ") {
                replacedString += "%20";
            }
            replacedString+=temp[i];
        }
        return replacedString;
    }


    /**
     * Given a string, write a function to check if its a permutation of a palindrome. 
     * A palindrome is a word or phrase that is the same forwards and backwards.
     * A permutation is a rearrangement of letters.
     * The palindrome does not need to be limited to just dictionary words.
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
        for(Map.Entry<Character, Integer> entry : letters.entrySet()) {
            if (entry.getValue() == 1) {
                continue;
            }
            if(entry.getValue() % 2 == 1) {
                return false;
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
     */
    public static boolean oneArray(String s1, String s2) {
        HashSet<Character> letters = new HashSet();
        char[] temp = s1.toCharArray();
        for(char curr : temp) {
            letters.add(curr);
        }
        int edits = 0;
        char[] compareString = s2.toCharArray();
        for(char curr : compareString) {
            if (!letters.contains(curr)) {
                edits++;
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
    public static void zeroMatrix(int[][] a) {
        
    }

    /**
     * Assume you have a method isSubstring which checks if one word is a substring of another
     * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 
     * using only one call to isSubstring. 
     */
    public static void stringRotation() {

    }
}