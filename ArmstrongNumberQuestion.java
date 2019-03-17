/*
    An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself. For example, 371 is an Armstrong 
    number since 3**3 + 7**3 + 1**3 = 371. Given a number x, determine whether the given number is Armstrong number or not.
*/

public class ArmstrongNumberQuestion {
    public static boolean isArmstrongNumber(int number) {
        int armstrongTotal = 0;
        int x = number;

        while (x > 0) {
            armstrongTotal += Math.pow(x % 10, 3);
            x = x / 10;
        }

        return armstrongTotal == number;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrongNumber(371)); // true
        System.out.println(isArmstrongNumber(407)); // true
        System.out.println(isArmstrongNumber(399)); // false
    }
}

