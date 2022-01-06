package org.jeecg.modules.ccKefu.controller;


import io.swagger.annotations.ApiOperation;
import org.jeecg.modules.ccKefu.entity.CcKefuEntity;
import org.jeecg.modules.ccKefu.req.KeFuPageListReq;
import org.jeecg.modules.ccKefu.service.ICcKefuService;
import org.jeecg.modules.util.JWTUtils;
import org.jeecg.modules.util.PageWrapper;
import org.jeecg.modules.util.Result;
import org.jeecg.modules.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/ccKefu")
public class CcKefuController {

    @Autowired
    ICcKefuService ccKefuService;

    @Autowired
    JWTUtils jwtUtils;

    @Value("${source.name}")
    private String name;

    @Value("${source.message}")
    private List<String> message;

    @Value("#{${source.infos}}") //EL表达式
    private Map<String,String> map;

    @GetMapping("/getPageList")
    @ApiOperation("分页查询")
    public PageWrapper<CcKefuEntity> getPageList(@ModelAttribute("req") KeFuPageListReq req){
        System.out.println(name);
        System.out.println(message);
        System.out.println(map);
      return ccKefuService.getKeFuList(req);
    }


    @GetMapping("/redis/{id}")
    @ApiOperation("查询所有")
    public CcKefuEntity getById(@PathVariable("id") String id){
        return ccKefuService.getRedisById(id);
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public Result login() throws UnsupportedEncodingException {
        Map<String,String> map=new HashMap<>();
        map.put("name","小明");
        return ResultUtil.success(jwtUtils.getToken(map));
    }

}
