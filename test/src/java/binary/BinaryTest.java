package src.java.binary;


/**
 * 二进制算法位运算
 * @author rockychen
 * @version 1.0
 * @date 2021-03-23 17:44
 */
public class BinaryTest {

    public static void main(String[] args) {
        System.out.println(-15 >> 1);
        System.out.println(1 >> 1);
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(-8));
        System.out.println(Integer.toBinaryString(-22));
        System.out.println(Integer.toBinaryString(-15));
    }
}
