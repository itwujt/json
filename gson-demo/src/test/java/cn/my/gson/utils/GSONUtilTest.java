package cn.my.gson.utils;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.Test;

import java.util.*;

/**
 * @Author: Wjt
 * @Date: 2019/8/8 11:24
 * @ProjectName: json-demo
 * @Description:
 */
public class GSONUtilTest {

    @Test
    public void test1() {
        /*Map<String, Object> map = new HashMap<>();*/
        Map<String, Object> map = new TreeMap<>();
        map.put("code", 200);
        map.put("msg", "成功转json");
        map.put("null", null);
        map.put("date", new Date());
        String s = GSONUtil.toJSONString(map);
        System.out.println(s);
    }

    @Test
    public void test2() {
        List<Object> list = new ArrayList<>();
        list.add("wujt");
        list.add("wangjm");
        list.add("在一起");
        list.add(null);
        String s = GSONUtil.toJSONString(list);
        System.out.println(s);
    }

    @Test
    public void test3() {
        List<Object> list = new ArrayList<>();
        list.add("wujt");
        list.add("wangjm");
        list.add("在一起");
        list.add(null);
        JsonArray jsonArray = GSONUtil.toJSONArray(list);
        for (JsonElement jsonElement : jsonArray) {
            System.out.println(jsonElement);
        }
    }

    @Test
    public void test4() {
        Object[] o = {1, "wjt", 1.0, null, ""};
        JsonArray jsonArray = GSONUtil.toJSONArray(o);
        for (JsonElement jsonElement : jsonArray) {
            System.out.println(jsonElement);
        }
    }

    @Test
    public void test5() {
        Set<Object> set = new HashSet<>();
        set.add("wjt");
        set.add("wjm");
        set.add(null);
        set.add(new Date());
        JsonArray jsonArray = GSONUtil.toJSONArray(set);
        for (JsonElement jsonElement : jsonArray) {
            System.out.println(jsonElement);
        }
    }

    @Test
    public void test6() {
        Set<Object> set = new TreeSet<>();
        set.add("wjt");
        set.add("wjm");
        JsonArray jsonArray = GSONUtil.toJSONArray(set);
        for (JsonElement jsonElement : jsonArray) {
            System.out.println(jsonElement);
        }
    }

    @Test
    public void test7() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "成功转json");
        map.put("null", null);
        map.put("date", new Date());
        JsonObject jsonObject = GSONUtil.toJSONObject(map);
        System.out.println(jsonObject);
    }

    @Test
    public void test8(){
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("wjt");
        list.add(null);
        list.add(new Date());
        JsonObject jsonObject = GSONUtil.toJSONObject(list);
        System.out.println(jsonObject);
    }

    @Test
    public void test9() {
        Map<String, List<Object>> map = new HashMap<>();
        List<Object> list = new ArrayList<>();
        list.add("wjt");
        list.add(1);
        list.add(new Date());
        list.add(null);
        map.put("list", list);
        JsonObject jsonObject = GSONUtil.toJSONObject(map);
        System.out.println(jsonObject);

    }

    @Test
    public void test10() {
        String str = "12345, 上山打老虎";
        String string = GSONUtil.toJSONString(str);
        String string1 = GSONUtil.fromJSONString(string, String.class);
        System.out.println(string1);
    }

    @Test
    public void test11() {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("wjt");
        list.add(null);
        list.add(new Date());
        String string = GSONUtil.toJSONString(list);
        List list1 = GSONUtil.fromJSONString(string, List.class);
        for (Object o : list1) {
            System.out.println(o);
        }
    }

    @Test
    public void test12() {
        Set<String> set = new HashSet<>();
        set.add("wujt");
        set.add("wangjm");
        String string = GSONUtil.toJSONString(set);
        Set<String> set1 = GSONUtil.fromJSONString(string, Set.class);
        for (String s : set1) {
            System.out.println(s);
        }
    }

    @Test
    public void test13() {
        Map<String, List<Object>> map = new HashMap<>();
        Map<String, List<Object>> map1 = new HashMap<>();
        List<Object> list = new ArrayList<>();
        list.add("wjt");
        list.add(1);
        list.add(new Date());
        list.add(null);
        map.put("list", list);
        JsonObject jsonObject = GSONUtil.toJSONObject(map);
        Map<String, List<Object>> map2 = GSONUtil.fromJSONObject(jsonObject, map1);
        for (Map.Entry<String, List<Object>> entry : map2.entrySet()) {
            System.out.println(entry);
        }
    }

    @Test
    public void test14() {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add("wjt");
        list.add(null);
        list.add(new Date());

        String string = GSONUtil.toJSONString(list);
        List<Object> list1 = GSONUtil.fromJSONString(string, new ArrayList<Object>());
        for (Object o : list1) {
            System.out.println(o);
        }

    }

    @Test
    public void test15() {
        Set<String> set = new TreeSet<>();
        set.add("wjm");
        set.add("wjt");
        JsonArray jsonArray = GSONUtil.toJSONArray(set);
        Set<String> strings = GSONUtil.fromJSONArray(jsonArray, new TreeSet<String>());
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void test16() {
        Set<String> set = new TreeSet<>();
        set.add("wjm");
        set.add("wjt");
        String string = GSONUtil.toJSONString(set);
        Set<String> strings = GSONUtil.fromJSONString(string, new TreeSet<String>());
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void test17() {
        String[] arr = new String[2];
        arr[0] = "12345";
        arr[1] = "67890";
        JsonArray jsonArray = GSONUtil.toJSONArray(arr);
        String[] strings = GSONUtil.fromJSONArray(jsonArray, new String[arr.length]);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}