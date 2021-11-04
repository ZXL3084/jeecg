package org.jeecg.modules.ccKefu.service;

import org.jeecg.modules.ccKefu.entity.CcKefuEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.ccKefu.req.KeFuPageListReq;
import org.jeecg.modules.util.PageWrapper;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxl
 * @since 2021-11-03
 */
public interface ICcKefuService extends IService<CcKefuEntity> {

    PageWrapper<CcKefuEntity> getKeFuList(KeFuPageListReq req);


    CcKefuEntity getRedisById(String id);
}
