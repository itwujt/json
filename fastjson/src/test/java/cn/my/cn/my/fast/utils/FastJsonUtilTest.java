package cn.my.cn.my.fast.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Wjt
 * @Date: 2019/8/8 19:43
 * @ProjectName: json-demo
 * @Description:
 */
public class FastJsonUtilTest {

    @Test
    public void test1() {
        List<Object> list = new ArrayList<>();
        list.add("wjt");
        list.add("wjm");
        list.add(null);
        list.add(new Date());
        String string = FastJsonUtil.toJSONString(list);
        System.out.println(string);

        String str = "12345";
        String string1 = FastJsonUtil.toJSONString(str);
        System.out.println(string1);
    }

    @Test
    public void test2() {
        List<Object> list = new ArrayList<>();
        list.add("wjt");
        list.add("wjm");
        list.add(null);
        list.add(new Date());
        String string = FastJsonUtil.toJSONString(list);
        System.out.println(string);
    }

    @Test
    public void test3() {
        Integer[] nums = {1, 2, 3};
        JSONArray jsonArray = FastJsonUtil.toJSONArray(nums);
        for (Object o : jsonArray) {
            System.out.println(o);
        }
    }


    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("wjt");
        list.add("wjm");

        JSONArray jsonArray = FastJsonUtil.toJSONArray(list);
        for (Object o : jsonArray) {
            System.out.println(o);
        }
    }

    @Test
    public void test5() {
        Set<Object> set = new HashSet<>();
        set.add("str");
        set.add(1);
        set.add(null);
        set.add(new Date());
        JSONArray jsonArray = FastJsonUtil.toJSONArray(set);
        for (Object o : jsonArray) {
            System.out.println(o);
        }
    }

    @Test
    public void test6() {
        Set<String> set = new TreeSet<>();
        set.add("str");
        set.add("wjt");
        JSONArray jsonArray = FastJsonUtil.toJSONArray(set);
        for (Object o : jsonArray) {
            System.out.println(o);
        }
    }

    @Test
    public void test7() {
        List<String> list = new ArrayList<>();
        list.add("wjt");
        list.add("wjm");
        JSONArray jsonArray = FastJsonUtil.toJSONArray(list);
        List<String> list1 = FastJsonUtil.parseJSONArrayToList(jsonArray, String.class);
        for (String s : list1) {
            System.out.println(s);
        }
    }

    @Test
    public void test8() {
        Set<String> set = new TreeSet<>();
        set.add("str");
        set.add("wjt");
        JSONArray jsonArray = FastJsonUtil.toJSONArray(set);
        Set<String> strings = FastJsonUtil.parseJSONArrayToSet(jsonArray, new TreeSet<String>());
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void test9() {
        String[] arr = {"1", "s", "w"};
        JSONArray jsonArray = FastJsonUtil.toJSONArray(arr);
        String[] strings = FastJsonUtil.parseJSONArrayToObject(jsonArray, String[].class);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void test10() {
        String[] arr = {"1", "s", "w"};
        JSONArray jsonArray = FastJsonUtil.toJSONArray(arr);
        Set<String> strings = FastJsonUtil.parseJSONArrayToSet(jsonArray, new TreeSet<String>());
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void test11() {
        List<String> list = new ArrayList<>();
        list.add("wjt");
        list.add("wjm");
        JSONArray jsonArray = FastJsonUtil.toJSONArray(list);
        Set<String> strings = FastJsonUtil.parseJSONArrayToSet(jsonArray, new HashSet<String>());
        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void test12() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        map.put("list", list);
        String jsonSring = FastJsonUtil.toJSONString(map);
        Map<String, List<Integer>> map1 = FastJsonUtil.parseJSONStringToMap(jsonSring, new HashMap<String, List<Integer>>());
        for (Map.Entry<String, List<Integer>> stringListEntry : map1.entrySet()) {
            System.out.println(stringListEntry);
        }
        System.out.println(map1);
    }

    @Test
    public void test13() {
        String s = "12345";
        String jsonString = FastJsonUtil.toJSONString(s);
        Map<String, String> stringStringMap = FastJsonUtil.parseJSONStringToMap(jsonString, new HashMap<String, String>());
        System.out.println(stringStringMap);
    }

    @Test
    public void test14() {
        Map<String, String> map = new HashMap<>();
        map.put("code", "200");
        JSONObject jsonObject = FastJsonUtil.toJSONObject(map);
        System.out.println(jsonObject);
    }

}