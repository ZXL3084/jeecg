package org.example.autoDemo;

import org.jeecg.modules.util.YouBianCodeUtil;
import org.junit.jupiter.api.Test;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-10
 * @Description:
 */
public class youBianCodeTest {

    @Test
    public void testCode(){
        System.out.println(YouBianCodeUtil.getNextYouBianCode("A01"));
        System.out.println(YouBianCodeUtil.getSubYouBianCode("A01","A01A05"));
    }
}
