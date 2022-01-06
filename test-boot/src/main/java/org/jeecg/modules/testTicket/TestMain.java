package org.jeecg.modules.testTicket;

import org.jeecg.modules.ccKefu.entity.SaleTicket;
import org.jeecg.modules.properties.PcYdyfProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import javax.swing.plaf.TableHeaderUI;
import java.util.Map;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-26
 * @Description:
 */
public class TestMain {

    @Test
    public void test(){
//        SaleTicket saleTicket = new SaleTicket(10);
//        for (int i = 0; i < 10; i++) {
//            new Thread(saleTicket::sale,"票贩子-"+i).start();
//        }

        System.out.println(PcYdyfProperties.getAccessId()+"-------------");

    }
}
