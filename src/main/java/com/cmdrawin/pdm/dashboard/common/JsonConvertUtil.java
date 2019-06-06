package com.cmdrawin.pdm.dashboard.common;

import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

public class JsonConvertUtil {
	 /**
     * 
     * json字符串转换为List<Map<String,Object>>
     * 
     * @param jsonStr
     * @return
     */
    public static List<Map<String,Object>> StringToListMap(String jsonStr)
    {
        return JSON.parseObject(jsonStr,new TypeReference<List<Map<String,Object>>>(){});
    }
    
    /**
     * 
     * json字符串转换为 List<Object>
     * 
     * @param jsonStr
     * @return
     */
    public static List<Object> StringToListObject(String jsonStr)
    {
        return JSON.parseObject(jsonStr,new TypeReference<List<Object>>(){});
    }
    
    /**
     * 
     * json字符串转换为 List<Object>
     * 
     * @param jsonStr
     * @return
     */
    public static  <T> List<T>  StringToListT(String jsonStr,Class<T> tclass)
    {
    	  List<T> ts = (List<T>) JSONArray.parseArray(jsonStr, tclass);
          return ts;
    }
    /**
     * 
     * json字符串转换为Map<String,Object>>
     * 
     * @param jsonStr
     * @return
     */
    public static Map<String,Object> StringToMap(String jsonStr)
    {
        return JSON.parseObject(jsonStr,new TypeReference<Map<String,Object>>(){});
    }
    /**
     * 
     * json字符串转换为String[]
     * 
     * @param jsonStr
     * @return
     */
    public static String[] StringToArray(String jsonStr)
    {
        return JSON.parseObject(jsonStr,new TypeReference<String[]>(){});
    }
    

}
