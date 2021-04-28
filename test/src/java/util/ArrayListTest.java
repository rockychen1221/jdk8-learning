package src.java.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * ArrayList Tester.
 *
 * @author rockychen
 * @version 1.0
 * @since <pre>3月 22, 2021</pre>
 */
public class ArrayListTest {

    private int threeSize = 3;

    /**
     * 返回自定义的3个长度list
     *
     * @return
     */
    private ArrayList<String> generateList() {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("11");
        strList.add("22");
        strList.add("33");
        return strList;
    }

    @Test
    public void initListTest() {
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
        list1.add("22");
        System.out.println(list1.size());

        ArrayList listMax = new ArrayList(Integer.MAX_VALUE - 1000000000);
        System.out.println(listMax.size());
    }

    @Test
    public void addTest() {
        List list = generateList();
        list.forEach(System.out::println);

        System.out.println("========");
        list.add(44);
        list.forEach(System.out::println);

        System.out.println("========");
        list.add(1, 1);
        list.forEach(System.out::println);

        System.out.println("========");
        list.addAll(Arrays.asList("a", "b", "c"));
        list.forEach(System.out::println);

        System.out.println("========");
        list.addAll(1, Arrays.asList("x", "y", "z"));
        list.forEach(System.out::println);

    }

    @Test
    public void removeTest() {
        List list = generateList();
        list.forEach(System.out::println);

        System.out.println("========");
        list.add(44);
        list.forEach(System.out::println);

        list.remove(55);// error

        // 重置size，清除所有值，触发GC回收释放空间，实则数组还在
        list.clear();
    }

    /**
     * remove 原理
     */
    @Test
    public void arrayCopyTest() {
        // 等同于list.remove(2);
        String[] strs = new String[]{"a", "b", "c", "d", "e", "f"};
        int length = strs.length, index = 2;
        System.arraycopy(strs, index + 1, strs, index, length - index - 1);
        Arrays.asList(strs).forEach(System.out::println);
        strs[--length] = null;
        System.out.println("====");
        Arrays.asList(strs).forEach(System.out::println);
    }

    /**
     * copy原理
     * 注意源数组下标不要越界
     */
    @Test
    public void copyOfTest() {
        String[] a = new String[]{"a", "b", "c", "d", "e", "f"};
        String[] b = new String[]{"1", "2", "3"};
        System.arraycopy(a, 2, b, 0, 3);
        Arrays.asList(a).forEach(System.out::println);
        System.out.println("=======");
        Arrays.asList(b).forEach(System.out::println);
    }

    /**
     * java.lang.IllegalStateException (迭代删除前必须先调用next())
     */
    @Test
    public void iteratorTest() {
        ArrayList list = generateList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next(); // 删除前必须调用next()
            iterator.remove();
            break;
        }
        Assert.assertEquals(list.size(), 2);

        Iterator iterator2 = list.iterator();

        System.out.println(iterator2.next());

        System.out.println("==========");

        iterator2.forEachRemaining(l -> {
            System.out.println(l);
        });
    }

    @Test
    public void listIteratorTest() {
        ArrayList list = generateList();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext() || listIterator.hasPrevious()) {
            System.out.println(listIterator.nextIndex());
            listIterator.next(); // 删除前必须调用next()
            listIterator.remove();
            break;
        }
        Assert.assertEquals(list.size(), 2);
    }

    @Test
    public void spliteratorTest() {
        ArrayList list = generateList();
        list.spliterator();
    }


    /**
     * java.lang.ConcurrentModificationException
     * 为什么在remove后还会调用next() ???
     */
    @Test
    public void forRemoveTest() {
        ArrayList<String> list = generateList();
        for (int i = 0; i < list.size(); i++) {
            if (i == 1) {
                list.remove(i);
            }
        }
        list.forEach(System.out::println);

        System.out.println("=======");

        for (String s : list) {
            System.out.println(s);
            if ("33".equals(s)) {
                list.remove(s);
            }
        }
        //list.forEach(System.out::println);

    }

    /**
     * list 清空掉未被利用的空间
     */
    @Test
    public void trimToSizeTest() {
        ArrayList list = generateList();
        Assert.assertEquals(list.size(), threeSize);
        // 重新分配空间，产生新的数组，大小和之前实际存储的大小相等，可节约空间
        list.trimToSize();
    }

    /**
     * 带参数的toArray() ???
     */
    @Test
    public void toArrayTest() {
        ArrayList list = generateList();
        Object[] objects = list.toArray();

        Assert.assertTrue(objects.length == threeSize);

        // Object [] integers = list.toArray(new Integer[]{1, 2}); // java.lang.ArrayStoreException
        Object[] strings = list.toArray(new String[]{"1", "2",});
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
        System.out.println(strings.length);
        // Assert.assertEquals(strings.length, 5);
    }

    /**
     * subList 会生成新的list吗
     */
    @Test
    public void subListTest() {
        ArrayList list = generateList();
        List subList = list.subList(0, 2);
        subList.forEach(System.out::println);
        System.out.println("======");
        // 修改subList , list会变吗？
        subList.set(0, "a");
        subList.add(1, "z");
        subList.forEach(System.out::println);
        System.out.println("=======");
        list.forEach(System.out::println);

        System.out.println("修改原list,新增一个值");
        list.add("44");
        list.forEach(System.out::println);
        System.out.println("=======");
        subList.forEach(System.out::println);
    }

    /**
     * 其他测试 set/indexOf/...
     */
    @Test
    public void otherTest() {
        ArrayList list = generateList();
        list.set(1, "set");

        Assert.assertTrue(list.contains("33"));
    }


}
