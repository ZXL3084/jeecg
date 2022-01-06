package org.jeecg.modules.properties;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhuxianglong
 * @date 2021-12-17 10:47
 */
@Setter
@Component
@ConfigurationProperties(prefix = "pc.ydyf")
public class PcYdyfProperties {

    private String accessId;

    private static PcYdyfProperties instance;

    public PcYdyfProperties() {
        instance = this;
    }

    public static String getAccessId() {
        return instance.accessId;
    }

}