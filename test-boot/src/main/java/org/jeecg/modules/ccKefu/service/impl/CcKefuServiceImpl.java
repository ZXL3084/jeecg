package org.jeecg.modules.ccKefu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import org.jeecg.modules.ccKefu.entity.CcKefuEntity;
import org.jeecg.modules.ccKefu.mapper.CcKefuMapper;
import org.jeecg.modules.ccKefu.req.KeFuPageListReq;
import org.jeecg.modules.ccKefu.service.ICcKefuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.util.PageWrapper;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zxl
 * @since 2021-11-03
 */
@Service
public class CcKefuServiceImpl extends ServiceImpl<CcKefuMapper, CcKefuEntity> implements ICcKefuService {

    @Override
    public PageWrapper<CcKefuEntity> getKeFuList(KeFuPageListReq req) {
        IPage<CcKefuEntity> page=new Page<>(req.getPageNum(), req.getPageSize());
        LambdaQueryWrapper<CcKefuEntity> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.likeRight(StringUtils.isNotBlank(req.getName()),CcKefuEntity::getName,req.getName())
                    .eq(StringUtils.isNotBlank(req.getSex()),CcKefuEntity::getSex,req.getSex());
        page=this.baseMapper.selectPage(page,queryWrapper);
        return PageWrapper.build(page,page.getRecords());
    }

    @Override
    @Cacheable(value = "getRedisById",key = "#id")
    public CcKefuEntity getRedisById(String id) {
        CcKefuEntity ccKefuEntity = this.baseMapper.selectById(id);
        System.out.println("查数据库-----");
        System.out.println(ccKefuEntity);
        return ccKefuEntity;
    }
}
