package cn.java18.utils;

import java.util.HashMap;
import java.util.Map;

public class RestBean{
    public static final String CODE= "code";
    public static final String MSG = "msg";
    public static final String COUNT= "count";
    public static final String DATA = "data";

    public static Map<String,Object> getMapPara(){
        HashMap<String, Object> oom = new HashMap<>();
        oom.put(MSG,"失败");
        oom.put(CODE,1);
        return oom;
    }
}
