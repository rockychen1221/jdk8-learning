package src.java.util;


import org.junit.Test;

import java.util.ArrayList;

/**
 * ArrayList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>3月 22, 2021</pre>
 */
public class ArrayListTest {

    @Test
    public void initList() {
        // 初始大小
        ArrayList list = new ArrayList();
        System.out.println(list.size());

        // 初始大小
        ArrayList list1 = new ArrayList(15);
        System.out.println(list1.size());

        list1.add("11");
        System.out.println(list1.size());

    }

    public static void main(String[] args) {
        System.out.println(-15>>1);
        System.out.println(Integer.toBinaryString(7));
        System.out.println(Integer.toBinaryString(-15));
    }

}
