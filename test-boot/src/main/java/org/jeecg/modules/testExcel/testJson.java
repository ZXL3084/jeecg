package org.jeecg.modules.testExcel;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-24
 * @Description:
 */
public class testJson {
    public static void main(String[] args) {
        String json="{\"min\":\"1\",\"max\":\"5\"}";
        JSONObject object=JSONObject.parseObject(json);
//        System.out.println(object.get("min"));
//        System.out.println(object.get("max"));


        String test="[{\"min\":\"1\",\"max\":\"5\",\"dimension\":\"1\"},{\"min\":\"1\",\"max\":\"5\",\"dimension\":\"2\"}]";
        JSONArray jsonArray=JSONArray.parseArray(test);
        Iterator<Object> iterator = jsonArray.stream().iterator();
        while (iterator.hasNext()){
            JSONObject o = (JSONObject) iterator.next();
            System.out.println(o.get("min"));
            System.out.println(o.get("max"));
        }

    }
}
