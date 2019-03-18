import java.util.*;
import java.lang.Integer;

/*
    A palindrome number is a number that is same after reverse. For example 545, 151, 34543, 343, 171, 48984
    are the palindrome numbers. It can also be a string like LOL, MADAM etc.
*/

class PalindromeQuestion {
    public static boolean isPalindrome(int num) {
        String numString  = (new Integer(num)).toString();
        
        return isPalindrome(numString);
    }

    public static boolean isPalindrome(String word) {
        List<String> numList = Arrays.asList(word.split(""));

        Collections.reverse(numList);

        return String.join("", numList).equalsIgnoreCase(word);
    }

    public static void main(String[] args) {
        int num = 454;
        int incorrectNum = 726;
        String word = "Racecar";
        String incorrectWord = "Noah";

        System.out.printf("%d is %s\n", num, isPalindrome(num));
        System.out.printf("%d is %s\n", incorrectNum, isPalindrome(incorrectNum));
        System.out.printf("%s is %s\n", word, isPalindrome(word));
        System.out.printf("%s is %s\n", incorrectWord, isPalindrome(incorrectWord));
    }
}