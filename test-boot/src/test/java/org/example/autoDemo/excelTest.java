package org.example.autoDemo;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecg.modules.ccKefu.entity.CcKefuEntity;
import org.jeecg.modules.ccKefu.req.KeFuPageListReq;
import org.jeecg.modules.ccKefu.service.ICcKefuService;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-12
 * @Description:
 */
public class excelTest {


    @Resource
    ICcKefuService ccKefuService;

    @Test
    public void excel(){
        KeFuPageListReq req=new KeFuPageListReq();
        req.setName("李");
        req.setSex("2");
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("客服信息","客服"), CcKefuEntity.class, (Collection<?>) ccKefuService.getKeFuList(req));

    }
}
