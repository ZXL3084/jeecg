package org.jeecg.modules.testExcel.module;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-18
 * @Description:
 */
public class testModule {

    static String PATH="E:/easyExcel";
    public static void main(String[] args) throws IOException {
        TemplateExportParams params=new TemplateExportParams(PATH+"/模板_map.xlsx");
        Map<String,Object> map=new HashMap<>();
        map.put("caiZhengBianMa","cz001");
        map.put("shenQinDanWei","建设云");
        map.put("date","2021-11-18");
        map.put("upperMoney","贰佰万");
        map.put("zhiFuDanWei","建设云");
        map.put("bureau","中情局");
        map.put("person","齐天大圣");
        map.put("phone","888888");
        List<Map<String,String>> listMap=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Map<String,String> lm=new HashMap<>();
            lm.put("id","123456");
            lm.put("type","公款");
            lm.put("code","gk001");
            lm.put("name","研发公款");
            lm.put("projectName","金眼睛");
            lm.put("quanChen","五子协同");
            lm.put("yinHangId","132459811861651");
            lm.put("yinHang","中国很行");
            lm.put("shengQinNum","100000");
            lm.put("heDinNum","100000");
            listMap.add(lm);
        }
        map.put("listMap",listMap);

        Workbook workbook= ExcelExportUtil.exportExcel(params,map);
        FileOutputStream fos = new FileOutputStream(PATH+"/专项支出用款申请书成品.xlsx");
        workbook.write(fos);
        fos.close();
        System.out.println("专项支出用款申请书成品----生成成功！");

    }
}
