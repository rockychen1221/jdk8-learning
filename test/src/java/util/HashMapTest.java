package src.java.util;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author rockychen
 * @version 1.0
 * @date 2021-04-26 15:20
 */
public class HashMapTest {

    /**
     * 返回自定义的3个长度list
     *
     * @return
     */
    private HashMap<String, String> generateMap() {
        return new HashMap(3) {{
            put("1", "11");
            put("2", "22");
            put("3", "33");
        }};
    }

    @Test
    public void initMap(){
        HashMap map = new HashMap();


        HashMap map3 = generateMap();

    }

}
