package org.jeecg.modules.ccKefu.service;

import org.jeecg.modules.ccKefu.entity.CcKefuEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.ccKefu.req.KeFuPageListReq;
import org.jeecg.modules.util.PageWrapper;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zxl
 * @since 2021-11-15
 */
public interface ICcKefuService extends IService<CcKefuEntity> {

    PageWrapper<CcKefuEntity> getKeFuList(KeFuPageListReq req);


    CcKefuEntity getRedisById(String id);
}
