package org.jeecg.modules.demo.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.demo.entity.CcKefu;
import org.jeecg.modules.demo.demo.service.ICcKefuService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 呼叫中心客服
 * @Author: jeecg-boot
 * @Date:   2021-11-01
 * @Version: V1.0
 */
@Api(tags="呼叫中心客服")
@RestController
@RequestMapping("/demo/ccKefu")
@Slf4j
public class CcKefuController extends JeecgController<CcKefu, ICcKefuService> {
	@Autowired
	private ICcKefuService ccKefuService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ccKefu
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "呼叫中心客服-分页列表查询")
	@ApiOperation(value="呼叫中心客服-分页列表查询", notes="呼叫中心客服-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(CcKefu ccKefu,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<CcKefu> queryWrapper = QueryGenerator.initQueryWrapper(ccKefu, req.getParameterMap());
		Page<CcKefu> page = new Page<CcKefu>(pageNo, pageSize);
		IPage<CcKefu> pageList = ccKefuService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ccKefu
	 * @return
	 */
	@AutoLog(value = "呼叫中心客服-添加")
	@ApiOperation(value="呼叫中心客服-添加", notes="呼叫中心客服-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody CcKefu ccKefu) {
		ccKefuService.save(ccKefu);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ccKefu
	 * @return
	 */
	@AutoLog(value = "呼叫中心客服-编辑")
	@ApiOperation(value="呼叫中心客服-编辑", notes="呼叫中心客服-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody CcKefu ccKefu) {
		ccKefuService.updateById(ccKefu);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "呼叫中心客服-通过id删除")
	@ApiOperation(value="呼叫中心客服-通过id删除", notes="呼叫中心客服-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		ccKefuService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "呼叫中心客服-批量删除")
	@ApiOperation(value="呼叫中心客服-批量删除", notes="呼叫中心客服-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ccKefuService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "呼叫中心客服-通过id查询")
	@ApiOperation(value="呼叫中心客服-通过id查询", notes="呼叫中心客服-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		CcKefu ccKefu = ccKefuService.getById(id);
		if(ccKefu==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(ccKefu);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ccKefu
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, CcKefu ccKefu) {
        return super.exportXls(request, ccKefu, CcKefu.class, "呼叫中心客服");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, CcKefu.class);
    }

}
