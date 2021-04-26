package src.java.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * LinkedList Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>3月 26, 2021</pre>
 */
public class LinkedListTest {

    private int threeSize = 3;

    /**
     * 返回自定义的3个长度list
     *
     * @return
     */
    private LinkedList<String> generateList() {
        LinkedList<String> strList = new LinkedList<>();
        strList.add("11");
        strList.add("22");
        strList.add("33");
        // fsdf
        return strList;
    }


    @Test
    public void initListTest() {
        // 初始大小
        LinkedList list = new LinkedList();
        list.add("1");
        System.out.println(list.size());

        //
        LinkedList list3 = new LinkedList(generateList());
        System.out.println(list3.size());
        list3.add("11");
        System.out.println(list3.size());
    }

    /**
     * 查询效率快慢原理
     */
    @Test
    public void getTest(){
        LinkedList list = generateList();
        System.out.println(list.get(0));
        System.out.println(list.get(2));

        list.contains("1"); //全搜索
    }

    public void removeTest(){
        LinkedList list = generateList();
        list.remove();
    }

}
