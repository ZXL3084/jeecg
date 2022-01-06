package org.jeecg.modules.ccKefu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-26
 * @Description:
 */
@Data
@AllArgsConstructor
public class SaleTicket {

    private int ticket;
    @SneakyThrows //处理中断异常
    @Synchronized
    public void sale(){  //售票操作
        while(this.ticket>0){
            TimeUnit.SECONDS.sleep(1);//模拟异常
            System.out.println("{"+Thread.currentThread().getName()+"],售票，ticket="+this.ticket--);
        }

    }
}
