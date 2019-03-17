/* 
    Given a string of characters, return its equivalent integer (a/A = 1, b/B = 2...)
    Example 1: Input: abcdefg Output: 1324567
*/

import java.lang.*;

public class CharToIntQuestion {

    // Carefully not to reach max int size
    public static int charToInt(String characters) throws NumberFormatException {
        StringBuilder intEquvalent = new StringBuilder();

        for (char character : characters.toCharArray()) {
            character = Character.toLowerCase(character);

            intEquvalent.append((int) character - 'a');
        }

        return Integer.valueOf(intEquvalent.toString());
    }

    public static void main(String[] args) {
        try {
            System.out.println(charToInt("aBcD"));
            System.out.println(charToInt("efg"));
            System.out.println(charToInt("hij"));
            System.out.println(charToInt("kLM"));
            System.out.println(charToInt("NOpq"));
            System.out.println(charToInt("rsT"));
            System.out.println(charToInt("uvW"));
            System.out.println(charToInt("XYZ"));
        catch (NumberFormatException e) {
            System.out.println("Max int size most likely reached");
            e.printStackTrace();
        }
    }
}