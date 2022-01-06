package org.jeecg.modules.ccKefu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther: ZhuXiangLong
 * @Date: 2021-11-26
 * @Description:
 */
@Data
//访问器模式
//@Accessors(fluent = true)    //代码链形式  person.name("张三").age(18).sex("男");
//@Accessors(chain = true)    //有代码链         p.setName("张三").setAge(18).setSex("男");
//@Accessors(prefix = "tt")    //生成get、set去掉前缀
//构建者模式
@Builder   //Person.builder().ttName("张三").ttAge(18).ttSex("男").build();
public class Person {

    private String ttName;

    private Integer ttAge;

    private String ttSex;
}
