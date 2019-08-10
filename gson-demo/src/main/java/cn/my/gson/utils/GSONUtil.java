package cn.my.gson.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Wjt
 * @Date: 2019/8/8 11:15
 * @ProjectName: json-demo
 * @Description:
 */
public class GSONUtil {

    private static Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();


    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 12:04 <br></br>
     * @Params: [t] T t <br></br>
     * @Return: java.lang.String <br></br>
     * @Description: 传入一个 对象 obj 将其转换为 json串, 空值会打印，日期格式 年-月-日  时：分：秒 <br></br>
     */
    public static <T> String toJSONString(T t) {
        return gson.toJson(t);
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 12:35 <br></br>
     * @Params: [bean]  T bean <br></br>
     * @Return: com.google.gson.JsonObject <br></br>
     * @Description: 将实体bean对象 转换为JsonObject <br></br>
     * 注意： 虽然 形参是泛型处理的，但是不要使用非键值数据结构的数据类型的对象 <br></br>
     *        比如 List<T>， T[]， Set<T> 等这种非键值存储结构 <br></br>
     */
    public static <T> JsonObject toJSONObject(T bean) {
        return gson.toJsonTree(bean).getAsJsonObject();
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 12:41 <br></br>
     * @Params: [map] Map<String, T> map <br></br>
     * @Return: com.google.gson.JsonObject <br></br>
     * @Description: 将 Map<String, T> map 集合转成 JsonObject <br></br>
     *
     */
    public static <T> JsonObject toJSONObject(Map<String, T> map) {
        return gson.toJsonTree(map).getAsJsonObject();
    }


    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 12:08 <br></br>
     * @Params: [list] List<T> list <br></br>
     * @Return: com.google.gson.JsonArray <br></br>
     * @Description: 将list集合转换为JsonArray， 空值会打印，日期格式 年-月-日  时：分：秒 <br></br>
     */
    public static <T> JsonArray toJSONArray(List<T> list) {
        return gson.toJsonTree(list).getAsJsonArray();
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 12:09 <br></br>
     * @Params: [tArray]  T[] tArray <br></br>
     * @Return: com.google.gson.JsonArray <br></br>
     * @Description: 将T[] 数组 转换为JsonArray， 空值会打印，日期格式 年-月-日  时：分：秒 <br></br>
     */
    public static <T> JsonArray toJSONArray(T[] tArray) {
        return gson.toJsonTree(tArray).getAsJsonArray();
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 12:20 <br></br>
     * @Params: [set] Set<T> set <br></br>
     * @Return: com.google.gson.JsonArray <br></br>
     * @Description: 将 Set集合转换为JsonArray <br></br>
     * 注意： HashSet 可以使用Object做泛型的时候，可以存空值，也可以每个obj的类型不一致 <br></br>
     *        但是使用TreeSet的时候不可以，你可以使用Object做泛型，但是不可以存数据类型不一致的obj <br></br>
     */
    public static <T> JsonArray toJSONArray(Set<T> set) {
        return gson.toJsonTree(set).getAsJsonArray();
    }


    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 13:17 <br></br>
     * @Params: [jsonString, clazz] String jsonString, Class<T> clazz <br></br>
     * @Return: T <br></br>
     * @Description: 从json串中 解析出 原来的对象 <br></br>
     * 注意： 类型要对应 <br></br>
     */
    public static <T> T fromJSONString(String jsonString, Class<T> clazz) {
        return gson.fromJson(jsonString, clazz);
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 13:41 <br></br>
     * @Params: [jsonString, list] String jsonString, List<T> list <br></br>
     * @Return: java.util.List<T> <br></br>
     * @Description: 将 jsonString 转换为 List<T> list集合 <br></br>
     * 注意： 类型要对应 <br></br>
     */
    public static <T> List<T> fromJSONString(String jsonString, List<T> list) {
        return gson.fromJson(jsonString, list.getClass());
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 13:49 <br></br>
     * @Params: [jsonString, set]  String jsonString, Set<T> set <br></br>
     * @Return: java.util.Set<T> <br></br>
     * @Description: 将jsonString 转换为 Set<T> set <br></br>
     * 注意： 类型对应 <br></br>
     */
    public static <T> Set<T> fromJSONString(String jsonString, Set<T> set) {
        return gson.fromJson(jsonString, set.getClass());
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 15:11 <br></br>
     * @Params: [jsonArray, tArray]  JsonArray jsonArray, T[] tArray <br></br>
     * @Return: T[] <br></br>
     * @Description: 将JsonArray 转换成 T[] 数组 <br></br>
     * 注意： 类型对应 <br></br>
     */
    public static <T> T[] fromJSONArray(JsonArray jsonArray, T[] tArray) {
        return (T[])gson.fromJson(jsonArray, tArray.getClass());
    }

    /**
     * @Author: Wjt
     * @Date: 2019/8/8 15:02
     * @Params: [jsonArray, list]  JsonArray jsonArray, List<T> list
     * @Return: java.util.List<T>
     * @Description: 将JsonArray 转换成 List<T> list
     * 注意： 类型对应
     */
    public static <T> List<T> fromJSONArray(JsonArray jsonArray, List<T> list) {
        return gson.fromJson(jsonArray, list.getClass());
    }


    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 14:59 <br></br>
     * @Params: [jsonArray, set] JsonArray jsonArray, Set<T> set <br></br>
     * @Return: java.util.Set<T> <br></br>
     * @Description: 将 JsonArray 转换成 Set<T> set <br></br>
     * 注意： 类型对应 <br></br>
     */
    public static <T> Set<T> fromJSONArray(JsonArray jsonArray, Set<T> set) {
        return gson.fromJson(jsonArray, set.getClass());
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 13:33 <br></br>
     * @Params: [jsonObject, map] JsonObject jsonObject, Map<String, T> map <br></br>
     * @Return: java.util.Map<java.lang.String,T> <br></br>
     * @Description: 将 JsonObject 转换为 Map<String, T> map <br></br>
     * 注意： 类型需对应 <br></br>
     */
    public static <T> Map<String, T> fromJSONObject(JsonObject jsonObject, Map<String, T> map) {
        return gson.fromJson(jsonObject, map.getClass());
    }

}
