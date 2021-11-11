package org.jeecg.modules.ccKefu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.jeecg.modules.ccKefu.entity.CcKefuEntity;
import org.jeecg.modules.ccKefu.req.KeFuPageListReq;
import org.jeecg.modules.ccKefu.service.ICcKefuService;
import org.jeecg.modules.util.JWTUtils;
import org.jeecg.modules.util.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxl
 * @since 2021-11-03
 */
@RestController
@RequestMapping("/ccKefu")
public class CcKefuController {

    @Autowired
    ICcKefuService ccKefuService;

    @Resource
    JWTUtils jwtUtils;

    @GetMapping("/getPageList")
    @ApiOperation("分页查询")
    public PageWrapper<CcKefuEntity> getPageList(@ModelAttribute("req") KeFuPageListReq req){
      return ccKefuService.getKeFuList(req);
    }


    @GetMapping("/redis/{id}")
    @ApiOperation("查询所有")
    public CcKefuEntity getById(@PathVariable("id") String id){
        return ccKefuService.getRedisById(id);
    }

    @GetMapping("/login")
    @ApiOperation("登录")
    public CcKefuEntity login() throws UnsupportedEncodingException {
        Map<String,String> map=new HashMap<>();
        map.put("name","小明");
        CcKefuEntity ccKefuEntity=new CcKefuEntity();
        ccKefuEntity.setContext(jwtUtils.getToken(map));
        return ccKefuEntity;
    }
}
