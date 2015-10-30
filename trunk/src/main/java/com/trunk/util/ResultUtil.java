package com.trunk.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法描述:处理返回类型
 * 主要同意返回接口类型
 * @author 小刘
 * @version v1.0
 * @date 2015/10/30
 */
public class ResultUtil {

    /**
     * 实例化接口数据
     * @return
     */
    public static Map<String,Object> result(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",0);
        map.put("data","");
        map.put("msg","接口请求成功");
        return map;
    }
}
