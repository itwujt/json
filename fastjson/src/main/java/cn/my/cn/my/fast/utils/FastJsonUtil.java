package cn.my.cn.my.fast.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Wjt
 * @Date: 2019/8/8 19:37
 * @ProjectName: json-demo
 * @Description:
 */
public class FastJsonUtil {

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/8 19:42 <br></br>
     * @Params: [t]  T t <br></br>
     * @Return: java.lang.String <br></br>
     * @Description: 将 T t 转换为 String jsonString <br></br>
     * 空值处理， 日期处理 <br></br>
     */
    public static <T> String toJSONString(T t) {
        return JSON.toJSONString(t,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteDateUseDateFormat);
    }


    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/10 21:13 <br></br>
     * @Params: [tArray] T[] tArray <br></br>
     * @Return: com.alibaba.fastjson.JSONArray <br></br>
     * @Description: 根据 参数 数组 转成JSONArray <br></br>
     */
    public static <T> JSONArray toJSONArray(T[] tArray) {
        return JSON.parseArray(toJSONString(tArray));
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/10 21:17 <br></br>
     * @Params: [list] List<T> list <br></br>
     * @Return: com.alibaba.fastjson.JSONArray <br></br>
     * @Description: 将 List<T> list 集合转换成 JSONArray <br></br>
     */
    public static <T> JSONArray toJSONArray(List<T> list) {
        return JSON.parseArray(toJSONString(list));
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/10 21:23 <br></br>
     * @Params: [set] Set<T> set <br></br>
     * @Return: com.alibaba.fastjson.JSONArray <br></br>
     * @Description: 将Set<T>  set集合 转换为JSONArray <br></br>
     * 注意： 要使用TreeSet的时候，注意该set有排序功能，切勿使用Object来做泛型 <br></br>
     * 不是说Object不可以做泛型， 而是说避免使用它， 以防带来存储不同数据类型的异常后果 <br></br>
     */
    public static <T> JSONArray toJSONArray(Set<T> set) {
        return JSON.parseArray(toJSONString(set));
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/10 22:26 <br></br>
     * @Params: [t] T t <br></br>
     * @Return: com.alibaba.fastjson.JSONObject <br></br>
     * @Description: 将 T t 转换成 JSONObject <br></br>
     * 注意：不要将 数组，List，Set等集合作为参数传入， JSONArray 不能 转换成JSONObject <br></br>
     * 可以传入Map Bean 是键值 类型的数据 <br></br>
     */
    public static <T> JSONObject toJSONObject(T t) {
        return JSON.parseObject(toJSONString(t));
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/10 21:20 <br></br>
     * @Params: [jsonArray, clazz] JSONArray jsonArray, Class<T> clazz <br></br>
     * @Return: java.util.List<T> <br></br>
     * @Description: 将JSONArray 解析成 List<T> list 集合 <br></br>
     */
    public static <T> List<T> parseJSONArrayToList(JSONArray jsonArray, Class<T> clazz) {
        return JSON.parseArray(toJSONString(jsonArray), clazz);
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/10 22:04 <br></br>
     * @Params: [jsonArray, set] JSONArray jsonArray, Set<T> set <br></br>
     * @Return: java.util.Set<T> <br></br>
     * @Description: 将 JSONArray 解析成 Set<T> set <br></br>
     * 注意： TreeSet泛型的使用 <br></br>
     */
    public static <T> Set<T> parseJSONArrayToSet(JSONArray jsonArray, Set<T> set) {
        return JSON.parseObject(toJSONString(jsonArray), set.getClass());
    }


    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/10 22:09 <br></br>
     * @Params: [jsonArray, clazz] JSONArray jsonArray, Class<T> clazz <br></br>
     * @Return: T <br></br>
     * @Description: 将 JSONArray 解析成 T t，支持数组的解析 <br></br>
     */
    public static <T> T parseJSONArrayToObject(JSONArray jsonArray, Class<T> clazz) {
        return JSON.parseObject(toJSONString(jsonArray), clazz);
    }

    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/10 22:17 <br></br>
     * @Params: [jsonString, map] String jsonString, Map<String, T> map <br></br>
     * @Return: java.util.Map<java.lang.String,T> <br></br>
     * @Description: 将jsonString 解析成 Map<String, T> map <br></br>
     * 注意： 不要将单纯的String 类型的数据 转换成JSONString 来传入，因为并非键值对模式，不会解析出Map <br></br>
     */
    public static <T> Map<String, T> parseJSONStringToMap(String jsonString, Map<String, T> map) {
        return JSON.parseObject(jsonString, map.getClass());
    }


    /**
     * @Author: Wjt <br></br>
     * @Date: 2019/8/11 15:37 <br></br>
     * @Params: [json, clazz] JSON json, Class<T> clazz <br></br>
     * @Return: T <br></br>
     * @Description: 将 JSON 解析为javaObject <br></br>
     * 注意： 如果是要解析成 List，Set，集合形式的话，请使用 parseJSONArrayToObject方法 <br></br>
     * 该方法不支持解析成List，Set等集合，但是支持解析为数组 <br></br>
     */
    public static <T> T parseJSONToObject(JSON json, Class<T> clazz) {
        return JSON.toJavaObject(json, clazz);
    }




}
