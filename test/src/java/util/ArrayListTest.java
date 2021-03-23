package src.java.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList Tester.
 *
 * @author rockychen
 * @version 1.0
 * @since <pre>3月 22, 2021</pre>
 */
public class ArrayListTest {

    List<String> strList = new ArrayList<>();

    private void generateList() {
        strList.add("11");
        strList.add("22");
        strList.add("33");
    }


    @Test
    public void initList() {
        // 初始大小 elementData 数组没有长度 为{}
        ArrayList list = new ArrayList();
        System.out.println(list.size());

        // 初始指定大小，扩容机制
        ArrayList list15 = new ArrayList(15);
        System.out.println(list15.size());
        list15.add("11");
        System.out.println(list15.size());

        // 初始指定大小，扩容机制
        ArrayList list1 = new ArrayList(1);
        System.out.println(list1.size());
        list1.add("11");
        System.out.println(list1.size());

    }

}
