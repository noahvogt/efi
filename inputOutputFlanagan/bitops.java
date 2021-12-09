import java.math.BigInteger;

public class bitops {

    public static void main(String arg[]) {
        /* a) - d) -> use BigInteger */

        BigInteger a1 = new BigInteger(Integer.toBinaryString(200), 2);
        BigInteger a2 = new BigInteger(Integer.toBinaryString(16), 2);
        System.out.println("16 + 200 = " + a1.add(a2).toString(2));
        System.out.println("16 - 200 = " + a1.subtract(a2).toString(2));

        BigInteger c1 = new BigInteger(Integer.toBinaryString(130), 2);
        int c2 = 3;
        System.out.println("130 >> 3 = " + c1.shiftRight(c2).toString(2));

        BigInteger d1 = new BigInteger(Integer.toBinaryString(130), 2);
        int d2 = 7;
        System.out.println("130 << 7 = " + d1.shiftLeft(d2).toString(2));

        /* e) - m) -> use int */

        System.out.println("250 >>> 3 = " + Integer.toString(250 >>> 3, 2));
        /* <<< doesn't work with int ??? */
        System.out.println("-3000 <<< 4 = " + Integer.toString(-3000 << 4, 2));
        System.out.println("~450 = " + Integer.toString(~450, 2));
        System.out.println("80 & 190 = " + Integer.toString(80 & 190, 2));
        System.out.println("100|(-390) = " + Integer.toString(100 | (-390), 2));
        System.out.println("(-1350)^(-4990) = " + Integer.toString((-1350) ^(-4990),2));
        System.out.println("(3000 & ~(-10 << 4)) | (1<<4) = " +
            Integer.toString((3000 & ~(-10 << 4)) | (1 << 4),2));
        System.out.println("(-3000 & ~(50 >> 2)) | (-10<<4) = " +
            Integer.toString((-3000 & ~(50 >> 2)) | (-10 << 4),2));
        System.out.println("(~300 & ~(20 << 4)) | (100 >> 4) = " +
            Integer.toString((~300 & ~(20 << 2)) | (100 >> 4),2));
    }
}
