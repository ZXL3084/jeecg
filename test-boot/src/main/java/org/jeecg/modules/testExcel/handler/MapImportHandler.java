package org.jeecg.modules.testExcel.handler;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import cn.afterturn.easypoi.util.PoiPublicUtil;

import java.util.Map;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-16
 * @Description:
 */
public class MapImportHandler extends ExcelDataHandlerDefaultImpl<Map<String,Object>> {

    @Override
    public void setMapValue(Map<String, Object> map, String originKey, Object value) {
        if (value instanceof Double) {
            map.put(getRealKey(originKey), PoiPublicUtil.doubleToString((Double) value));
        } else {
            map.put(getRealKey(originKey), value != null ? value.toString() : null);
        }
    }

    private String getRealKey(String originKey){
        if (originKey.equals("姓名")){
            return "name";
        }
        if (originKey.equals("学生性别")){
            return "sex";
        }
        return originKey;
    }

    @Override
    public void setNeedHandlerFields(String[] needHandlerFields) {
        super.setNeedHandlerFields(needHandlerFields);
    }
}
