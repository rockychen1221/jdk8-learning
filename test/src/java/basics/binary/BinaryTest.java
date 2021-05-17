package src.java.basics.binary;


import org.junit.Test;

/**
 * 二进制算法位运算
 *
 * @author rockychen
 * @version 1.0
 * @date 2021-03-23 17:44
 */
public class BinaryTest {

    public static void main(String[] args) {
        System.out.println(-15 >> 1);
        System.out.println(3 >> 1);
        System.out.println(1 << 4);
        System.out.println(1 << 30);
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(-8));
        System.out.println(Integer.toBinaryString(-22));
        System.out.println(Integer.toBinaryString(-15));
    }

    /**
     * 按位与运算符（&）
     * 参加运算的两个数据，按二进制位进行“与”运算。
     *
     * 运算规则：0&0=0;  0&1=0;   1&0=0;    1&1=1;
     *
     *       即：两位同时为“1”，结果才为“1”，否则为0
     */
    @Test
    public void test1() {
        // 即 0000 0011& 0000 0101 = 00000001  因此，3&5的值得1。
        System.out.println(3 & 5);
    }

    /**
     * 按位或运算符（|）
     * 参加运算的两个对象，按二进制位进行“或”运算。
     *
     * 运算规则：0|0=0；  0|1=1；  1|0=1；   1|1=1；
     *
     *      即 ：参加运算的两个对象只要有一个为1，其值为1。
     *
     * 例如:3|5　即 00000011 | 0000 0101 = 00000111  因此，3|5的值得7。　
     *
     *
     *
     * 另，负数按补码形式参加按位或运算。
     *
     * “或运算”特殊作用：
     *
     * （1）常用来对一个数据的某些位置1。
     *
     * 方法：找到一个数，对应X要置1的位，该数的对应位为1，其余位为零。此数与X相或可使X中的某些位置1。
     *
     * 例：将X=10100000的低4位置1 ，用X | 0000 1111 = 1010 1111即可得到。
     */
    @Test
    public void test2(){
        System.out.println();
    }
}
