/*
    Convert binary to decimal Convert hexadecimal to binary
*/

public class DecimalConvert {

    public static int toDecimal(int binary) {
        int decimal = 0;
        int power = 0;

        while (binary != 0) {
            decimal += ((binary % 10) * Math.pow(2, power));
            binary = binary / 10;
            power++;
        }

        return decimal;
    } 

    public static int toBinary(int decimal) {
        StringBuilder builder = new StringBuilder();

        while (decimal != 0) {
            int d = decimal % 2;
            builder.append(d);
            decimal /= 2;
        }

        return Integer.valueOf(builder.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(toDecimal(1111100111));
        System.out.println(toBinary(999));
    } 
}